/**
 * 初始化标签管理详情对话框
 */
var TabInfoDlg = {
    tabInfoData : {}
};

/**
 * 清除数据
 */
TabInfoDlg.clearData = function() {
    this.tabInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TabInfoDlg.set = function(key, val) {
    this.tabInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TabInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TabInfoDlg.close = function() {
    parent.layer.close(window.parent.Tab.layerIndex);
}

/**
 * 收集数据
 */
TabInfoDlg.collectData = function() {
    this
    .set('id')
    .set('name')
    .set('createTime')
    .set('status')
    .set('imgs')
    .set('weight');
}

/**
 * 提交添加
 */
TabInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tab/add", function(data){
        Feng.success("添加成功!");
        window.parent.Tab.table.refresh();
        TabInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tabInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TabInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tab/update", function(data){
        Feng.success("修改成功!");
        window.parent.Tab.table.refresh();
        TabInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tabInfoData);
    ajax.start();
}

$(function() {
    // 初始化头像上传
    var avatarUp = new $WebUpload("imgs");
    avatarUp.init();
});
