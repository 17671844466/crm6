package com.zhidisoft.system.entity;

import java.util.Date;

public class EmailRecord {
    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_email_record.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_email_record.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_email_record.to_addr
     *
     * @mbg.generated
     */
    private String toAddr;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_email_record.subject
     *
     * @mbg.generated
     */
    private String subject;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_email_record.sendtime
     *
     * @mbg.generated
     */
    private Date sendtime;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_email_record.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_email_record.content
     *
     * @mbg.generated
     */
    private String content;

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_email_record.id 的值
     *
     * @return 返回 tb_crm_email_record.id 的值
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_email_record.id 的值
     *
     * @param id 用于指定列 tb_crm_email_record.id 的值
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_email_record.user_id 的值
     *
     * @return 返回 tb_crm_email_record.user_id 的值
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_email_record.user_id 的值
     *
     * @param userId 用于指定列 tb_crm_email_record.user_id 的值
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_email_record.to_addr 的值
     *
     * @return 返回 tb_crm_email_record.to_addr 的值
     *
     * @mbg.generated
     */
    public String getToAddr() {
        return toAddr;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_email_record.to_addr 的值
     *
     * @param toAddr 用于指定列 tb_crm_email_record.to_addr 的值
     *
     * @mbg.generated
     */
    public void setToAddr(String toAddr) {
        this.toAddr = toAddr == null ? null : toAddr.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_email_record.subject 的值
     *
     * @return 返回 tb_crm_email_record.subject 的值
     *
     * @mbg.generated
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_email_record.subject 的值
     *
     * @param subject 用于指定列 tb_crm_email_record.subject 的值
     *
     * @mbg.generated
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_email_record.sendtime 的值
     *
     * @return 返回 tb_crm_email_record.sendtime 的值
     *
     * @mbg.generated
     */
    public Date getSendtime() {
        return sendtime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_email_record.sendtime 的值
     *
     * @param sendtime 用于指定列 tb_crm_email_record.sendtime 的值
     *
     * @mbg.generated
     */
    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_email_record.status 的值
     *
     * @return 返回 tb_crm_email_record.status 的值
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_email_record.status 的值
     *
     * @param status 用于指定列 tb_crm_email_record.status 的值
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_email_record.content 的值
     *
     * @return 返回 tb_crm_email_record.content 的值
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_email_record.content 的值
     *
     * @param content 用于指定列 tb_crm_email_record.content 的值
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}