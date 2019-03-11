package com.stylefeng.guns.core.common.constant.factory;

import com.stylefeng.guns.core.util.SpringContextHolder;
import com.stylefeng.guns.modular.system.dao.SchoolMapper;
import com.stylefeng.guns.modular.system.dao.TabMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * 业务常量生产工厂
 */
@Component("bizConstantFactory")
@DependsOn("springContextHolder")
public class BizConstantFactory implements IBizConstantFactory{
    private SchoolMapper schoolMapper = SpringContextHolder.getBean(SchoolMapper.class);
    private TabMapper  tabMapper = SpringContextHolder.getBean(TabMapper.class);

    public static IBizConstantFactory me() {
        return SpringContextHolder.getBean("bizConstantFactory");
    }

    @Override
    public String getSchoolNameById(Integer id) {
        return schoolMapper.selectById(id).getName();
    }

    @Override
    public String getTabNameById(Integer id) {
        return tabMapper.selectById(id).getName();
    }

    @Override
    public String getUserNameById(Integer id) {
        return null; //TODO
    }
}
