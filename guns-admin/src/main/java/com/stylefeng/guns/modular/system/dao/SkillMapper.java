package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.Skill;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.modular.system.model.dto.GetSkillListDto;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 技能 Mapper 接口
 * </p>
 *
 * @author zzh
 * @since 2019-03-14
 */
public interface SkillMapper extends BaseMapper<Skill> {

    List<Map<String,Object>> getSkillList(GetSkillListDto m);
}
