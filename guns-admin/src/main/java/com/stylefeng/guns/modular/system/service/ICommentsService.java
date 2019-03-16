package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.Comments;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.modular.system.model.dto.GetCommentListDto;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论 服务类
 * </p>
 *
 * @author zzh
 * @since 2019-03-16
 */
public interface ICommentsService extends IService<Comments> {

    List<Map<String,Object>> getCommnetList(GetCommentListDto m);
}
