package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.system.model.BUser;
import com.stylefeng.guns.modular.system.model.dto.GetCommentListDto;
import com.stylefeng.guns.modular.system.service.IBUserService;
import com.stylefeng.guns.modular.system.warpper.CommentsWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Comments;
import com.stylefeng.guns.modular.system.service.ICommentsService;

import java.util.List;
import java.util.Map;

/**
 * 评论管理控制器
 *
 * @author fengshuonan
 * @Date 2019-03-16 14:18:01
 */
@Controller
@RequestMapping("/comments")
public class CommentsController extends BaseController {
    private String PREFIX = "/system/comments/";
    @Autowired
    IBUserService ibUserService;

    @Autowired
    private ICommentsService commentsService;

    /**
     * 跳转到评论管理首页
     */
    @RequestMapping("")
    public String index(Model model) {
        List<BUser> users = ibUserService.selectList(null);
        model.addAttribute("users",users);
        return PREFIX + "comments.html";
    }

    /**
     * 跳转到添加评论管理
     */
    @RequestMapping("/comments_add")
    public String commentsAdd(Model model) {
        List<BUser> users = ibUserService.selectList(null);
        model.addAttribute("users",users);
        return PREFIX + "comments_add.html";
    }

    /**
     * 跳转到修改评论管理
     */
    @RequestMapping("/comments_update/{commentsId}")
    public String commentsUpdate(@PathVariable Integer commentsId, Model model) {
        Comments comments = commentsService.selectById(commentsId);
        List<BUser> users = ibUserService.selectList(null);
        model.addAttribute("users",users);
        model.addAttribute("item",comments);
        LogObjectHolder.me().set(comments);
        return PREFIX + "comments_edit.html";
    }

    /**
     * 获取评论管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(GetCommentListDto M) {
        List<Map<String,Object>> comments = commentsService.getCommnetList(M);
        return new CommentsWrapper(comments).warp();
    }

    /**
     * 新增评论管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Comments comments) {
        commentsService.insert(comments);
        return SUCCESS_TIP;
    }

    /**
     * 删除评论管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer commentsId) {
        commentsService.deleteById(commentsId);
        return SUCCESS_TIP;
    }

    /**
     * 修改评论管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Comments comments) {
        commentsService.updateById(comments);
        return SUCCESS_TIP;
    }

    /**
     * 评论管理详情
     */
    @RequestMapping(value = "/detail/{commentsId}")
    @ResponseBody
    public Object detail(@PathVariable("commentsId") Integer commentsId) {
        return commentsService.selectById(commentsId);
    }
}
