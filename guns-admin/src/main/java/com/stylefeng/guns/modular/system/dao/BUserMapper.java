package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.BUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.modular.system.model.dto.GetBUserListDto;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author zzh
 * @since 2019-03-12
 */
public interface BUserMapper extends BaseMapper<BUser> {

    List<Map<String,Object>> listBy(GetBUserListDto m);
}
