package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.BUser;
import com.stylefeng.guns.modular.system.service.IBUserService;

/**
 * 用户管理控制器
 *
 * @author fengshuonan
 * @Date 2019-03-12 13:28:23
 */
@Controller
@RequestMapping("/bUser")
public class BUserController extends BaseController {

    private String PREFIX = "/system/bUser/";

    @Autowired
    private IBUserService bUserService;

    /**
     * 跳转到用户管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "bUser.html";
    }

    /**
     * 跳转到添加用户管理
     */
    @RequestMapping("/bUser_add")
    public String bUserAdd() {
        return PREFIX + "bUser_add.html";
    }

    /**
     * 跳转到修改用户管理
     */
    @RequestMapping("/bUser_update/{bUserId}")
    public String bUserUpdate(@PathVariable Integer bUserId, Model model) {
        BUser bUser = bUserService.selectById(bUserId);
        model.addAttribute("item",bUser);
        LogObjectHolder.me().set(bUser);
        return PREFIX + "bUser_edit.html";
    }

    /**
     * 获取用户管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return bUserService.selectList(null);
    }

    /**
     * 新增用户管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(BUser bUser) {
        bUserService.insert(bUser);
        return SUCCESS_TIP;
    }

    /**
     * 删除用户管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer bUserId) {
        bUserService.deleteById(bUserId);
        return SUCCESS_TIP;
    }

    /**
     * 修改用户管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(BUser bUser) {
        bUserService.updateById(bUser);
        return SUCCESS_TIP;
    }

    /**
     * 用户管理详情
     */
    @RequestMapping(value = "/detail/{bUserId}")
    @ResponseBody
    public Object detail(@PathVariable("bUserId") Integer bUserId) {
        return bUserService.selectById(bUserId);
    }
}
