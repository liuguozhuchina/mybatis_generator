package com.sundy.query;

import com.sundy.page.PageBean;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
*
* @author  liuguozhu
* @Date 2015-9-24 20:25:04
* version 1.0
*/
public class TLotteryQuery{

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
    * 彩票名称
    */
    private String         name;
    /**
    * 彩票采集url
    */
    private String         url;
    /**
    * 更新时间
    */
    private Date         updateTime;
    /**
    * 创建时间
    */
    private Date         createTime;
    /**
    * 彩票唯一id
    */
    private int         lotteryId;
    /**
    * 彩票类型
    */
    private int         type;

    public long getId() {
    return id;
    }

    public TLotteryQuery setId(long id) {
    this.id = id;
    return this;
    }

    public String getName() {
    return name;
    }

    public TLotteryQuery setName(String name) {
    this.name = name;
    return this;
    }

    public String getUrl() {
    return url;
    }

    public TLotteryQuery setUrl(String url) {
    this.url = url;
    return this;
    }

    public Date getUpdateTime() {
    return updateTime;
    }

    public TLotteryQuery setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
    return this;
    }

    public Date getCreateTime() {
    return createTime;
    }

    public TLotteryQuery setCreateTime(Date createTime) {
    this.createTime = createTime;
    return this;
    }

    public int getLotteryId() {
    return lotteryId;
    }

    public TLotteryQuery setLotteryId(int lotteryId) {
    this.lotteryId = lotteryId;
    return this;
    }

    public int getType() {
    return type;
    }

    public TLotteryQuery setType(int type) {
    this.type = type;
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
        * 设置排序按属性：name
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyName(boolean isAsc) {
        orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：url
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyUrl(boolean isAsc) {
        orderFields.add(new OrderField("url", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：update_time
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyUpdateTime(boolean isAsc) {
        orderFields.add(new OrderField("update_time", isAsc ? "ASC" : "DESC"));
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
        * 设置排序按属性：type
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyType(boolean isAsc) {
        orderFields.add(new OrderField("type", isAsc ? "ASC" : "DESC"));
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
        fieldMap.put("name","name");
        fieldMap.put("url","url");
        fieldMap.put("updateTime","update_time");
        fieldMap.put("createTime","create_time");
        fieldMap.put("lotteryId","lottery_id");
        fieldMap.put("type","type");
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
         *设置Name
         */
        public void setNameMap(String value) {
        queryUpdateMap.put("name", value);
        }
        /**
         *设置Url
         */
        public void setUrlMap(String value) {
        queryUpdateMap.put("url", value);
        }
        /**
         *设置UpdateTime
         */
        public void setUpdateTimeMap(Date value) {
        queryUpdateMap.put("updateTime", value);
        }
        /**
         *设置CreateTime
         */
        public void setCreateTimeMap(Date value) {
        queryUpdateMap.put("createTime", value);
        }
        /**
         *设置LotteryId
         */
        public void setLotteryIdMap(int value) {
        queryUpdateMap.put("lotteryId", value);
        }
        /**
         *设置Type
         */
        public void setTypeMap(int value) {
        queryUpdateMap.put("type", value);
        }
    }

