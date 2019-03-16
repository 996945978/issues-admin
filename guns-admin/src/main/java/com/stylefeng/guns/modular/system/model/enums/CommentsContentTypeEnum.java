package com.stylefeng.guns.modular.system.model.enums;

public enum CommentsContentTypeEnum {
    GOOD(0,"好评"),
    BAD(1,"差评")
    ;

    private Integer val;
    private String message;

    CommentsContentTypeEnum(Integer val, String message) {
        this.val = val;
        this.message = message;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String valueOf(Integer value) {
        if (value == null) {
            return null;
        } else {
            for (CommentsContentTypeEnum CommentsContentTypeEnum : CommentsContentTypeEnum.values()) {
                if (CommentsContentTypeEnum.getVal().equals(value)) {
                    return CommentsContentTypeEnum.getMessage();
                }
            }
            return null;
        }
    }


}
