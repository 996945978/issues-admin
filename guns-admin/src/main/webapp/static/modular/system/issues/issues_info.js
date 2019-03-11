/**
 * 初始化求助管理详情对话框
 */
var IssuesInfoDlg = {
    issuesInfoData : {}
};

/**
 * 清除数据
 */
IssuesInfoDlg.clearData = function() {
    this.issuesInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IssuesInfoDlg.set = function(key, val) {
    this.issuesInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
IssuesInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
IssuesInfoDlg.close = function() {
    parent.layer.close(window.parent.Issues.layerIndex);
}

/**
 * 收集数据
 */
IssuesInfoDlg.collectData = function() {
    this
    .set('id')
    .set('createTime')
    .set('updateTime')
    .set('content')
    .set('waitOnline')
    .set('status')
    .set('reward')
    .set('isPaid')
    .set('schoolName')
    .set('authorId')
    .set('solverId')
    .set('powerStatus')
    .set('tabName')
    .set('paidCode')
    .set('imgs');
}

/**
 * 提交添加
 */
IssuesInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/issues/add", function(data){
        Feng.success("添加成功!");
        window.parent.Issues.table.refresh();
        IssuesInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.issuesInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
IssuesInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/issues/update", function(data){
        Feng.success("修改成功!");
        window.parent.Issues.table.refresh();
        IssuesInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.issuesInfoData);
    ajax.start();
}

$(function() {
    //初始化所属学校
    $("#schoolId").val($("#schoolValue").val());
    $("#tabId").val($("#tabValue").val());

});
