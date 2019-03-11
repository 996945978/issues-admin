package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.GetIssueListRecDto;
import com.stylefeng.guns.modular.system.model.Issues;
import com.stylefeng.guns.modular.system.dao.IssuesMapper;
import com.stylefeng.guns.modular.system.service.IIssuesService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 求助 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-03-10
 */
@Service
public class IssuesServiceImpl extends ServiceImpl<IssuesMapper, Issues> implements IIssuesService {
    @Autowired
    IssuesMapper mapper;
    @Override
    public List<Map<String, Object>> getIssueList(GetIssueListRecDto M) {
        return mapper.getIssueList(M);
    }
}
