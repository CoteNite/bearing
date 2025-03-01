package cn.cotenite.bearing.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/25/2025 8:54 PM
 */
public class SnowFlakUtil {

    public static String getSnowFlakeId(){
        Snowflake secondSnow = IdUtil.getSnowflake(1,1);
        return secondSnow.nextIdStr();
    }

    public static Long getSnowFlakeIdLong(){
        Snowflake secondSnow = IdUtil.getSnowflake(1,1);
        return secondSnow.nextId();
    }

}
