/**
 * 学校管理管理初始化
 */
var School = {
    id: "SchoolTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
School.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '自增长主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '名字', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '状态。0：禁用，1：正常', field: 'status', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
School.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        School.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加学校管理
 */
School.openAddSchool = function () {
    var index = layer.open({
        type: 2,
        title: '添加学校管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/school/school_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看学校管理详情
 */
School.openSchoolDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '学校管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/school/school_update/' + School.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除学校管理
 */
School.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/school/delete", function (data) {
            Feng.success("删除成功!");
            School.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("schoolId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询学校管理列表
 */
School.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    School.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = School.initColumn();
    var table = new BSTable(School.id, "/school/list", defaultColunms);
    table.setPaginationType("client");
    School.table = table.init();
});
