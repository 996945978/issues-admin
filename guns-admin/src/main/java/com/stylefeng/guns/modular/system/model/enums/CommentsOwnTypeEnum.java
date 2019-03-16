package com.stylefeng.guns.modular.system.model.enums;

public enum CommentsOwnTypeEnum {
    ISSUECOMMENT(0,"求助评论（完成交易时）"),
    SKILLCOMMENT(1,"技能评论（完成交易时）")
    ,SQUARECOMMENT(2,"广场求助评论")
            ;

    private Integer val;
    private String message;

    CommentsOwnTypeEnum(Integer val, String message) {
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
            for (CommentsOwnTypeEnum CommentsOwnTypeEnum : CommentsOwnTypeEnum.values()) {
                if (CommentsOwnTypeEnum.getVal().equals(value)) {
                    return CommentsOwnTypeEnum.getMessage();
                }
            }
            return null;
        }
    }


}
