/**
 * 求助管理管理初始化
 */
var Issues = {
    id: "IssuesTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Issues.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'},
            {title: '内容', field: 'content', visible: true, align: 'center', valign: 'middle'},
            {title: '是否在线等。0：否，1：是', field: 'waitOnline', visible: true, align: 'center', valign: 'middle'},
            {title: '状态。0：求助中，1：委托中，2：已完成，待买家确认，3：交易完成', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '赏金数量。保留小数点后两位', field: 'reward', visible: true, align: 'center', valign: 'middle'},
            {title: '是否支付，0：否，1：是', field: 'isPaid', visible: true, align: 'center', valign: 'middle'},
            {title: '学校', field: 'schoolName', visible: true, align: 'center', valign: 'middle'},
            {title: '发布人', field: 'userName', visible: true, align: 'center', valign: 'middle'},
            {title: '解决人id', field: 'solverId', visible: true, align: 'center', valign: 'middle'},
            {title: '0：冻结，1：正常', field: 'powerStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '标签', field: 'tabName', visible: true, align: 'center', valign: 'middle'},
            {title: '微信支付凭证', field: 'paidCode', visible: true, align: 'center', valign: 'middle'},
            {title: '图片链接。多个链接用英文“，”隔开', field: 'imgs', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Issues.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Issues.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加求助管理
 */
Issues.openAddIssues = function () {
    var index = layer.open({
        type: 2,
        title: '添加求助管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/issues/issues_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看求助管理详情
 */
Issues.openIssuesDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '求助管理详情',
            area: ['800px', '720px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/issues/issues_update/' + Issues.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除求助管理
 */
Issues.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/issues/delete", function (data) {
            Feng.success("删除成功!");
            Issues.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("issuesId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询求助管理列表
 */
Issues.search = function () {
    var queryData = {};
    queryData['keyword'] = $("#keyword").val();
    queryData['createTimeL'] = $("#createTimeL").val();
    queryData['createTimeR'] = $("#createTimeR").val();
    queryData['updateTimeR'] = $("#updateTimeR").val();
    queryData['updateTimeL'] = $("#updateTimeL").val();
    queryData['waitOnline'] = $("#waitOnline").val();
    queryData['status'] = $("#status").val();
    queryData['schoolId'] = $("#schoolId").val();
    queryData['tabId'] = $("#tabId").val();
    queryData['authorId'] = $("#authorId").val();
    queryData['solverId'] = $("#solverId").val();
    queryData['powerStatus'] = $("#powerStatus").val();

    Issues.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Issues.initColumn();
    var table = new BSTable(Issues.id, "/issues/list", defaultColunms);
    table.setPaginationType("client");
    Issues.table = table.init();
});
