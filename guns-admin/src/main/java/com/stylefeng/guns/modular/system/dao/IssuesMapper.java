package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.GetIssueListRecDto;
import com.stylefeng.guns.modular.system.model.Issues;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 求助 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-03-10
 */
public interface IssuesMapper extends BaseMapper<Issues> {

    List<Map<String,Object>> getIssueList(GetIssueListRecDto m);
}
