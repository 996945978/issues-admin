package com.stylefeng.guns.modular.system.warpper;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.common.constant.factory.BizConstantFactory;

import java.util.List;
import java.util.Map;

public class CommentsWrapper extends BaseControllerWarpper{
    public CommentsWrapper(List<Map<String,Object>> obj) {
        super(obj);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
        map.put("commentsOwnTypeValue", BizConstantFactory.me().getCommentsOwnTypeValue((Integer)map.get("ownType")));
        map.put("commentsContentTypeValue", BizConstantFactory.me().getCommentsContentTypeValue((Integer)map.get("contentType")));
        map.put("stopStatusValue", BizConstantFactory.me().getStopStatus((Integer)map.get("status")));
        map.put("toName", BizConstantFactory.me().getUserNameById((Integer)map.get("toId")));
        map.put("fromName", BizConstantFactory.me().getUserNameById((Integer)map.get("fromId")));
    }
}
