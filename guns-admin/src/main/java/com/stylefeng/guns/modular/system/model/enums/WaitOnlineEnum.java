package com.stylefeng.guns.modular.system.model.enums;

public enum WaitOnlineEnum {
    NO(0,"否"),
    YES(1,"是");

    Integer val;
    String message;

     WaitOnlineEnum(Integer val, String message) {
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
            for (WaitOnlineEnum WaitOnlineEnum : WaitOnlineEnum.values()) {
                if (WaitOnlineEnum.getVal().equals(value)) {
                    return WaitOnlineEnum.getMessage();
                }
            }
            return null;
        }
    }
}
