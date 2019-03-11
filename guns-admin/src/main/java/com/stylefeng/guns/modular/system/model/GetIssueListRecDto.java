package com.stylefeng.guns.modular.system.model;

import lombok.Data;

import java.util.Date;

@Data
public class GetIssueListRecDto {
    private Integer id;
    private String createTimeL;
    private String createTimeR;
    private String updateTimeR;
    private String updateTimeL;
    private String keyword;
    private Integer waitOnline;
    private Integer status;
    private Integer schoolId;
    private Integer tabId;
    private Integer authorId;
    private Integer solverId;
    private Integer powerStatus;
}
