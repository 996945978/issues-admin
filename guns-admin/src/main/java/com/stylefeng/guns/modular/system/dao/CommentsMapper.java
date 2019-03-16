package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.Comments;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.modular.system.model.dto.GetCommentListDto;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论 Mapper 接口
 * </p>
 *
 * @author zzh
 * @since 2019-03-16
 */
public interface CommentsMapper extends BaseMapper<Comments> {

    List<Map<String,Object>> getCommnetList(GetCommentListDto m);
}
