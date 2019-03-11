/**
 * 标签管理管理初始化
 */
var Tab = {
    id: "TabTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Tab.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '自增长主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '名字', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '创建日期', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '状态。1：正常。0：禁用', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '背景图片地址', field: 'imgs', visible: true, align: 'center', valign: 'middle'},
            {title: '权重', field: 'weight', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Tab.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Tab.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加标签管理
 */
Tab.openAddTab = function () {
    var index = layer.open({
        type: 2,
        title: '添加标签管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tab/tab_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看标签管理详情
 */
Tab.openTabDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '标签管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tab/tab_update/' + Tab.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除标签管理
 */
Tab.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tab/delete", function (data) {
            Feng.success("删除成功!");
            Tab.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tabId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询标签管理列表
 */
Tab.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Tab.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Tab.initColumn();
    var table = new BSTable(Tab.id, "/tab/list", defaultColunms);
    table.setPaginationType("client");
    Tab.table = table.init();
});
