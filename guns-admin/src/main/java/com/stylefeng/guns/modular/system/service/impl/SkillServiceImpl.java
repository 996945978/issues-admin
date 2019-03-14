package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.Skill;
import com.stylefeng.guns.modular.system.dao.SkillMapper;
import com.stylefeng.guns.modular.system.model.dto.GetSkillListDto;
import com.stylefeng.guns.modular.system.service.ISkillService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 技能 服务实现类
 * </p>
 *
 * @author zzh
 * @since 2019-03-14
 */
@Service
public class SkillServiceImpl extends ServiceImpl<SkillMapper, Skill> implements ISkillService {
    @Autowired
    SkillMapper mapper;
    @Override
    public List<Map<String, Object>> getSkillList(GetSkillListDto M) {
        return mapper.getSkillList(M);
    }
}
