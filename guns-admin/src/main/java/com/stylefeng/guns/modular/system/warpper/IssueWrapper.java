package com.stylefeng.guns.modular.system.warpper;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.common.constant.factory.BizConstantFactory;

import java.util.List;
import java.util.Map;

/**
 * 求助管理的包装类
 * @Auth zzh
 */
public class IssueWrapper extends BaseControllerWarpper {
    public IssueWrapper(List<Map<String, Object>> list) {
        super(list);
    }

    /**
     * 这里主要是返回结果枚举类的转换。包括学校名，标签名
     * @param map
     */
    @Override
    protected void warpTheMap(Map<String, Object> map) {
        map.put("tabName",BizConstantFactory.me().getTabNameById((Integer)map.get("tabId")));
        map.put("schoolName",BizConstantFactory.me().getSchoolNameById((Integer)map.get("schoolId")));
        //TODO 用户名获取
    }
}
