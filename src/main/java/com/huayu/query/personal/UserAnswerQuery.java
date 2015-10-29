package com.huayu.query.personal;

import com.huayu.page.PageBean;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
*
* @author  fly
* @Date 2015-10-27 0:52:21
* version 1.0
*/
public class UserAnswerQuery{

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
    * 用户id
    */
    private long         userId;
    /**
    * 问题id
    */
    private int         questionId;
    /**
    * 答案
    */
    private String         answer;
    /**
    * 问题类型(1问题一 2问题二 3问题三)
    */
    private int         type;
    /**
    * 更新时间
    */
    private Date         updateTime;
    /**
    * 创建时间
    */
    private Date         createTime;

    public long getId() {
    return id;
    }

    public UserAnswerQuery setId(long id) {
    this.id = id;
    return this;
    }

    public long getUserId() {
    return userId;
    }

    public UserAnswerQuery setUserId(long userId) {
    this.userId = userId;
    return this;
    }

    public int getQuestionId() {
    return questionId;
    }

    public UserAnswerQuery setQuestionId(int questionId) {
    this.questionId = questionId;
    return this;
    }

    public String getAnswer() {
    return answer;
    }

    public UserAnswerQuery setAnswer(String answer) {
    this.answer = answer;
    return this;
    }

    public int getType() {
    return type;
    }

    public UserAnswerQuery setType(int type) {
    this.type = type;
    return this;
    }

    public Date getUpdateTime() {
    return updateTime;
    }

    public UserAnswerQuery setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
    return this;
    }

    public Date getCreateTime() {
    return createTime;
    }

    public UserAnswerQuery setCreateTime(Date createTime) {
    this.createTime = createTime;
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
        * 设置排序按属性：user_id
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyUserId(boolean isAsc) {
        orderFields.add(new OrderField("user_id", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：question_id
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyQuestionId(boolean isAsc) {
        orderFields.add(new OrderField("question_id", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：answer
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyAnswer(boolean isAsc) {
        orderFields.add(new OrderField("answer", isAsc ? "ASC" : "DESC"));
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
        private String fields;
        /**
        * 提供自定义字段使用
        */
        private static Map<String, String> fieldMap;

        private static Map<String, String> getFieldSet() {
        if (fieldMap == null) {
        fieldMap = new HashMap<String, String>();
        fieldMap.put("id","id");
        fieldMap.put("userId","user_id");
        fieldMap.put("questionId","question_id");
        fieldMap.put("answer","answer");
        fieldMap.put("type","type");
        fieldMap.put("updateTime","update_time");
        fieldMap.put("createTime","create_time");
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
         *设置UserId
         */
        public void setUserIdMap(long value) {
        queryUpdateMap.put("userId", value);
        }
        /**
         *设置QuestionId
         */
        public void setQuestionIdMap(int value) {
        queryUpdateMap.put("questionId", value);
        }
        /**
         *设置Answer
         */
        public void setAnswerMap(String value) {
        queryUpdateMap.put("answer", value);
        }
        /**
         *设置Type
         */
        public void setTypeMap(int value) {
        queryUpdateMap.put("type", value);
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
    }

