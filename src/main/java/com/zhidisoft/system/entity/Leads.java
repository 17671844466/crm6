package com.zhidisoft.system.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Leads {
    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.owner_user_id
     *
     * @mbg.generated
     */
    private Integer ownerUserId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.creator_user_id
     *
     * @mbg.generated
     */
    private Integer creatorUserId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.position
     *
     * @mbg.generated
     */
    private String position;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.contacts_name
     *
     * @mbg.generated
     */
    private String contactsName;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.saltname
     *
     * @mbg.generated
     */
    private String saltname;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.mobile
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.email
     *
     * @mbg.generated
     */
    private String email;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.create_time
     *
     * @mbg.generated
     */
   
    private Date createTime;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.delete_status
     *
     * @mbg.generated
     */
    private Integer deleteStatus=0;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.delete_user_id
     *
     * @mbg.generated
     */
    private Integer deleteUserId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.delete_time
     *
     * @mbg.generated
     */
    private Date deleteTime;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.is_transformed
     *
     * @mbg.generated
     */
    private Integer isTransformed=0;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.transform_user_id
     *
     * @mbg.generated
     */
    private Integer transformUserId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.contacts_id
     *
     * @mbg.generated
     */
    private Integer contactsId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.customer_id
     *
     * @mbg.generated
     */
    private Integer customerId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.business_id
     *
     * @mbg.generated
     */
    private Integer businessId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.nextstep
     *
     * @mbg.generated
     */
    private String nextstep;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.nextstep_time
     *
     * @mbg.generated
     */
    private Date nextstepTime;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.have_time
     *
     * @mbg.generated
     */
    private Date haveTime;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.source
     *
     * @mbg.generated
     */
    private String source;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_leads.leadnote
     *
     * @mbg.generated
     */
    private String leadnote;

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.id 的值
     *
     * @return 返回 tb_crm_leads.id 的值
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.id 的值
     *
     * @param id 用于指定列 tb_crm_leads.id 的值
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.owner_user_id 的值
     *
     * @return 返回 tb_crm_leads.owner_user_id 的值
     *
     * @mbg.generated
     */
    public Integer getOwnerUserId() {
        return ownerUserId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.owner_user_id 的值
     *
     * @param ownerUserId 用于指定列 tb_crm_leads.owner_user_id 的值
     *
     * @mbg.generated
     */
    public void setOwnerUserId(Integer ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.creator_user_id 的值
     *
     * @return 返回 tb_crm_leads.creator_user_id 的值
     *
     * @mbg.generated
     */
    public Integer getCreatorUserId() {
        return creatorUserId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.creator_user_id 的值
     *
     * @param creatorUserId 用于指定列 tb_crm_leads.creator_user_id 的值
     *
     * @mbg.generated
     */
    public void setCreatorUserId(Integer creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.name 的值
     *
     * @return 返回 tb_crm_leads.name 的值
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.name 的值
     *
     * @param name 用于指定列 tb_crm_leads.name 的值
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.position 的值
     *
     * @return 返回 tb_crm_leads.position 的值
     *
     * @mbg.generated
     */
    public String getPosition() {
        return position;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.position 的值
     *
     * @param position 用于指定列 tb_crm_leads.position 的值
     *
     * @mbg.generated
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.contacts_name 的值
     *
     * @return 返回 tb_crm_leads.contacts_name 的值
     *
     * @mbg.generated
     */
    public String getContactsName() {
        return contactsName;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.contacts_name 的值
     *
     * @param contactsName 用于指定列 tb_crm_leads.contacts_name 的值
     *
     * @mbg.generated
     */
    public void setContactsName(String contactsName) {
        this.contactsName = contactsName == null ? null : contactsName.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.saltname 的值
     *
     * @return 返回 tb_crm_leads.saltname 的值
     *
     * @mbg.generated
     */
    public String getSaltname() {
        return saltname;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.saltname 的值
     *
     * @param saltname 用于指定列 tb_crm_leads.saltname 的值
     *
     * @mbg.generated
     */
    public void setSaltname(String saltname) {
        this.saltname = saltname == null ? null : saltname.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.mobile 的值
     *
     * @return 返回 tb_crm_leads.mobile 的值
     *
     * @mbg.generated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.mobile 的值
     *
     * @param mobile 用于指定列 tb_crm_leads.mobile 的值
     *
     * @mbg.generated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.email 的值
     *
     * @return 返回 tb_crm_leads.email 的值
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.email 的值
     *
     * @param email 用于指定列 tb_crm_leads.email 的值
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.create_time 的值
     *
     * @return 返回 tb_crm_leads.create_time 的值
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.create_time 的值
     *
     * @param createTime 用于指定列 tb_crm_leads.create_time 的值
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.update_time 的值
     *
     * @return 返回 tb_crm_leads.update_time 的值
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.update_time 的值
     *
     * @param updateTime 用于指定列 tb_crm_leads.update_time 的值
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.delete_status 的值
     *
     * @return 返回 tb_crm_leads.delete_status 的值
     *
     * @mbg.generated
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.delete_status 的值
     *
     * @param deleteStatus 用于指定列 tb_crm_leads.delete_status 的值
     *
     * @mbg.generated
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.delete_user_id 的值
     *
     * @return 返回 tb_crm_leads.delete_user_id 的值
     *
     * @mbg.generated
     */
    public Integer getDeleteUserId() {
        return deleteUserId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.delete_user_id 的值
     *
     * @param deleteUserId 用于指定列 tb_crm_leads.delete_user_id 的值
     *
     * @mbg.generated
     */
    public void setDeleteUserId(Integer deleteUserId) {
        this.deleteUserId = deleteUserId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.delete_time 的值
     *
     * @return 返回 tb_crm_leads.delete_time 的值
     *
     * @mbg.generated
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.delete_time 的值
     *
     * @param deleteTime 用于指定列 tb_crm_leads.delete_time 的值
     *
     * @mbg.generated
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.is_transformed 的值
     *
     * @return 返回 tb_crm_leads.is_transformed 的值
     *
     * @mbg.generated
     */
    public Integer getIsTransformed() {
        return isTransformed;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.is_transformed 的值
     *
     * @param isTransformed 用于指定列 tb_crm_leads.is_transformed 的值
     *
     * @mbg.generated
     */
    public void setIsTransformed(Integer isTransformed) {
        this.isTransformed = isTransformed;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.transform_user_id 的值
     *
     * @return 返回 tb_crm_leads.transform_user_id 的值
     *
     * @mbg.generated
     */
    public Integer getTransformUserId() {
        return transformUserId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.transform_user_id 的值
     *
     * @param transformUserId 用于指定列 tb_crm_leads.transform_user_id 的值
     *
     * @mbg.generated
     */
    public void setTransformUserId(Integer transformUserId) {
        this.transformUserId = transformUserId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.contacts_id 的值
     *
     * @return 返回 tb_crm_leads.contacts_id 的值
     *
     * @mbg.generated
     */
    public Integer getContactsId() {
        return contactsId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.contacts_id 的值
     *
     * @param contactsId 用于指定列 tb_crm_leads.contacts_id 的值
     *
     * @mbg.generated
     */
    public void setContactsId(Integer contactsId) {
        this.contactsId = contactsId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.customer_id 的值
     *
     * @return 返回 tb_crm_leads.customer_id 的值
     *
     * @mbg.generated
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.customer_id 的值
     *
     * @param customerId 用于指定列 tb_crm_leads.customer_id 的值
     *
     * @mbg.generated
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.business_id 的值
     *
     * @return 返回 tb_crm_leads.business_id 的值
     *
     * @mbg.generated
     */
    public Integer getBusinessId() {
        return businessId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.business_id 的值
     *
     * @param businessId 用于指定列 tb_crm_leads.business_id 的值
     *
     * @mbg.generated
     */
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.nextstep 的值
     *
     * @return 返回 tb_crm_leads.nextstep 的值
     *
     * @mbg.generated
     */
    public String getNextstep() {
        return nextstep;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.nextstep 的值
     *
     * @param nextstep 用于指定列 tb_crm_leads.nextstep 的值
     *
     * @mbg.generated
     */
    public void setNextstep(String nextstep) {
        this.nextstep = nextstep == null ? null : nextstep.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.nextstep_time 的值
     *
     * @return 返回 tb_crm_leads.nextstep_time 的值
     *
     * @mbg.generated
     */
    public Date getNextstepTime() {
        return nextstepTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.nextstep_time 的值
     *
     * @param nextstepTime 用于指定列 tb_crm_leads.nextstep_time 的值
     *
     * @mbg.generated
     */
    public void setNextstepTime(Date nextstepTime) {
        this.nextstepTime = nextstepTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.have_time 的值
     *
     * @return 返回 tb_crm_leads.have_time 的值
     *
     * @mbg.generated
     */
    public Date getHaveTime() {
        return haveTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.have_time 的值
     *
     * @param haveTime 用于指定列 tb_crm_leads.have_time 的值
     *
     * @mbg.generated
     */
    public void setHaveTime(Date haveTime) {
        this.haveTime = haveTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.address 的值
     *
     * @return 返回 tb_crm_leads.address 的值
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.address 的值
     *
     * @param address 用于指定列 tb_crm_leads.address 的值
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.source 的值
     *
     * @return 返回 tb_crm_leads.source 的值
     *
     * @mbg.generated
     */
    public String getSource() {
        return source;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.source 的值
     *
     * @param source 用于指定列 tb_crm_leads.source 的值
     *
     * @mbg.generated
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_leads.leadnote 的值
     *
     * @return 返回 tb_crm_leads.leadnote 的值
     *
     * @mbg.generated
     */
    public String getLeadnote() {
        return leadnote;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_leads.leadnote 的值
     *
     * @param leadnote 用于指定列 tb_crm_leads.leadnote 的值
     *
     * @mbg.generated
     */
    public void setLeadnote(String leadnote) {
        this.leadnote = leadnote == null ? null : leadnote.trim();
    }

	@Override
	public String toString() {
		return "Leads [id=" + id + ", ownerUserId=" + ownerUserId + ", creatorUserId=" + creatorUserId + ", name="
				+ name + ", position=" + position + ", contactsName=" + contactsName + ", saltname=" + saltname
				+ ", mobile=" + mobile + ", email=" + email + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", deleteStatus=" + deleteStatus + ", deleteUserId=" + deleteUserId + ", deleteTime="
				+ deleteTime + ", isTransformed=" + isTransformed + ", transformUserId=" + transformUserId
				+ ", contactsId=" + contactsId + ", customerId=" + customerId + ", businessId=" + businessId
				+ ", nextstep=" + nextstep + ", nextstepTime=" + nextstepTime + ", haveTime=" + haveTime + ", address="
				+ address + ", source=" + source + ", leadnote=" + leadnote + "]";
	}
    
}