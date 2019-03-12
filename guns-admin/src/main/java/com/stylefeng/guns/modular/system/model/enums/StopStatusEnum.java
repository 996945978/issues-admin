package com.stylefeng.guns.modular.system.model.enums;

public enum  StopStatusEnum {
    STOP(0,"停封"),
    NORMAL(1,"正常");

    Integer val;
    String message;

    StopStatusEnum(Integer val, String message) {
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
            for (StopStatusEnum StopStatusEnum : StopStatusEnum.values()) {
                if (StopStatusEnum.getVal().equals(value)) {
                    return StopStatusEnum.getMessage();
                }
            }
            return null;
        }
    }
}
