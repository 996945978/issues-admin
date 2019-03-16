package com.stylefeng.guns.modular.system.model.dto;

import lombok.Data;

@Data
public class GetCommentListDto {
    private Integer id;
    private String keyword;
    private String createTimeL;
    private String createTimeR;
    private Integer status;
    private Integer contentType;
    private Integer ownId;
    private Integer fromId;
    private Integer toId;
}
