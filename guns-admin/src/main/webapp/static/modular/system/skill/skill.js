/**
 * 技能管理管理初始化
 */
var Skill = {
    id: "SkillTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Skill.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '内容', field: 'content', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'statusValue', visible: true, align: 'center', valign: 'middle'},
            {title: '创建', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '更新', field: 'updateTime', visible: true, align: 'center', valign: 'middle'},
            {title: '发布', field: 'userName', visible: true, align: 'center', valign: 'middle'},
            {title: '标签', field: 'tabName', visible: true, align: 'center', valign: 'middle'},
            {title: '学校', field: 'schoolName', visible: true, align: 'center', valign: 'middle'},
            {title: '售价', field: 'money', visible: true, align: 'center', valign: 'middle'},
            {title: '图片', field: 'imgs', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Skill.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Skill.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加技能管理
 */
Skill.openAddSkill = function () {
    var index = layer.open({
        type: 2,
        title: '添加技能管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/skill/skill_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看技能管理详情
 */
Skill.openSkillDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '技能管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/skill/skill_update/' + Skill.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除技能管理
 */
Skill.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/skill/delete", function (data) {
            Feng.success("删除成功!");
            Skill.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("skillId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询技能管理列表
 */
Skill.search = function () {
    var queryData = {};
    queryData['keyword'] = $("#keyword").val();
    queryData['createTimeL'] = $("#createTimeL").val();
    queryData['createTimeR'] = $("#createTimeR").val();
    queryData['updateTimeR'] = $("#updateTimeR").val();
    queryData['updateTimeL'] = $("#updateTimeL").val();
    queryData['status'] = $("#status").val();
    queryData['schoolId'] = $("#schoolId").val();
    queryData['tabId'] = $("#tabId").val();
    queryData['authorId'] = $("#authorId").val();
    queryData['id'] = $("#id").val();
    Skill.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Skill.initColumn();
    var table = new BSTable(Skill.id, "/skill/list", defaultColunms);
    table.setPaginationType("client");
    Skill.table = table.init();
});
