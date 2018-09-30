package com.zhidisoft.system.entity;

import java.util.Date;

public class Role {
    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_role.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_role.roleName
     *
     * @mbg.generated
     */
    private String rolename;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_role.roleNote
     *
     * @mbg.generated
     */
    private String rolenote;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_role.state
     *
     * @mbg.generated
     */
    private Integer state;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_role.createBy
     *
     * @mbg.generated
     */
    private Integer createby;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_role.createTime
     *
     * @mbg.generated
     */
    private Date createtime;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_role.updateBy
     *
     * @mbg.generated
     */
    private Integer updateby;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_system_role.updateTime
     *
     * @mbg.generated
     */
    private Date updatetime;

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_role.id 的值
     *
     * @return 返回 tb_system_role.id 的值
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_role.id 的值
     *
     * @param id 用于指定列 tb_system_role.id 的值
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_role.roleName 的值
     *
     * @return 返回 tb_system_role.roleName 的值
     *
     * @mbg.generated
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_role.roleName 的值
     *
     * @param rolename 用于指定列 tb_system_role.roleName 的值
     *
     * @mbg.generated
     */
    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_role.roleNote 的值
     *
     * @return 返回 tb_system_role.roleNote 的值
     *
     * @mbg.generated
     */
    public String getRolenote() {
        return rolenote;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_role.roleNote 的值
     *
     * @param rolenote 用于指定列 tb_system_role.roleNote 的值
     *
     * @mbg.generated
     */
    public void setRolenote(String rolenote) {
        this.rolenote = rolenote == null ? null : rolenote.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_role.state 的值
     *
     * @return 返回 tb_system_role.state 的值
     *
     * @mbg.generated
     */
    public Integer getState() {
        return state;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_role.state 的值
     *
     * @param state 用于指定列 tb_system_role.state 的值
     *
     * @mbg.generated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_role.createBy 的值
     *
     * @return 返回 tb_system_role.createBy 的值
     *
     * @mbg.generated
     */
    public Integer getCreateby() {
        return createby;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_role.createBy 的值
     *
     * @param createby 用于指定列 tb_system_role.createBy 的值
     *
     * @mbg.generated
     */
    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_role.createTime 的值
     *
     * @return 返回 tb_system_role.createTime 的值
     *
     * @mbg.generated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_role.createTime 的值
     *
     * @param createtime 用于指定列 tb_system_role.createTime 的值
     *
     * @mbg.generated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_role.updateBy 的值
     *
     * @return 返回 tb_system_role.updateBy 的值
     *
     * @mbg.generated
     */
    public Integer getUpdateby() {
        return updateby;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_role.updateBy 的值
     *
     * @param updateby 用于指定列 tb_system_role.updateBy 的值
     *
     * @mbg.generated
     */
    public void setUpdateby(Integer updateby) {
        this.updateby = updateby;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_system_role.updateTime 的值
     *
     * @return 返回 tb_system_role.updateTime 的值
     *
     * @mbg.generated
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_system_role.updateTime 的值
     *
     * @param updatetime 用于指定列 tb_system_role.updateTime 的值
     *
     * @mbg.generated
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }


	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + ", rolenote=" + rolenote + ", state=" + state
				+ ", createby=" + createby + ", createtime=" + createtime + ", updateby=" + updateby + ", updatetime="
				+ updatetime + "]";
	}

}