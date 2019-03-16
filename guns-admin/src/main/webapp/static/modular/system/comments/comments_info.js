/**
 * 初始化评论管理详情对话框
 */
var CommentsInfoDlg = {
    commentsInfoData : {}
};

/**
 * 清除数据
 */
CommentsInfoDlg.clearData = function() {
    this.commentsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CommentsInfoDlg.set = function(key, val) {
    this.commentsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CommentsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CommentsInfoDlg.close = function() {
    parent.layer.close(window.parent.Comments.layerIndex);
}

/**
 * 收集数据
 */
CommentsInfoDlg.collectData = function() {
    this
    .set('id')
    .set('contentType')
    .set('content')
    .set('createTime')
    .set('status')
    .set('ownType')
    .set('ownId')
    .set('fromId')
    .set('toId')
    .set('agree');
}

/**
 * 提交添加
 */
CommentsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/comments/add", function(data){
        Feng.success("添加成功!");
        window.parent.Comments.table.refresh();
        CommentsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.commentsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CommentsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/comments/update", function(data){
        Feng.success("修改成功!");
        window.parent.Comments.table.refresh();
        CommentsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.commentsInfoData);
    ajax.start();
}

$(function() {
    $("#status").val($("#statusValue").val());
    $("#contentType").val($("#contentTypeValue").val());
    $("#ownType").val($("#ownTypeValue").val());
    $("#fromId").val($("#fromIdValue").val());
    $("#toId").val($("#toIdValue").val());
});
