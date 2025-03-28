package cn.cotenite.bearing.service.impl;

import cn.cotenite.bearing.domain.dto.UserRedisDTO;
import cn.cotenite.bearing.domain.vo.req.BearingStatusReqVO;
import cn.cotenite.bearing.domain.vo.rsp.WorkOrderReqVO;
import cn.cotenite.bearing.service.BearingWrongService;
import cn.cotenite.bearing.utils.RedisKeyUtil;
import cn.cotenite.bearing.utils.SnowFlakUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.cotenite.bearing.domain.po.WordOrder;
import cn.cotenite.bearing.service.WordOrderService;
import cn.cotenite.bearing.mapper.WordOrderMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author 29543
* @description 针对表【word_order】的数据库操作Service实现
* @createDate 2025-03-02 06:06:16
*/
@Slf4j
@Service
public class WordOrderServiceImpl extends ServiceImpl<WordOrderMapper, WordOrder> implements WordOrderService{

    @Resource
    private WordOrderMapper wordOrderMapper;

    @Resource
    private BearingWrongService bearingWrongService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;


    @Override
    public void createOrder() {
        Boolean hasKey = redisTemplate.hasKey(RedisKeyUtil.buildBearingWrongKey());

        if (!hasKey){
            return;
        }

        Long mapSize = redisTemplate.opsForHash().size(RedisKeyUtil.buildBearingWrongKey());

        if(mapSize==0){
            return;
        }

        Map<Object, Object> wrongMap = redisTemplate.opsForHash().entries(RedisKeyUtil.buildBearingWrongKey());

        for (Map.Entry<Object, Object> entry:wrongMap.entrySet()){
            Long size = redisTemplate.opsForSet().size(RedisKeyUtil.buildUserWorkKey());

            if (size==0){
                continue;
            }

            if(redisTemplate.hasKey(RedisKeyUtil.buildUserWorkKey())){
                Long workerId=(Long)redisTemplate.opsForSet().pop(RedisKeyUtil.buildUserWorkKey());
                redisTemplate.delete(RedisKeyUtil.buildUserWorkKey());
                String wrongId=(String) entry.getKey();
                BearingStatusReqVO reqVO=(BearingStatusReqVO) entry.getValue();
                UserRedisDTO userRedisDTO = (UserRedisDTO) redisTemplate.opsForHash().get(RedisKeyUtil.buildUserHashKey(), workerId.toString());

                WordOrder wordOrder = WordOrder.builder()
                        .orderNumber(SnowFlakUtil.getSnowFlakeIdLong())
                        .bearingId( reqVO.getBearingId())
                        .wrong(reqVO.getWrong())
                        .realName(userRedisDTO.getRealName())
                        .build();

                wordOrderMapper.insert(wordOrder);
                bearingWrongService.updateStatus2Paring(Long.valueOf(wrongId));

                redisTemplate.opsForHash().delete(RedisKeyUtil.buildBearingWrongKey(),wrongId);
                log.info("订单生成成功");
            }else {
                log.warn("当前无工人空闲");
            }
        }
    }

    @Override
    public Page<WorkOrderReqVO> getList(Page<WorkOrderReqVO> page, Long id, String realName, Integer wrong, Integer status) {
        return wordOrderMapper.selectPage4List(page,id,realName,wrong,status);
    }
}




