package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.GetIssueListRecDto;
import com.stylefeng.guns.modular.system.model.Issues;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 求助 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-03-10
 */
public interface IIssuesService extends IService<Issues> {

    /**
     * 根据前端动态参数返回结果列表
     * @param m
     * @return
     */
    List<Map<String,Object>> getIssueList(GetIssueListRecDto m);
}
