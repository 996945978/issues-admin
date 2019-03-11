package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 求助
 * </p>
 *
 * @author stylefeng
 * @since 2019-03-10
 */
public class Issues extends Model<Issues> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 内容
     */
    private String content;
    /**
     * 是否在线等。0：否，1：是
     */
    @TableField("wait_online")
    private Integer waitOnline;
    /**
     * 状态。0：求助中，1：委托中，2：已完成，待买家确认，3：交易完成
     */
    private Integer status;
    /**
     * 赏金数量。保留小数点后两位
     */
    private Double reward;
    /**
     * 是否支付，0：否，1：是
     */
    @TableField("is_paid")
    private Integer isPaid;
    /**
     * 学校
     */
    @TableField("school_id")
    private Integer schoolId;
    /**
     * 发布人
     */
    @TableField("author_id")
    private Integer authorId;
    /**
     * 解决人id
     */
    @TableField("solver_id")
    private Integer solverId;
    /**
     * 0：冻结，1：正常
     */
    @TableField("power_status")
    private Integer powerStatus;
    /**
     * 标签
     */
    @TableField("tab_id")
    private Integer tabId;
    /**
     * 微信支付凭证
     */
    @TableField("paid_code")
    private String paidCode;
    /**
     * 图片链接。多个链接用英文“，”隔开
     */
    private String imgs;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getWaitOnline() {
        return waitOnline;
    }

    public void setWaitOnline(Integer waitOnline) {
        this.waitOnline = waitOnline;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getSolverId() {
        return solverId;
    }

    public void setSolverId(Integer solverId) {
        this.solverId = solverId;
    }

    public Integer getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(Integer powerStatus) {
        this.powerStatus = powerStatus;
    }

    public Integer getTabId() {
        return tabId;
    }

    public void setTabId(Integer tabId) {
        this.tabId = tabId;
    }

    public String getPaidCode() {
        return paidCode;
    }

    public void setPaidCode(String paidCode) {
        this.paidCode = paidCode;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Issues{" +
        "id=" + id +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", content=" + content +
        ", waitOnline=" + waitOnline +
        ", status=" + status +
        ", reward=" + reward +
        ", isPaid=" + isPaid +
        ", schoolId=" + schoolId +
        ", authorId=" + authorId +
        ", solverId=" + solverId +
        ", powerStatus=" + powerStatus +
        ", tabId=" + tabId +
        ", paidCode=" + paidCode +
        ", imgs=" + imgs +
        "}";
    }
}
