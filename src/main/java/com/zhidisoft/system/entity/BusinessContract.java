package com.zhidisoft.system.entity;

public class BusinessContract {
    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_r_business_contract.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_r_business_contract.business_id
     *
     * @mbg.generated
     */
    private Integer businessId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_r_business_contract.contract_id
     *
     * @mbg.generated
     */
    private Integer contractId;

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_r_business_contract.id 的值
     *
     * @return 返回 tb_crm_r_business_contract.id 的值
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_r_business_contract.id 的值
     *
     * @param id 用于指定列 tb_crm_r_business_contract.id 的值
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_r_business_contract.business_id 的值
     *
     * @return 返回 tb_crm_r_business_contract.business_id 的值
     *
     * @mbg.generated
     */
    public Integer getBusinessId() {
        return businessId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_r_business_contract.business_id 的值
     *
     * @param businessId 用于指定列 tb_crm_r_business_contract.business_id 的值
     *
     * @mbg.generated
     */
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_r_business_contract.contract_id 的值
     *
     * @return 返回 tb_crm_r_business_contract.contract_id 的值
     *
     * @mbg.generated
     */
    public Integer getContractId() {
        return contractId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_r_business_contract.contract_id 的值
     *
     * @param contractId 用于指定列 tb_crm_r_business_contract.contract_id 的值
     *
     * @mbg.generated
     */
    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }
}