package com.stylefeng.guns.core.common.constant.factory;

import com.stylefeng.guns.core.util.SpringContextHolder;
import com.stylefeng.guns.modular.system.dao.BUserMapper;
import com.stylefeng.guns.modular.system.dao.SchoolMapper;
import com.stylefeng.guns.modular.system.dao.TabMapper;
import com.stylefeng.guns.modular.system.model.BUser;
import com.stylefeng.guns.modular.system.model.enums.SexEnum;
import com.stylefeng.guns.modular.system.model.enums.StopStatusEnum;
import com.stylefeng.guns.modular.system.model.enums.StudentAuthEnum;
import com.stylefeng.guns.modular.system.service.IBUserService;
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
    private BUserMapper userMapper = SpringContextHolder.getBean(BUserMapper.class);

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
        if (id != null) {
            return userMapper.selectOne(new BUser(id)).getName();
        }else {
            return null;
        }
    }

    @Override
    public String getSexName(Integer sex) {
        return SexEnum.valueOf(sex);
    }

    @Override
    public Object getStudentAuthName(Integer studentAuth) {
        return StudentAuthEnum.valueOf(studentAuth);
    }

    @Override
    public Object getStopStatus(Integer status) {
        return StopStatusEnum.valueOf(status);
    }
}
