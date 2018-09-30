package com.zhidisoft.system.entity;

import java.util.Date;

public class Dict {
    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_dict.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_dict.dictName
     *
     * @mbg.generated
     */
    private String dictname;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_dict.dictValue
     *
     * @mbg.generated
     */
    private String dictvalue;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_dict.dictCode
     *
     * @mbg.generated
     */
    private String dictcode;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_dict.dictNote
     *
     * @mbg.generated
     */
    private String dictnote;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_dict.typeId
     *
     * @mbg.generated
     */
    private Integer typeid;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_dict.state
     *
     * @mbg.generated
     */
    private Integer state;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_dict.sortNum
     *
     * @mbg.generated
     */
    private Integer sortnum;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_dict.createBy
     *
     * @mbg.generated
     */
    private Integer createby;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_dict.createTime
     *
     * @mbg.generated
     */
    private Date createtime;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_dict.updateBy
     *
     * @mbg.generated
     */
    private Integer updateby;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_dict.updateTime
     *
     * @mbg.generated
     */
    private Date updatetime;

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_dict.id 的值
     *
     * @return 返回 tb_system_dict.id 的值
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_dict.id 的值
     *
     * @param id 用于指定列 tb_system_dict.id 的值
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_dict.dictName 的值
     *
     * @return 返回 tb_system_dict.dictName 的值
     *
     * @mbg.generated
     */
    public String getDictname() {
        return dictname;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_dict.dictName 的值
     *
     * @param dictname 用于指定列 tb_system_dict.dictName 的值
     *
     * @mbg.generated
     */
    public void setDictname(String dictname) {
        this.dictname = dictname == null ? null : dictname.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_dict.dictValue 的值
     *
     * @return 返回 tb_system_dict.dictValue 的值
     *
     * @mbg.generated
     */
    public String getDictvalue() {
        return dictvalue;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_dict.dictValue 的值
     *
     * @param dictvalue 用于指定列 tb_system_dict.dictValue 的值
     *
     * @mbg.generated
     */
    public void setDictvalue(String dictvalue) {
        this.dictvalue = dictvalue == null ? null : dictvalue.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_dict.dictCode 的值
     *
     * @return 返回 tb_system_dict.dictCode 的值
     *
     * @mbg.generated
     */
    public String getDictcode() {
        return dictcode;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_dict.dictCode 的值
     *
     * @param dictcode 用于指定列 tb_system_dict.dictCode 的值
     *
     * @mbg.generated
     */
    public void setDictcode(String dictcode) {
        this.dictcode = dictcode == null ? null : dictcode.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_dict.dictNote 的值
     *
     * @return 返回 tb_system_dict.dictNote 的值
     *
     * @mbg.generated
     */
    public String getDictnote() {
        return dictnote;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_dict.dictNote 的值
     *
     * @param dictnote 用于指定列 tb_system_dict.dictNote 的值
     *
     * @mbg.generated
     */
    public void setDictnote(String dictnote) {
        this.dictnote = dictnote == null ? null : dictnote.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_dict.typeId 的值
     *
     * @return 返回 tb_system_dict.typeId 的值
     *
     * @mbg.generated
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_dict.typeId 的值
     *
     * @param typeid 用于指定列 tb_system_dict.typeId 的值
     *
     * @mbg.generated
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_dict.state 的值
     *
     * @return 返回 tb_system_dict.state 的值
     *
     * @mbg.generated
     */
    public Integer getState() {
        return state;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_dict.state 的值
     *
     * @param state 用于指定列 tb_system_dict.state 的值
     *
     * @mbg.generated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_dict.sortNum 的值
     *
     * @return 返回 tb_system_dict.sortNum 的值
     *
     * @mbg.generated
     */
    public Integer getSortnum() {
        return sortnum;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_dict.sortNum 的值
     *
     * @param sortnum 用于指定列 tb_system_dict.sortNum 的值
     *
     * @mbg.generated
     */
    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_dict.createBy 的值
     *
     * @return 返回 tb_system_dict.createBy 的值
     *
     * @mbg.generated
     */
    public Integer getCreateby() {
        return createby;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_dict.createBy 的值
     *
     * @param createby 用于指定列 tb_system_dict.createBy 的值
     *
     * @mbg.generated
     */
    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_dict.createTime 的值
     *
     * @return 返回 tb_system_dict.createTime 的值
     *
     * @mbg.generated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_dict.createTime 的值
     *
     * @param createtime 用于指定列 tb_system_dict.createTime 的值
     *
     * @mbg.generated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_dict.updateBy 的值
     *
     * @return 返回 tb_system_dict.updateBy 的值
     *
     * @mbg.generated
     */
    public Integer getUpdateby() {
        return updateby;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_dict.updateBy 的值
     *
     * @param updateby 用于指定列 tb_system_dict.updateBy 的值
     *
     * @mbg.generated
     */
    public void setUpdateby(Integer updateby) {
        this.updateby = updateby;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_dict.updateTime 的值
     *
     * @return 返回 tb_system_dict.updateTime 的值
     *
     * @mbg.generated
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_dict.updateTime 的值
     *
     * @param updatetime 用于指定列 tb_system_dict.updateTime 的值
     *
     * @mbg.generated
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}