package com.zhidisoft.system.entity;

public class SmsTemplate {
    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_sms_template.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_sms_template.template_code
     *
     * @mbg.generated
     */
    private String templateCode;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_sms_template.subject
     *
     * @mbg.generated
     */
    private String subject;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_sms_template.content
     *
     * @mbg.generated
     */
    private String content;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_sms_template.order_id
     *
     * @mbg.generated
     */
    private Integer orderId;

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_sms_template.id 的值
     *
     * @return 返回 tb_crm_sms_template.id 的值
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_sms_template.id 的值
     *
     * @param id 用于指定列 tb_crm_sms_template.id 的值
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_sms_template.template_code 的值
     *
     * @return 返回 tb_crm_sms_template.template_code 的值
     *
     * @mbg.generated
     */
    public String getTemplateCode() {
        return templateCode;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_sms_template.template_code 的值
     *
     * @param templateCode 用于指定列 tb_crm_sms_template.template_code 的值
     *
     * @mbg.generated
     */
    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode == null ? null : templateCode.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_sms_template.subject 的值
     *
     * @return 返回 tb_crm_sms_template.subject 的值
     *
     * @mbg.generated
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_sms_template.subject 的值
     *
     * @param subject 用于指定列 tb_crm_sms_template.subject 的值
     *
     * @mbg.generated
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_sms_template.content 的值
     *
     * @return 返回 tb_crm_sms_template.content 的值
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_sms_template.content 的值
     *
     * @param content 用于指定列 tb_crm_sms_template.content 的值
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_sms_template.order_id 的值
     *
     * @return 返回 tb_crm_sms_template.order_id 的值
     *
     * @mbg.generated
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_sms_template.order_id 的值
     *
     * @param orderId 用于指定列 tb_crm_sms_template.order_id 的值
     *
     * @mbg.generated
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}