package com.pipikai.enums;

/**
 * 消息枚举类
 * 统一管理，方便维护
 */
public enum HttpResultEnum {
    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    TOO_YOUNG(100, "小于10。今天也要加油鸭！"),
    YOUNG(100, "小于18。今天也要加油鸭！");

    private Integer code;
    private String msg;

    HttpResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
