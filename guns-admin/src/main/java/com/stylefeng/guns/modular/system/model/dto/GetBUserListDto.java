package com.stylefeng.guns.modular.system.model.dto;

import lombok.Data;

/**
 *前端查询BUser信息的参数接收类
 */
@Data
public class GetBUserListDto {
    private String name;
    private String createTimeL;
    private String createTimeR;
    private String updateTimeL;
    private String updateTimeR;
    private Integer schoolId;
    private Integer status;
    private Integer sex;
    private Integer mobile;
    private String dorm;
    private String studentNo;
    private String studentAuth;

}
