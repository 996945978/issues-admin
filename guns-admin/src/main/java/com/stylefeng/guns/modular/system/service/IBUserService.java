package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.BUser;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.model.dto.GetBUserListDto;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zzh
 * @since 2019-03-12
 */
public interface IBUserService extends IService<BUser> {

    /**
     * 根据前端参数动态查询数据
     * @param m
     * @return
     */
    List<Map<String,Object>> listBy(GetBUserListDto m);
}
