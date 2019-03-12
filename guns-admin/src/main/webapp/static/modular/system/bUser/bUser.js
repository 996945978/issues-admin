/**
 * 用户管理管理初始化
 */
var BUser = {
    id: "BUserTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
BUser.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '自增主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '昵称', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '创建日期', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'},
            {title: '性别。0：男，1：女', field: 'sex', visible: true, align: 'center', valign: 'middle'},
            {title: '电话', field: 'mobile', visible: true, align: 'center', valign: 'middle'},
            {title: '学校id', field: 'schoolId', visible: true, align: 'center', valign: 'middle'},
            {title: '宿舍', field: 'dorm', visible: true, align: 'center', valign: 'middle'},
            {title: '生日', field: 'birthday', visible: true, align: 'center', valign: 'middle'},
            {title: '余额', field: 'balance', visible: true, align: 'center', valign: 'middle'},
            {title: '头像地址', field: 'chatHead', visible: true, align: 'center', valign: 'middle'},
            {title: '状态。0：正常，1：冻结', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '密码盐', field: 'salt', visible: true, align: 'center', valign: 'middle'},
            {title: '密码', field: 'password', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'oppenId', visible: true, align: 'center', valign: 'middle'},
            {title: '活跃度', field: 'activation', visible: true, align: 'center', valign: 'middle'},
            {title: '签名', field: 'sign', visible: true, align: 'center', valign: 'middle'},
            {title: '学号', field: 'studentNo', visible: true, align: 'center', valign: 'middle'},
            {title: '学号对应的密码', field: 'studentPwd', visible: true, align: 'center', valign: 'middle'},
            {title: '是否学生认证。0：否，1：是', field: 'studentAuth', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
BUser.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        BUser.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加用户管理
 */
BUser.openAddBUser = function () {
    var index = layer.open({
        type: 2,
        title: '添加用户管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/bUser/bUser_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看用户管理详情
 */
BUser.openBUserDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '用户管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/bUser/bUser_update/' + BUser.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除用户管理
 */
BUser.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/bUser/delete", function (data) {
            Feng.success("删除成功!");
            BUser.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("bUserId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询用户管理列表
 */
BUser.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    BUser.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = BUser.initColumn();
    var table = new BSTable(BUser.id, "/bUser/list", defaultColunms);
    table.setPaginationType("client");
    BUser.table = table.init();
});
