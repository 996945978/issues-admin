package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.system.model.BUser;
import com.stylefeng.guns.modular.system.model.School;
import com.stylefeng.guns.modular.system.model.Tab;
import com.stylefeng.guns.modular.system.model.dto.GetSkillListDto;
import com.stylefeng.guns.modular.system.service.IBUserService;
import com.stylefeng.guns.modular.system.service.ISchoolService;
import com.stylefeng.guns.modular.system.service.ITabService;
import com.stylefeng.guns.modular.system.warpper.SkillWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Skill;
import com.stylefeng.guns.modular.system.service.ISkillService;

import java.util.List;
import java.util.Map;

/**
 * 技能管理控制器
 *
 * @author fengshuonan
 * @Date 2019-03-14 14:03:57
 */
@Controller
@RequestMapping("/skill")
public class SkillController extends BaseController {
    @Autowired
    IBUserService ibUserService;
    @Autowired
    ISchoolService iSchoolService;

    @Autowired
    ITabService iTabService;

    private String PREFIX = "/system/skill/";

    @Autowired
    private ISkillService skillService;

    /**
     * 跳转到技能管理首页
     */
    @RequestMapping("")
    public String index(Model model) {
        List<School> schools = iSchoolService.selectNormalList();
        List<Tab> tabs = iTabService.selectList(null);
        List<BUser> users = ibUserService.selectList(null);
        model.addAttribute("users",users);
        model.addAttribute("schools",schools);
        model.addAttribute("tabs",tabs);
        return PREFIX + "skill.html";
    }

    /**
     * 跳转到添加技能管理
     */
    @RequestMapping("/skill_add")
    public String skillAdd(Model model) {
        List<School> schools = iSchoolService.selectNormalList();
        List<Tab> tabs = iTabService.selectList(null);
        List<BUser> users = ibUserService.selectList(null);
        model.addAttribute("users",users);
        model.addAttribute("schools",schools);
        model.addAttribute("tabs",tabs);
        return PREFIX + "skill_add.html";
    }

    /**
     * 跳转到修改技能管理
     */
    @RequestMapping("/skill_update/{skillId}")
    public String skillUpdate(@PathVariable Integer skillId, Model model) {
        Skill skill = skillService.selectById(skillId);
        List<School> schools = iSchoolService.selectNormalList();
        List<Tab> tabs = iTabService.selectList(null);
        List<BUser> users = ibUserService.selectList(null);
        model.addAttribute("users",users);
        model.addAttribute("schools",schools);
        model.addAttribute("tabs",tabs);
        model.addAttribute("item",skill);
        LogObjectHolder.me().set(skill);
        return PREFIX + "skill_edit.html";
    }

    /**
     * 获取技能管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(GetSkillListDto M) {
        List<Map<String,Object>> skills = skillService.getSkillList(M);
        return new SkillWrapper(skills).warp();
    }

    /**
     * 新增技能管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Skill skill) {
        skillService.insert(skill);
        return SUCCESS_TIP;
    }

    /**
     * 删除技能管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer skillId) {
        skillService.deleteById(skillId);
        return SUCCESS_TIP;
    }

    /**
     * 修改技能管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Skill skill) {
        skillService.updateById(skill);
        return SUCCESS_TIP;
    }

    /**
     * 技能管理详情
     */
    @RequestMapping(value = "/detail/{skillId}")
    @ResponseBody
    public Object detail(@PathVariable("skillId") Integer skillId) {
        return skillService.selectById(skillId);
    }
}
