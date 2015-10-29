package com.sundy.query;

import com.sundy.page.PageBean;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
*
* @author  liuguozhu
* @Date 2015-9-7 22:15:11
* version 1.0
*/
public class UserQuery{

    /**
    * 开始页
    */
    private int startRow;
    /**
    * 分页数据大小
    */
    private int pageSize= PageBean.PAGESIZE;

    /** ==============================批量查询、更新、删除时的Where条件设置====================== **/
    /**
    * 主键id
    */
    private long         id;
    /**
    * 用户名
    */
    private String         userName;
    /**
    * 密码
    */
    private String         password;
    /**
    * 年龄
    */
    private int         age;
    /**
    * 创建时间
    */
    private Date         createTime;
    /**
    * 版本
    */
    private long         version;

    public long getId() {
    return id;
    }

    public UserQuery setId(long id) {
    this.id = id;
    return this;
    }

    public String getUserName() {
    return userName;
    }

    public UserQuery setUserName(String userName) {
    this.userName = userName;
    return this;
    }

    public String getPassword() {
    return password;
    }

    public UserQuery setPassword(String password) {
    this.password = password;
    return this;
    }

    public int getAge() {
    return age;
    }

    public UserQuery setAge(int age) {
    this.age = age;
    return this;
    }

    public Date getCreateTime() {
    return createTime;
    }

    public UserQuery setCreateTime(Date createTime) {
    this.createTime = createTime;
    return this;
    }

    public long getVersion() {
    return version;
    }

    public UserQuery setVersion(long version) {
    this.version = version;
    return this;
    }


    public int getStartRow() {
    return startRow;
    }

    public void setStartRow(int startRow) {
    this.startRow = startRow;
    queryUpdateMap.put("startRow",startRow);
    }

    public int getPageSize() {
    return pageSize;
    }

    public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
    queryUpdateMap.put("pageSize",pageSize);
    }

    /** ==============================批量查询时的Order条件顺序设置====================== **/

    public class OrderField {
    /**
    * 字段名称
    */
    private String fieldName;
    /**
    * 升降序
    */
    private String order;

    public OrderField(String fieldName, String order) {
    super();
    this.fieldName = fieldName;
    this.order = order;
    }

    public String getFieldName() {
    return fieldName;
    }

    public OrderField setFieldName(String fieldName) {
    this.fieldName = fieldName;
    return this;
    }

    public String getOrder() {
    return order;
    }

    public OrderField setOrder(String order) {
    this.order = order;
    return this;
    }
    }

    /** ==============================批量查询时的Order条件顺序设置====================== **/
    /**
    * 排序列表字段
    **/
    private List<OrderField> orderFields = new ArrayList<OrderField>();

        /**
        * 设置排序按属性：id
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyId(boolean isAsc) {
        orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：user_name
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyUserName(boolean isAsc) {
        orderFields.add(new OrderField("user_name", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：password
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyPassword(boolean isAsc) {
        orderFields.add(new OrderField("password", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：age
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyAge(boolean isAsc) {
        orderFields.add(new OrderField("age", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：create_time
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyCreateTime(boolean isAsc) {
        orderFields.add(new OrderField("create_time", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：version
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyVersion(boolean isAsc) {
        orderFields.add(new OrderField("version", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        private String fields;
        /**
        * 提供自定义字段使用
        */
        private static Map<String, String> fieldMap;

        private static Map<String, String> getFieldSet() {
        if (fieldMap == null) {
        fieldMap = new HashMap<String, String>();
        fieldMap.put("id","id");
        fieldMap.put("userName","user_name");
        fieldMap.put("password","password");
        fieldMap.put("age","age");
        fieldMap.put("createTime","create_time");
        fieldMap.put("version","version");
        }
        return fieldMap;
        }

        public String getFields() {
        return this.fields;
        }

        public void setFields(String fields) {
        if (fields == null)
        return;
        String[] array = fields.split(",");
        StringBuffer buffer = new StringBuffer();
        for (String field : array) {
        if (getFieldSet().containsKey(field)) {
        buffer.append(getFieldSet().get(field)).append(" as ")
        .append(field).append(" ,");
        }
        if (getFieldSet().containsKey("`" + field + "`")) {
        buffer.append("`" + getFieldSet().get(field) + "`").append(" as ")
        .append(field).append(" ,");
        }
        }
        if (buffer.length() != 0) {
        this.fields = buffer.substring(0, buffer.length() - 1);
        } else {
        this.fields = " 1 ";// 没有一个参数可能会报错
        }
        }

    /**
    * ==============================查询更新map条件======================
    **/
    private Map<String, Object> queryUpdateMap = new HashMap<String, Object>();

    /**
    * 清空更新集合
    */
    public void clear() {
    queryUpdateMap.clear();
    }

    public Map getQueryUpdateMap() {
    return queryUpdateMap;
    }

    public void setQueryUpdateMap(Map queryUpdateMap) {
    this.queryUpdateMap = queryUpdateMap;
    }


        /**
         *设置Id
         */
        public void setIdMap(long value) {
        queryUpdateMap.put("id", value);
        }
        /**
         *设置UserName
         */
        public void setUserNameMap(String value) {
        queryUpdateMap.put("userName", value);
        }
        /**
         *设置Password
         */
        public void setPasswordMap(String value) {
        queryUpdateMap.put("password", value);
        }
        /**
         *设置Age
         */
        public void setAgeMap(int value) {
        queryUpdateMap.put("age", value);
        }
        /**
         *设置CreateTime
         */
        public void setCreateTimeMap(Date value) {
        queryUpdateMap.put("createTime", value);
        }
        /**
         *设置Version
         */
        public void setVersionMap(long value) {
        queryUpdateMap.put("version", value);
        }
    }

