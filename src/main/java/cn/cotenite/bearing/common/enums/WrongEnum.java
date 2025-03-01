package cn.cotenite.bearing.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/1/2025 9:11 PM
 */
@Getter
@AllArgsConstructor
public enum WrongEnum {

    NORMAL("正常", 0),
    INNER_RING_LEVEL_ONE("内圈一级", 1),
    BALL_RING_LEVEL_ONE("滚珠圈一级", 2),
    OUTER_RING_LEVEL_ONE("外圈一级", 3),
    INNER_RING_LEVEL_TWO("内圈二级", 4),
    BALL_RING_LEVEL_TWO("滚珠圈二级", 5),
    OUTER_RING_LEVEL_TWO("外圈二级", 6),
    INNER_RING_LEVEL_THREE("内圈三级", 7),
    BALL_RING_LEVEL_THREE("滚珠圈三级", 8),
    OUTER_RING_LEVEL_THREE("外圈三级", 9);

    private String doc;
    private Integer code;

    public static WrongEnum getByDoc(String doc) {
        for (WrongEnum type : values()) {
            if (type.doc.equals(doc)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No document type with doc: " + doc);
    }

    public static WrongEnum getByCode(int code) {
        for (WrongEnum type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("No document type with code: " + code);
    }

    public static String getWrong(int code){
        WrongEnum[] values = WrongEnum.values();
        for (WrongEnum item:values){
            if (item.getCode()==code) {
                return item.getDoc();
            }
        }
        return null;
    }
}
