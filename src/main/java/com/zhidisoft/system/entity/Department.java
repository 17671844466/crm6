package com.zhidisoft.system.entity;

public class Department {
    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_department.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_department.parent_id
     *
     * @mbg.generated
     */
    private Integer parentId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_department.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_department.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_department.id 的值
     *
     * @return 返回 tb_crm_department.id 的值
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_department.id 的值
     *
     * @param id 用于指定列 tb_crm_department.id 的值
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_department.parent_id 的值
     *
     * @return 返回 tb_crm_department.parent_id 的值
     *
     * @mbg.generated
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_department.parent_id 的值
     *
     * @param parentId 用于指定列 tb_crm_department.parent_id 的值
     *
     * @mbg.generated
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_department.name 的值
     *
     * @return 返回 tb_crm_department.name 的值
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_department.name 的值
     *
     * @param name 用于指定列 tb_crm_department.name 的值
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_department.description 的值
     *
     * @return 返回 tb_crm_department.description 的值
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_department.description 的值
     *
     * @param description 用于指定列 tb_crm_department.description 的值
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}