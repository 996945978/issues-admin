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
import com.stylefeng.guns.modular.system.model.Tab;
import com.stylefeng.guns.modular.system.service.ITabService;

/**
 * 标签管理控制器
 *
 * @author fengshuonan
 * @Date 2019-03-10 11:05:21
 */
@Controller
@RequestMapping("/tab")
public class TabController extends BaseController {

    private String PREFIX = "/system/tab/";

    @Autowired
    private ITabService tabService;

    /**
     * 跳转到标签管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tab.html";
    }

    /**
     * 跳转到添加标签管理
     */
    @RequestMapping("/tab_add")
    public String tabAdd() {
        return PREFIX + "tab_add.html";
    }

    /**
     * 跳转到修改标签管理
     */
    @RequestMapping("/tab_update/{tabId}")
    public String tabUpdate(@PathVariable Integer tabId, Model model) {
        Tab tab = tabService.selectById(tabId);
        model.addAttribute("item",tab);
        LogObjectHolder.me().set(tab);
        return PREFIX + "tab_edit.html";
    }

    /**
     * 获取标签管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return tabService.selectList(null);
    }

    /**
     * 新增标签管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Tab tab) {
        tabService.insert(tab);
        return SUCCESS_TIP;
    }

    /**
     * 删除标签管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tabId) {
        tabService.deleteById(tabId);
        return SUCCESS_TIP;
    }

    /**
     * 修改标签管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Tab tab) {
        tabService.updateById(tab);
        return SUCCESS_TIP;
    }

    /**
     * 标签管理详情
     */
    @RequestMapping(value = "/detail/{tabId}")
    @ResponseBody
    public Object detail(@PathVariable("tabId") Integer tabId) {
        return tabService.selectById(tabId);
    }
}
