package com.stylefeng.guns.modular.system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.system.model.GetIssueListRecDto;
import com.stylefeng.guns.modular.system.model.School;
import com.stylefeng.guns.modular.system.model.Tab;
import com.stylefeng.guns.modular.system.service.ISchoolService;
import com.stylefeng.guns.modular.system.service.ITabService;
import com.stylefeng.guns.modular.system.warpper.IssueWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Issues;
import com.stylefeng.guns.modular.system.service.IIssuesService;

import java.util.List;
import java.util.Map;

/**
 * 求助管理控制器
 *
 * @author fengshuonan
 * @Date 2019-03-10 13:35:46
 */
@Controller
@RequestMapping("/issues")
public class IssuesController extends BaseController {
    @Autowired
    ISchoolService iSchoolService;

    @Autowired
    ITabService iTabService;

    private String PREFIX = "/system/issues/";

    @Autowired
    private IIssuesService issuesService;

    /**
     * 跳转到求助管理首页
     */
    @RequestMapping("")
    public String index(Model model) {
        List<School> schools = iSchoolService.selectNormalList();
        List<Tab> tabs = iTabService.selectList(null);
        model.addAttribute("schools",schools);
        model.addAttribute("tabs",tabs);
        return PREFIX + "issues.html";
    }

    /**
     * 跳转到添加求助管理
     */
    @RequestMapping("/issues_add")
    public String issuesAdd(Model model) {
        List<School> schools = iSchoolService.selectNormalList();
        List<Tab> tabs = iTabService.selectList(null);
        model.addAttribute("schools",schools);
        model.addAttribute("tabs",tabs);
        return PREFIX + "issues_add.html";
    }

    /**
     * 跳转到修改求助管理
     */
    @RequestMapping("/issues_update/{issuesId}")
    public String issuesUpdate(@PathVariable Integer issuesId, Model model) {
        Issues issues = issuesService.selectById(issuesId);
        List<School> schools = iSchoolService.selectNormalList();
        List<Tab> tabs = iTabService.selectList(null);
        model.addAttribute("schools",schools);
        model.addAttribute("tabs",tabs);
        model.addAttribute("item",issues);
        LogObjectHolder.me().set(issues);
        return PREFIX + "issues_edit.html";
    }

    /**
     * 获取求助管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(GetIssueListRecDto M,Model model) {
        List<Map<String,Object>> issues =  issuesService.getIssueList(M);
        List<School> schools = iSchoolService.selectNormalList();
        List<Tab> tabs = iTabService.selectList(null);
        model.addAttribute("schools",schools);
        model.addAttribute("tabs",tabs);
        return new IssueWrapper(issues).warp();
    }

    /**
     * 新增求助管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Issues issues) {
        issuesService.insert(issues);
        return SUCCESS_TIP;
    }

    /**
     * 删除求助管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Long issuesId) {
        issuesService.deleteById(issuesId);
        return SUCCESS_TIP;
    }

    /**
     * 修改求助管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Issues issues) {
        issuesService.updateById(issues);
        return SUCCESS_TIP;
    }

    /**
     * 求助管理详情
     */
    @RequestMapping(value = "/detail/{issuesId}")
    @ResponseBody
    public Object detail(@PathVariable("issuesId") Integer issuesId) {
        return issuesService.selectById(issuesId);
    }
}
