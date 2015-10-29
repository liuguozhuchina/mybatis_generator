package com.sundy.entity;

/**
 * Created by Administrator on 2015/8/15.
 * 数据库表对象
 */
public class Table {
    /**
     * 表名称
     **/
    private String name;
    /**
     * 表说明
     **/
    private String comment;
    /**
     * 数据库表引擎
     **/
    private String engine;
    /**
     * 行数
     **/
    private int rows;
    /**
     * 自增主键id
     */
    private long autoIncrement;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public long getAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(long autoIncrement) {
        this.autoIncrement = autoIncrement;
    }
}
