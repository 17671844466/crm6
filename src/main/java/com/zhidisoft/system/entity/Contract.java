package com.zhidisoft.system.entity;

public class Contract {
    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.number
     *
     * @mbg.generated
     */
    private String number;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.business_id
     *
     * @mbg.generated
     */
    private Integer businessId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.price
     *
     * @mbg.generated
     */
    private Long price;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.due_time
     *
     * @mbg.generated
     */
    private Long dueTime;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.owner_user_id
     *
     * @mbg.generated
     */
    private Integer ownerUserId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.creator_user_id
     *
     * @mbg.generated
     */
    private Integer creatorUserId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.create_time
     *
     * @mbg.generated
     */
    private Long createTime;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.update_time
     *
     * @mbg.generated
     */
    private Long updateTime;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.start_date
     *
     * @mbg.generated
     */
    private Long startDate;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.end_date
     *
     * @mbg.generated
     */
    private Long endDate;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.status
     *
     * @mbg.generated
     */
    private String status;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.delete_status
     *
     * @mbg.generated
     */
    private Integer deleteStatus;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.delete_user_id
     *
     * @mbg.generated
     */
    private Integer deleteUserId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.delete_time
     *
     * @mbg.generated
     */
    private Long deleteTime;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_contract.content
     *
     * @mbg.generated
     */
    private String content;

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.id 的值
     *
     * @return 返回 tb_crm_contract.id 的值
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.id 的值
     *
     * @param id 用于指定列 tb_crm_contract.id 的值
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.number 的值
     *
     * @return 返回 tb_crm_contract.number 的值
     *
     * @mbg.generated
     */
    public String getNumber() {
        return number;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.number 的值
     *
     * @param number 用于指定列 tb_crm_contract.number 的值
     *
     * @mbg.generated
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.business_id 的值
     *
     * @return 返回 tb_crm_contract.business_id 的值
     *
     * @mbg.generated
     */
    public Integer getBusinessId() {
        return businessId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.business_id 的值
     *
     * @param businessId 用于指定列 tb_crm_contract.business_id 的值
     *
     * @mbg.generated
     */
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.price 的值
     *
     * @return 返回 tb_crm_contract.price 的值
     *
     * @mbg.generated
     */
    public Long getPrice() {
        return price;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.price 的值
     *
     * @param price 用于指定列 tb_crm_contract.price 的值
     *
     * @mbg.generated
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.due_time 的值
     *
     * @return 返回 tb_crm_contract.due_time 的值
     *
     * @mbg.generated
     */
    public Long getDueTime() {
        return dueTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.due_time 的值
     *
     * @param dueTime 用于指定列 tb_crm_contract.due_time 的值
     *
     * @mbg.generated
     */
    public void setDueTime(Long dueTime) {
        this.dueTime = dueTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.owner_user_id 的值
     *
     * @return 返回 tb_crm_contract.owner_user_id 的值
     *
     * @mbg.generated
     */
    public Integer getOwnerUserId() {
        return ownerUserId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.owner_user_id 的值
     *
     * @param ownerUserId 用于指定列 tb_crm_contract.owner_user_id 的值
     *
     * @mbg.generated
     */
    public void setOwnerUserId(Integer ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.creator_user_id 的值
     *
     * @return 返回 tb_crm_contract.creator_user_id 的值
     *
     * @mbg.generated
     */
    public Integer getCreatorUserId() {
        return creatorUserId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.creator_user_id 的值
     *
     * @param creatorUserId 用于指定列 tb_crm_contract.creator_user_id 的值
     *
     * @mbg.generated
     */
    public void setCreatorUserId(Integer creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.description 的值
     *
     * @return 返回 tb_crm_contract.description 的值
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.description 的值
     *
     * @param description 用于指定列 tb_crm_contract.description 的值
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.create_time 的值
     *
     * @return 返回 tb_crm_contract.create_time 的值
     *
     * @mbg.generated
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.create_time 的值
     *
     * @param createTime 用于指定列 tb_crm_contract.create_time 的值
     *
     * @mbg.generated
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.update_time 的值
     *
     * @return 返回 tb_crm_contract.update_time 的值
     *
     * @mbg.generated
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.update_time 的值
     *
     * @param updateTime 用于指定列 tb_crm_contract.update_time 的值
     *
     * @mbg.generated
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.start_date 的值
     *
     * @return 返回 tb_crm_contract.start_date 的值
     *
     * @mbg.generated
     */
    public Long getStartDate() {
        return startDate;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.start_date 的值
     *
     * @param startDate 用于指定列 tb_crm_contract.start_date 的值
     *
     * @mbg.generated
     */
    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.end_date 的值
     *
     * @return 返回 tb_crm_contract.end_date 的值
     *
     * @mbg.generated
     */
    public Long getEndDate() {
        return endDate;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.end_date 的值
     *
     * @param endDate 用于指定列 tb_crm_contract.end_date 的值
     *
     * @mbg.generated
     */
    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.status 的值
     *
     * @return 返回 tb_crm_contract.status 的值
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.status 的值
     *
     * @param status 用于指定列 tb_crm_contract.status 的值
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.delete_status 的值
     *
     * @return 返回 tb_crm_contract.delete_status 的值
     *
     * @mbg.generated
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.delete_status 的值
     *
     * @param deleteStatus 用于指定列 tb_crm_contract.delete_status 的值
     *
     * @mbg.generated
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.delete_user_id 的值
     *
     * @return 返回 tb_crm_contract.delete_user_id 的值
     *
     * @mbg.generated
     */
    public Integer getDeleteUserId() {
        return deleteUserId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.delete_user_id 的值
     *
     * @param deleteUserId 用于指定列 tb_crm_contract.delete_user_id 的值
     *
     * @mbg.generated
     */
    public void setDeleteUserId(Integer deleteUserId) {
        this.deleteUserId = deleteUserId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.delete_time 的值
     *
     * @return 返回 tb_crm_contract.delete_time 的值
     *
     * @mbg.generated
     */
    public Long getDeleteTime() {
        return deleteTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.delete_time 的值
     *
     * @param deleteTime 用于指定列 tb_crm_contract.delete_time 的值
     *
     * @mbg.generated
     */
    public void setDeleteTime(Long deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_contract.content 的值
     *
     * @return 返回 tb_crm_contract.content 的值
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_contract.content 的值
     *
     * @param content 用于指定列 tb_crm_contract.content 的值
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}