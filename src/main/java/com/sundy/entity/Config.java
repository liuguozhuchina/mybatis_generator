package com.sundy.entity;

/**
 * Created by Administrator on 2015/8/16.
 * 配置文件映射
 */
public class Config {
    /**
     * exception  page 包使用
     */
    private String basepacket;
    /**
     * 数据库映射对象包名
     */
    private String entitypacket;
    /**
     * 封装mybatis查询条件对象包名
     */
    private String querypacket;
    /**
     * mybatis查询接口和xml包名
     */
    private String daopacket;
    /**
     * 服务service包名
     */
    private String servicepacket;
    /**
     * action包名
     */
    private String actionpacket;
    /**
     * 需要生成的表名称
     */
    private String tablename;
    /**
     * 作者
     */
    private String author;
    /**
     * mysql连接数据库
     */
    private String db;
    /**
     * 驱动类
     */
    private String driverClass;
    /**
     * 数据库url
     */
    private String url;
    /**
     * 数据库用户名
     */
    private String username;
    /**
     * 数据库密码
     */
    private String password;


    public String getEntitypacket() {
        return entitypacket;
    }

    public void setEntitypacket(String entitypacket) {
        this.entitypacket = entitypacket;
    }

    public String getQuerypacket() {
        return querypacket;
    }

    public void setQuerypacket(String querypacket) {
        this.querypacket = querypacket;
    }

    public String getDaopacket() {
        return daopacket;
    }

    public void setDaopacket(String daopacket) {
        this.daopacket = daopacket;
    }

    public String getServicepacket() {
        return servicepacket;
    }

    public void setServicepacket(String servicepacket) {
        this.servicepacket = servicepacket;
    }

    public String getActionpacket() {
        return actionpacket;
    }

    public void setActionpacket(String actionpacket) {
        this.actionpacket = actionpacket;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getBasepacket() {
        return basepacket;
    }

    public void setBasepacket(String basepacket) {
        this.basepacket = basepacket;
    }
}
