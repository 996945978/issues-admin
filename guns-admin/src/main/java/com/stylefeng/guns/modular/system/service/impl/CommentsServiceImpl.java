package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.Comments;
import com.stylefeng.guns.modular.system.dao.CommentsMapper;
import com.stylefeng.guns.modular.system.model.dto.GetCommentListDto;
import com.stylefeng.guns.modular.system.service.ICommentsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author zzh
 * @since 2019-03-16
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements ICommentsService {
    @Autowired
    CommentsMapper mapper;

    @Override
    public List<Map<String, Object>> getCommnetList(GetCommentListDto M) {
        return mapper.getCommnetList(M);
    }
}
