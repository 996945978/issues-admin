package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.BUser;
import com.stylefeng.guns.modular.system.dao.BUserMapper;
import com.stylefeng.guns.modular.system.service.IBUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zzh
 * @since 2019-03-12
 */
@Service
public class BUserServiceImpl extends ServiceImpl<BUserMapper, BUser> implements IBUserService {

}
