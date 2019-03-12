package com.stylefeng.guns.modular.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.modular.system.model.School;
import com.stylefeng.guns.modular.system.dao.SchoolMapper;
import com.stylefeng.guns.modular.system.service.ISchoolService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 学校 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-03-10
 */
@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements ISchoolService {
    @Autowired
    SchoolMapper mapper;
    @Override
    public List<School> selectNormalList() {
        return mapper.selectList(new EntityWrapper<School>().eq("status",1));
    }
}
