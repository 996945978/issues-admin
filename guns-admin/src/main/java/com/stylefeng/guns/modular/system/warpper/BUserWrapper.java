package com.stylefeng.guns.modular.system.warpper;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.common.constant.factory.BizConstantFactory;
import java.util.List;
import java.util.Map;

/**
 * 业务用户包装类
 */
public class BUserWrapper extends BaseControllerWarpper{
    public BUserWrapper(List<Map<String, Object>> obj) {
        super(obj);
    }

    /**
     * 这里主要是返回结果枚举类的转换
     * @param map
     */
    @Override
    protected void warpTheMap(Map<String, Object> map) {
        map.put("schoolName", BizConstantFactory.me().getSchoolNameById((Integer)map.get("schoolId")));
        map.put("sexValue", BizConstantFactory.me().getSexName((Integer)map.get("sex")));
        map.put("studentAuthValue",BizConstantFactory.me().getStudentAuthName((Integer)map.get("studentAuth")));
        map.put("statusValue",BizConstantFactory.me().getStopStatus((Integer)map.get("status")));
    }
}
