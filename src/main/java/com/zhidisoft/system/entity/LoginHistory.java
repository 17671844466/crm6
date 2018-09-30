package com.zhidisoft.system.entity;

import java.util.Date;

public class LoginHistory {
    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_login_history.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_login_history.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_login_history.login_time
     *
     * @mbg.generated
     */
    private Date loginTime;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_login_history.login_ip
     *
     * @mbg.generated
     */
    private String loginIp;

    /**
     *
     * 当前属性由 MyBatis Generator 自动生成.
     * 当前属性对应的数据库表字段为： tb_crm_login_history.login_status
     *
     * @mbg.generated
     */
    private String loginStatus;

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_login_history.id 的值
     *
     * @return 返回 tb_crm_login_history.id 的值
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_login_history.id 的值
     *
     * @param id 用于指定列 tb_crm_login_history.id 的值
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_login_history.user_id 的值
     *
     * @return 返回 tb_crm_login_history.user_id 的值
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_login_history.user_id 的值
     *
     * @param userId 用于指定列 tb_crm_login_history.user_id 的值
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_login_history.login_time 的值
     *
     * @return 返回 tb_crm_login_history.login_time 的值
     *
     * @mbg.generated
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_login_history.login_time 的值
     *
     * @param loginTime 用于指定列 tb_crm_login_history.login_time 的值
     *
     * @mbg.generated
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_login_history.login_ip 的值
     *
     * @return 返回 tb_crm_login_history.login_ip 的值
     *
     * @mbg.generated
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_login_history.login_ip 的值
     *
     * @param loginIp 用于指定列 tb_crm_login_history.login_ip 的值
     *
     * @mbg.generated
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 该方法返回数据库表中列 tb_crm_login_history.login_status 的值
     *
     * @return 返回 tb_crm_login_history.login_status 的值
     *
     * @mbg.generated
     */
    public String getLoginStatus() {
        return loginStatus;
    }

    /**
     * 当前方法由 MyBatis Generator 自动生成.
     * 当前方法用于设置数据库表中列 tb_crm_login_history.login_status 的值
     *
     * @param loginStatus 用于指定列 tb_crm_login_history.login_status 的值
     *
     * @mbg.generated
     */
    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus == null ? null : loginStatus.trim();
    }
}