package com.stylefeng.guns.modular.system.model.enums;

public enum SexEnum {
    MAN(0,"男"),
    WOMEN(1,"女")
    ;

    private Integer val;
    private String message;

    SexEnum(Integer val, String message) {
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
            for (SexEnum SexEnum : SexEnum.values()) {
                if (SexEnum.getVal().equals(value)) {
                    return SexEnum.getMessage();
                }
            }
            return null;
        }
    }
}