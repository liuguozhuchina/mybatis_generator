package com.huayu.query.personal;

import com.huayu.page.PageBean;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
*
* @author  fly
* @Date 2015-10-27 0:57:31
* version 1.0
*/
public class QuestionsQuery{

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
    * 问题
    */
    private String         dnaQues;
    /**
    * 问题类型(1问题一 2问题二 3问题三)
    */
    private int         type;
    /**
    * 问题id
    */
    private int         questionId;

    public long getId() {
    return id;
    }

    public QuestionsQuery setId(long id) {
    this.id = id;
    return this;
    }

    public String getDnaQues() {
    return dnaQues;
    }

    public QuestionsQuery setDnaQues(String dnaQues) {
    this.dnaQues = dnaQues;
    return this;
    }

    public int getType() {
    return type;
    }

    public QuestionsQuery setType(int type) {
    this.type = type;
    return this;
    }

    public int getQuestionId() {
    return questionId;
    }

    public QuestionsQuery setQuestionId(int questionId) {
    this.questionId = questionId;
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
        * 设置排序按属性：dna_ques
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyDnaQues(boolean isAsc) {
        orderFields.add(new OrderField("dna_ques", isAsc ? "ASC" : "DESC"));
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
        * 设置排序按属性：question_id
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyQuestionId(boolean isAsc) {
        orderFields.add(new OrderField("question_id", isAsc ? "ASC" : "DESC"));
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
        fieldMap.put("dnaQues","dna_ques");
        fieldMap.put("type","type");
        fieldMap.put("questionId","question_id");
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
         *设置DnaQues
         */
        public void setDnaQuesMap(String value) {
        queryUpdateMap.put("dnaQues", value);
        }
        /**
         *设置Type
         */
        public void setTypeMap(int value) {
        queryUpdateMap.put("type", value);
        }
        /**
         *设置QuestionId
         */
        public void setQuestionIdMap(int value) {
        queryUpdateMap.put("questionId", value);
        }
    }

