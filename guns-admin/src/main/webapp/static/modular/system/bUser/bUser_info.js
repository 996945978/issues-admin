/**
 * 初始化用户管理详情对话框
 */
var BUserInfoDlg = {
    bUserInfoData : {}
};

/**
 * 清除数据
 */
BUserInfoDlg.clearData = function() {
    this.bUserInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BUserInfoDlg.set = function(key, val) {
    this.bUserInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BUserInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
BUserInfoDlg.close = function() {
    parent.layer.close(window.parent.BUser.layerIndex);
}

/**
 * 收集数据
 */
BUserInfoDlg.collectData = function() {
    this
    .set('id')
    .set('name')
    .set('createTime')
    .set('updateTime')
    .set('sex')
    .set('mobile')
    .set('schoolId')
    .set('dorm')
    .set('birthday')
    .set('balance')
    .set('chatHead')
    .set('status')
    .set('salt')
    .set('password')
    .set('oppenId')
    .set('activation')
    .set('sign')
    .set('studentNo')
    .set('studentPwd')
    .set('studentAuth');
}

/**
 * 提交添加
 */
BUserInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bUser/add", function(data){
        Feng.success("添加成功!");
        window.parent.BUser.table.refresh();
        BUserInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bUserInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
BUserInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bUser/update", function(data){
        Feng.success("修改成功!");
        window.parent.BUser.table.refresh();
        BUserInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bUserInfoData);
    ajax.start();
}
$(function() {
    $("#schoolId").val($("#schoolValue").val());
    $("#sex").val($("#sexValue").val());
    $("#status").val($("#statusValue").val());
    $("#studentAuth").val($("#studentAuthValue").val())
});
