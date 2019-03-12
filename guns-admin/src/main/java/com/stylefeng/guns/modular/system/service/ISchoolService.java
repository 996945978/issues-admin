package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.School;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 学校 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-03-10
 */
public interface ISchoolService extends IService<School> {
    /**
     * 查询状态正常的学校
     * @return
     */
    List<School> selectNormalList();
}
