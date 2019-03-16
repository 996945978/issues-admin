/**
 * 评论管理管理初始化
 */
var Comments = {
    id: "CommentsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Comments.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '类型', field: 'commentsContentTypeValue', visible: true, align: 'center', valign: 'middle'},
            {title: '内容', field: 'content', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'stopStatusValue', visible: true, align: 'center', valign: 'middle'},
            {title: '所属类型', field: 'commentsOwnTypeValue', visible: true, align: 'center', valign: 'middle'},
            {title: '所属类型外键，own_type是0，就是issue的外键', field: 'ownId', visible: true, align: 'center', valign: 'middle'},
            {title: '发送者', field: 'fromName', visible: true, align: 'center', valign: 'middle'},
            {title: '接受者', field: 'toName', visible: true, align: 'center', valign: 'middle'},
            {title: '点赞', field: 'agree', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Comments.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Comments.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加评论管理
 */
Comments.openAddComments = function () {
    var index = layer.open({
        type: 2,
        title: '添加评论管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/comments/comments_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看评论管理详情
 */
Comments.openCommentsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '评论管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/comments/comments_update/' + Comments.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除评论管理
 */
Comments.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/comments/delete", function (data) {
            Feng.success("删除成功!");
            Comments.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("commentsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询评论管理列表
 */
Comments.search = function () {
    var queryData = {};
    queryData['keyword'] = $("#keyword").val();
    queryData['createTimeL'] = $("#createTimeL").val();
    queryData['createTimeR'] = $("#createTimeR").val();
    queryData['contentType'] = $("#contentType").val();
    queryData['status'] = $("#status").val();
    queryData['ownId'] = $("#ownId").val();
    queryData['fromId'] = $("#fromId").val();
    queryData['toId'] = $("#toId").val();
    queryData['id'] = $("#id").val();
    Comments.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Comments.initColumn();
    var table = new BSTable(Comments.id, "/comments/list", defaultColunms);
    table.setPaginationType("client");
    Comments.table = table.init();
});
