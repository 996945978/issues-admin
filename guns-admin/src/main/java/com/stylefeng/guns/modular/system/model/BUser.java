package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author zzh
 * @since 2019-03-12
 */
@TableName("b_user")
public class BUser extends Model<BUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 昵称
     */
    private String name;
    /**
     * 创建日期
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 性别。0：男，1：女
     */
    private Integer sex;
    /**
     * 电话
     */
    private String mobile;
    /**
     * 学校id
     */
    @TableField("school_id")
    private Integer schoolId;
    /**
     * 宿舍
     */
    private String dorm;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 余额
     */
    private Double balance;
    /**
     * 头像地址
     */
    @TableField("chat_head")
    private String chatHead;
    /**
     * 状态。0：正常，1：冻结
     */
    private Integer status;
    /**
     * 密码盐
     */
    private String salt;
    /**
     * 密码
     */
    private String password;
    @TableField("oppen_id")
    private String oppenId;
    /**
     * 活跃度
     */
    private Integer activation;
    /**
     * 签名
     */
    private String sign;
    /**
     * 学号
     */
    @TableField("student_no")
    private String studentNo;
    /**
     * 学号对应的密码
     */
    @TableField("student_pwd")
    private String studentPwd;
    /**
     * 是否学生认证。0：否，1：是
     */
    @TableField("student_auth")
    private Integer studentAuth;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getDorm() {
        return dorm;
    }

    public void setDorm(String dorm) {
        this.dorm = dorm;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getChatHead() {
        return chatHead;
    }

    public void setChatHead(String chatHead) {
        this.chatHead = chatHead;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOppenId() {
        return oppenId;
    }

    public void setOppenId(String oppenId) {
        this.oppenId = oppenId;
    }

    public Integer getActivation() {
        return activation;
    }

    public void setActivation(Integer activation) {
        this.activation = activation;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentPwd() {
        return studentPwd;
    }

    public void setStudentPwd(String studentPwd) {
        this.studentPwd = studentPwd;
    }

    public Integer getStudentAuth() {
        return studentAuth;
    }

    public void setStudentAuth(Integer studentAuth) {
        this.studentAuth = studentAuth;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BUser{" +
        "id=" + id +
        ", name=" + name +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", sex=" + sex +
        ", mobile=" + mobile +
        ", schoolId=" + schoolId +
        ", dorm=" + dorm +
        ", birthday=" + birthday +
        ", balance=" + balance +
        ", chatHead=" + chatHead +
        ", status=" + status +
        ", salt=" + salt +
        ", password=" + password +
        ", oppenId=" + oppenId +
        ", activation=" + activation +
        ", sign=" + sign +
        ", studentNo=" + studentNo +
        ", studentPwd=" + studentPwd +
        ", studentAuth=" + studentAuth +
        "}";
    }
}
