package cn.cotenite.bearing.utils;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/2/2025 2:24 AM
 */
public class TimeUtil {

    public static boolean isWorkNow(String startTime, String endTime) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime start = LocalTime.parse(startTime, formatter);
            LocalTime end = LocalTime.parse(endTime, formatter);
            LocalTime current = LocalTime.now();
            if (end.isAfter(start)) {
                return !current.isBefore(start) && !current.isAfter(end);
            } else {
                return !current.isBefore(start) || !current.isAfter(end);
            }
        } catch (Exception e) {
            System.err.println("时间格式错误: " + e.getMessage());
            return false;
        }
    }

    public static Long betweenNow2EndLong(String endTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime now = LocalTime.now();
        LocalTime end = LocalTime.parse(endTime, formatter);
        Duration duration = Duration.between(now, end);
        return duration.getSeconds();
    }


}
