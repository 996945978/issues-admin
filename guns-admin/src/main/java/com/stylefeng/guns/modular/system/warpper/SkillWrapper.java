package com.stylefeng.guns.modular.system.warpper;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.common.constant.factory.BizConstantFactory;

import java.util.List;
import java.util.Map;

public class SkillWrapper extends BaseControllerWarpper {
    public SkillWrapper(List<Map<String, Object>> obj) {
        super(obj);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
        map.put("tabName", BizConstantFactory.me().getTabNameById((Integer)map.get("tabId")));
        map.put("schoolName",BizConstantFactory.me().getSchoolNameById((Integer)map.get("schoolId")));
        map.put("userName",BizConstantFactory.me().getUserNameById((Integer)map.get("authorId")));
        map.put("statusValue",BizConstantFactory.me().getStopStatus((Integer)map.get("status")));
    }
}
