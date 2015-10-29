package com.huayu.query.personal;

import com.huayu.page.PageBean;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
*
* @author  fly
* @Date 2015-10-27 0:39:29
* version 1.0
*/
public class LotteryIntroQuery{

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
    * 主键
    */
    private long         id;
    /**
    * 彩种类型
    */
    private int         typeCode;
    /**
    * 彩种编号
    */
    private int         lotteryId;
    /**
    * 彩种介绍
    */
    private String         intro;

    public long getId() {
    return id;
    }

    public LotteryIntroQuery setId(long id) {
    this.id = id;
    return this;
    }

    public int getTypeCode() {
    return typeCode;
    }

    public LotteryIntroQuery setTypeCode(int typeCode) {
    this.typeCode = typeCode;
    return this;
    }

    public int getLotteryId() {
    return lotteryId;
    }

    public LotteryIntroQuery setLotteryId(int lotteryId) {
    this.lotteryId = lotteryId;
    return this;
    }

    public String getIntro() {
    return intro;
    }

    public LotteryIntroQuery setIntro(String intro) {
    this.intro = intro;
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
        * 设置排序按属性：type_code
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyTypeCode(boolean isAsc) {
        orderFields.add(new OrderField("type_code", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：lottery_id
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyLotteryId(boolean isAsc) {
        orderFields.add(new OrderField("lottery_id", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：intro
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyIntro(boolean isAsc) {
        orderFields.add(new OrderField("intro", isAsc ? "ASC" : "DESC"));
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
        fieldMap.put("typeCode","type_code");
        fieldMap.put("lotteryId","lottery_id");
        fieldMap.put("intro","intro");
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
         *设置TypeCode
         */
        public void setTypeCodeMap(int value) {
        queryUpdateMap.put("typeCode", value);
        }
        /**
         *设置LotteryId
         */
        public void setLotteryIdMap(int value) {
        queryUpdateMap.put("lotteryId", value);
        }
        /**
         *设置Intro
         */
        public void setIntroMap(String value) {
        queryUpdateMap.put("intro", value);
        }
    }

