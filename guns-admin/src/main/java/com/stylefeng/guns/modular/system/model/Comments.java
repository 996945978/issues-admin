package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 评论
 * </p>
 *
 * @author zzh
 * @since 2019-03-16
 */
public class Comments extends Model<Comments> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 类型。0：好评，1：差评
     */
    @TableField("content_type")
    private Integer contentType;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 状态。0：禁用，1：正常
     */
    private Integer status;
    /**
     * 评论类型。0：求助评论（完成交易时），1：技能评论（完成交易时）,2:广场求助评论
     */
    @TableField("own_type")
    private Integer ownType;
    /**
     * 所属类型外键，own_type是0，就是issue的外键
     */
    @TableField("own_id")
    private Long ownId;
    /**
     * 发送者id
     */
    @TableField("from_id")
    private Integer fromId;
    /**
     * 接受者id
     */
    @TableField("to_id")
    private Integer toId;
    /**
     * 点赞
     */
    private Integer agree;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOwnType() {
        return ownType;
    }

    public void setOwnType(Integer ownType) {
        this.ownType = ownType;
    }

    public Long getOwnId() {
        return ownId;
    }

    public void setOwnId(Long ownId) {
        this.ownId = ownId;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public Integer getAgree() {
        return agree;
    }

    public void setAgree(Integer agree) {
        this.agree = agree;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Comments{" +
        "id=" + id +
        ", contentType=" + contentType +
        ", content=" + content +
        ", createTime=" + createTime +
        ", status=" + status +
        ", ownType=" + ownType +
        ", ownId=" + ownId +
        ", fromId=" + fromId +
        ", toId=" + toId +
        ", agree=" + agree +
        "}";
    }
}
