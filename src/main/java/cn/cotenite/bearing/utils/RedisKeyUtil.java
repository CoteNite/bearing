package cn.cotenite.bearing.utils;

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

    public static String buildUserRoleKey(String userId){
        return PREFIX+"user:role:"+userId;
    }

    public static String buildUserHashKey(){
        return PREFIX+"user:hash";
    }

    public static String buildUserWorkKey(){
        return PREFIX+"user:working";
    }

    public static String buildBearingWrongKey(){
        return PREFIX+"bearing:wrong";
    }

}
