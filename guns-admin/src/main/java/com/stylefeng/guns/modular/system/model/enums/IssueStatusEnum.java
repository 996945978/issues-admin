package com.stylefeng.guns.modular.system.model.enums;

public enum IssueStatusEnum {
    SEARCHING(0,"求助中")
    ,HELPING(1,"委托中")
    ,CONFIRM(2,"已完成，待确认")
    ,FINISH(3,"完成")
    ;

    Integer val;
    String message;

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

    IssueStatusEnum(Integer val, String message) {
        this.val = val;
        this.message = message;
    }

    public static String valueOf(Integer value) {
        if (value == null) {
            return null;
        } else {
            for (IssueStatusEnum IssueStatusEnum : IssueStatusEnum.values()) {
                if (IssueStatusEnum.getVal().equals(value)) {
                    return IssueStatusEnum.getMessage();
                }
            }
            return null;
        }
    }
}
