package cn.cotenite.bearing.common.utils;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/25/2025 8:47 PM
 */
public class RedisKeyUtil {

    public static String PREFIX="bearing:";

    public static String buildCaptchaKey(String key){
        return PREFIX+"captcha:"+key;
    }
}
