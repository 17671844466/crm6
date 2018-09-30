package com.zhidisoft.system.entity;

public class BusinessStatus {
    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_business_status.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_business_status.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_business_status.order_id
     *
     * @mbg.generated
     */
    private Integer orderId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_business_status.is_end
     *
     * @mbg.generated
     */
    private Integer isEnd;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_business_status.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_business_status.id 的值
     *
     * @return 返回 tb_crm_business_status.id 的值
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_business_status.id 的值
     *
     * @param id 用于指定列 tb_crm_business_status.id 的值
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_business_status.name 的值
     *
     * @return 返回 tb_crm_business_status.name 的值
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_business_status.name 的值
     *
     * @param name 用于指定列 tb_crm_business_status.name 的值
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_business_status.order_id 的值
     *
     * @return 返回 tb_crm_business_status.order_id 的值
     *
     * @mbg.generated
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_business_status.order_id 的值
     *
     * @param orderId 用于指定列 tb_crm_business_status.order_id 的值
     *
     * @mbg.generated
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_business_status.is_end 的值
     *
     * @return 返回 tb_crm_business_status.is_end 的值
     *
     * @mbg.generated
     */
    public Integer getIsEnd() {
        return isEnd;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_business_status.is_end 的值
     *
     * @param isEnd 用于指定列 tb_crm_business_status.is_end 的值
     *
     * @mbg.generated
     */
    public void setIsEnd(Integer isEnd) {
        this.isEnd = isEnd;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_business_status.description 的值
     *
     * @return 返回 tb_crm_business_status.description 的值
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_business_status.description 的值
     *
     * @param description 用于指定列 tb_crm_business_status.description 的值
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}