package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.Skill;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.model.dto.GetSkillListDto;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 技能 服务类
 * </p>
 *
 * @author zzh
 * @since 2019-03-14
 */
public interface ISkillService extends IService<Skill> {
    /**
     * 根据前端参数动态返回结果
     * @param m
     * @return
     */
    List<Map<String,Object>> getSkillList(GetSkillListDto m);
}
