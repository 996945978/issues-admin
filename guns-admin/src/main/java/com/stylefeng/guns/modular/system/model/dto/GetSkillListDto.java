package com.stylefeng.guns.modular.system.model.dto;

import lombok.Data;

@Data
public class GetSkillListDto {
    private Integer id;
    private String keyword;
    private Integer status;
    private Integer authorId;
    private Integer tabId;
    private Integer schoolId;
    private String createTimeL;
    private String createTimeR;
    private String updateTimeL;
    private String updateTimeR;
}
