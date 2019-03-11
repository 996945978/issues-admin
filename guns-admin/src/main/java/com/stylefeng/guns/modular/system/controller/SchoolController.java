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
import com.stylefeng.guns.modular.system.model.School;
import com.stylefeng.guns.modular.system.service.ISchoolService;

/**
 * 学校管理控制器
 *
 * @author fengshuonan
 * @Date 2019-03-10 10:57:29
 */
@Controller
@RequestMapping("/school")
public class SchoolController extends BaseController {

    private String PREFIX = "/system/school/";

    @Autowired
    private ISchoolService schoolService;

    /**
     * 跳转到学校管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "school.html";
    }

    /**
     * 跳转到添加学校管理
     */
    @RequestMapping("/school_add")
    public String schoolAdd() {
        return PREFIX + "school_add.html";
    }

    /**
     * 跳转到修改学校管理
     */
    @RequestMapping("/school_update/{schoolId}")
    public String schoolUpdate(@PathVariable Integer schoolId, Model model) {
        School school = schoolService.selectById(schoolId);
        model.addAttribute("item",school);
        LogObjectHolder.me().set(school);
        return PREFIX + "school_edit.html";
    }

    /**
     * 获取学校管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return schoolService.selectList(null);
    }

    /**
     * 新增学校管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(School school) {
        schoolService.insert(school);
        return SUCCESS_TIP;
    }

    /**
     * 删除学校管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer schoolId) {
        schoolService.deleteById(schoolId);
        return SUCCESS_TIP;
    }

    /**
     * 修改学校管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(School school) {
        schoolService.updateById(school);
        return SUCCESS_TIP;
    }

    /**
     * 学校管理详情
     */
    @RequestMapping(value = "/detail/{schoolId}")
    @ResponseBody
    public Object detail(@PathVariable("schoolId") Integer schoolId) {
        return schoolService.selectById(schoolId);
    }
}
