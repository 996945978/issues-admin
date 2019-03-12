package com.stylefeng.guns.modular.system.model.enums;

public enum  StudentAuthEnum {
    NOAUTH(0,"未认证"),
    AUTH(1,"认证");

    Integer val;
    String message;

    StudentAuthEnum(Integer val, String message) {
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
            for (StudentAuthEnum StudentAuthEnum : StudentAuthEnum.values()) {
                if (StudentAuthEnum.getVal().equals(value)) {
                    return StudentAuthEnum.getMessage();
                }
            }
            return null;
        }
    }
}
