/**
 * 初始化技能管理详情对话框
 */
var SkillInfoDlg = {
    skillInfoData : {}
};

/**
 * 清除数据
 */
SkillInfoDlg.clearData = function() {
    this.skillInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SkillInfoDlg.set = function(key, val) {
    this.skillInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SkillInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SkillInfoDlg.close = function() {
    parent.layer.close(window.parent.Skill.layerIndex);
}

/**
 * 收集数据
 */
SkillInfoDlg.collectData = function() {
    this
    .set('id')
    .set('content')
    .set('status')
    .set('createTime')
    .set('updateTime')
    .set('authorId')
    .set('tabId')
    .set('schoolId')
    .set('money')
    .set('imgs');
}

/**
 * 提交添加
 */
SkillInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/skill/add", function(data){
        Feng.success("添加成功!");
        window.parent.Skill.table.refresh();
        SkillInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.skillInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SkillInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/skill/update", function(data){
        Feng.success("修改成功!");
        window.parent.Skill.table.refresh();
        SkillInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.skillInfoData);
    ajax.start();
}

$(function() {
    //初始化所属学校
    $("#schoolId").val($("#schoolValue").val());
    $("#tabId").val($("#tabValue").val());
    $("#authorId").val($("#AuthorValue").val());
});
