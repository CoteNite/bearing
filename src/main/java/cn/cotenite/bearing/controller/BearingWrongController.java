package cn.cotenite.bearing.controller;

import cn.cotenite.bearing.common.response.Response;
import cn.cotenite.bearing.domain.po.Bearing;
import cn.cotenite.bearing.domain.vo.req.BearingAddVO;
import cn.cotenite.bearing.domain.vo.req.BearingUpdateVO;
import cn.cotenite.bearing.domain.vo.req.PageReqVO;
import cn.cotenite.bearing.domain.vo.rsp.BearingDetailVO;
import cn.cotenite.bearing.domain.vo.rsp.BearingWrongDetailVO;
import cn.cotenite.bearing.domain.vo.rsp.PageRspVO;
import cn.cotenite.bearing.service.BearingWrongService;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/7/2025 7:19 PM
 */
@RestController
@SaCheckLogin
@RequestMapping("/bearingWrong")
public class BearingWrongController {

    @Resource
    private BearingWrongService bearingWrongService;

    @GetMapping("/list")
    public Response<PageRspVO<BearingWrongDetailVO>> list(PageReqVO reqVO, String name, Integer status){
        List<BearingWrongDetailVO> bearingDetailList = bearingWrongService.getBearingDetailList(reqVO, name, status);
        return Response.success(PageRspVO.<BearingWrongDetailVO>builder()
                        .pageSize(Long.valueOf(bearingDetailList.size()))
                        .dataList(bearingDetailList)
                        .pageCurrent(Long.valueOf(reqVO.getPageCurrent()))
                .build());
    }


}
