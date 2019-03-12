package com.stylefeng.guns.core.common.constant.factory;

/**
 * 业务常量生产工厂
 */
public interface IBizConstantFactory {
    /**
     * 根据学校id获取学校名
     * @param id
     * @return
     */
    String getSchoolNameById(Integer id);

    /**
     * 根据标签id获取标签名
     * @param id
     * @return
     */
    String getTabNameById(Integer id);

    String getUserNameById(Integer id);

    String getSexName(Integer sex);

    Object getStudentAuthName(Integer studentAuth);

    Object getStopStatus(Integer status);
}
