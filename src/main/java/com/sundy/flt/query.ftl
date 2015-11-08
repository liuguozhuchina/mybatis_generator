package ${query_p};

import ${pagepacket}.PageBean;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
*
* @author  ${author}
* @Date ${currentTime?datetime}
* version 1.0
*/
public class ${Entity}Query{

    /**
    * 开始页
    */
    private int startRow;
    /**
    * 分页数据大小
    */
    private int pageSize= PageBean.PAGESIZE;

    /** ==============================批量查询、更新、删除时的Where条件设置====================== **/
    <#list fields as field>
    /**
    * ${field.comment}
    */
    private <@fieldType type=field.fieldType /> <#rt>
        <#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>;
    </#list>

    <#list fields as field>
    public <@fieldType type=field.fieldType/> get<#list field.name?split('_') as n>${n?cap_first}</#list>() {
    return <#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>;
    }

    public ${Entity}Query set<#list field.name?split('_') as n>${n?cap_first}</#list>(<@fieldType type=field.fieldType/> <#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>) {
    this.<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list> = <#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>;
    return this;
    }

    </#list>

    public int getStartRow() {
    return startRow;
    }

    public void setStartRow(int startRow) {
    this.startRow = startRow;
    }

    public void setCurrentPage(int currentPage) {
    int pageSize = (Integer) queryUpdateMap.get("pageSize");
    this.startRow = (currentPage - 1) * pageSize;
    queryUpdateMap.put("startRow", startRow);
    }



    public int getPageSize() {
    return pageSize;
    }

    public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
    queryUpdateMap.put("pageSize",pageSize);
    }

    /** ==============================属性名称====================== **/
    <#list fields as field>
    public String get<#list field.name?split('_') as n>${n?cap_first}</#list>Name() {
    return   ${r'"'}<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>${r'"'};
    }
    </#list>

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

    <#list fields as field>
        /**
        * 设置排序按属性：${field.name}
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderby<#list field.name?split('_') as n>${n?cap_first}</#list>(boolean isAsc) {
        orderFields.add(new OrderField("${field.name}", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
    </#list>
        private String fields;
        /**
        * 提供自定义字段使用
        */
        private  Map<String, String> fieldMap;

        private  Map<String, String> getFieldSet() {
        if (fieldMap == null) {
        fieldMap = new HashMap<String, String>();
    <#list fields as field>
        fieldMap.put("<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>","${field.name}");
    </#list>
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


    <#list fields as field>
        /**
         *设置<#list field.name?split('_') as n>${n?cap_first}</#list>
         */
        public void set<#list field.name?split('_') as n>${n?cap_first}</#list>Map(<@fieldType type=field.fieldType/> value) {
        queryUpdateMap.put("<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>", value);
        }
    </#list>








    /**
    * ==============================复杂sql条件======================
    **/

    /**
    * 创建复杂查询sql条件
    */
    public void initCriteria() {
    if (oredCriteria == null) {
    oredCriteria = new Criteria();
    }
    }

    /**
    * 去除重复
    */
    private boolean distinct;


    /**
    * 复杂sql
    */
    private Criteria oredCriteria;


    public boolean isDistinct() {
    return distinct;
    }

    public void setDistinct(boolean distinct) {
    this.distinct = distinct;
    }

    public Criteria getOredCriteria() {
    return oredCriteria;
    }

    public void setOredCriteria(Criteria oredCriteria) {
    this.oredCriteria = oredCriteria;
    }




    /**
    * 设置不重复的字段查询
    */
    public void setDistinctColumn(String property) {
    StringBuffer sb = new StringBuffer();
    this.distinct = true;
    sb.append("distinct(" + getFieldSet().get(property) + "), ");
    Map<String, String> fieldMap = getFieldSet();
    if (fieldMap.get(property) == null) {
    throw new RuntimeException("property[" + property + "] is not exist");
    }
    fieldMap.remove(property);
    for (Map.Entry<String, String> entrySet : fieldMap.entrySet()) {
    sb.append(" " + entrySet.getValue() + ",");
    }
    this.fields = sb.substring(0, sb.toString().length() - 1);
    this.queryUpdateMap.put("fields", this.fields);
    }


    /**
    * 属性是空查询
    *
    * @param property
    */
    public void andIsNull(String property) {
    initCriteria();
    //数据库字段
    String colunm = getFieldSet().get(property);
    if (null == colunm || "".equals(colunm.trim())) {
    throw new RuntimeException("property " + colunm + " not exits");
    }
    oredCriteria.addCriterion(colunm + " is null");
    this.queryUpdateMap.put("oredCriteria", oredCriteria);
    }

    /**
    * 属性不是空查询
    *
    * @param property
    */
    public void andIsNotNull(String property) {
    initCriteria();
    //数据库字段
    String colunm = getFieldSet().get(property);
    if (null == colunm || "".equals(colunm.trim())) {
    throw new RuntimeException("property " + colunm + " not exits");
    }
    oredCriteria.addCriterion(colunm + " is not null");
    this.queryUpdateMap.put("oredCriteria", oredCriteria);

    }

    /**
    * 属性=
    *
    * @param property
    * @param value
    */
    public void andLike(String property, Object value) {
    initCriteria();
    //数据库字段
    String colunm = getFieldSet().get(property);
    if (null == colunm || "".equals(colunm.trim())) {
    throw new RuntimeException("property " + colunm + " not exits");
    }
    oredCriteria.addCriterion(colunm + "like", value, colunm);
    this.queryUpdateMap.put("oredCriteria", oredCriteria);
    }


    /**
    * 属性=
    *
    * @param property
    * @param value
    */
    public void andEqualTo(String property, Object value) {
    initCriteria();
    //数据库字段
    String colunm = getFieldSet().get(property);
    if (null == colunm || "".equals(colunm.trim())) {
    throw new RuntimeException("property " + colunm + " not exits");
    }
    oredCriteria.addCriterion(colunm + " =", value, colunm);
    this.queryUpdateMap.put("oredCriteria", oredCriteria);
    }

    /**
    * 属性 !=
    *
    * @param property
    * @param value
    */
    public void andNotEqualTo(String property, Object value) {
    initCriteria();
    //数据库字段
    String colunm = getFieldSet().get(property);
    if (null == colunm || "".equals(colunm.trim())) {
    throw new RuntimeException("property " + colunm + " not exits");
    }
    oredCriteria.addCriterion(colunm + " <>", value, colunm);
    this.queryUpdateMap.put("oredCriteria", oredCriteria);
    }

    /**
    * 属性>
    *
    * @param property
    * @param value
    */
    public void andGreaterThan(String property, Object value) {
    initCriteria();
    //数据库字段
    String colunm = getFieldSet().get(property);
    if (null == colunm || "".equals(colunm.trim())) {
    throw new RuntimeException("property " + colunm + " not exits");
    }
    oredCriteria.addCriterion(colunm + " >", value, colunm);
    this.queryUpdateMap.put("oredCriteria", oredCriteria);
    }

    /**
    * 属性>=
    *
    * @param property
    * @param value
    */
    public void andGreaterThanOrEqualTo(String property, Object value) {
    initCriteria();
    //数据库字段
    String colunm = getFieldSet().get(property);
    if (null == colunm || "".equals(colunm.trim())) {
    throw new RuntimeException("property " + colunm + " not exits");
    }
    oredCriteria.addCriterion(colunm + " >=", value, colunm);
    this.queryUpdateMap.put("oredCriteria", oredCriteria);
    }

    /**
    * 属性<
    *
    * @param property
    * @param value
    */
    public void andLessThan(String property, Object value) {
    initCriteria();
    //数据库字段
    String colunm = getFieldSet().get(property);
    if (null == colunm || "".equals(colunm.trim())) {
    throw new RuntimeException("property " + colunm + " not exits");
    }
    oredCriteria.addCriterion(colunm + " <", value, colunm);
    this.queryUpdateMap.put("oredCriteria", oredCriteria);
    }

    /**
    * 属性<=
    *
    * @param property
    * @param value
    */
    public void andLessThanOrEqualTo(String property, Object value) {
    initCriteria();
    //数据库字段
    String colunm = getFieldSet().get(property);
    if (null == colunm || "".equals(colunm.trim())) {
    throw new RuntimeException("property " + colunm + " not exits");
    }
    oredCriteria.addCriterion(colunm + " <=", value, colunm);
    this.queryUpdateMap.put("oredCriteria", oredCriteria);
    }

    /**
    * in 查询
    *
    * @param property
    * @param values
    */
    public void andIn(String property, List values) {
    initCriteria();
    //数据库字段
    String colunm = getFieldSet().get(property);
    if (null == colunm || "".equals(colunm.trim())) {
    throw new RuntimeException("property " + colunm + " not exits");
    }
    oredCriteria.addCriterion(colunm + " in", values, colunm);
    this.queryUpdateMap.put("oredCriteria", oredCriteria);
    }

    /**
    * not in 查询
    *
    * @param property
    * @param values
    */
    public void andNotIn(String property, List values) {
    initCriteria();
    //数据库字段
    String colunm = getFieldSet().get(property);
    if (null == colunm || "".equals(colunm.trim())) {
    throw new RuntimeException("property " + colunm + " not exits");
    }
    oredCriteria.addCriterion(colunm + " not in", values, colunm);
    this.queryUpdateMap.put("oredCriteria", oredCriteria);
    }

    /**
    * between 查询
    *
    * @param property
    * @param value1
    * @param value2
    */
    public void andBetween(String property, Object value1, Object value2) {
    initCriteria();
    //数据库字段
    String colunm = getFieldSet().get(property);
    if (null == colunm || "".equals(colunm.trim())) {
    throw new RuntimeException("property " + colunm + " not exits");
    }

    oredCriteria.addCriterion(colunm + " between", value1, value2, colunm);
    this.queryUpdateMap.put("oredCriteria", oredCriteria);
    }

    /**
    * not between 查询
    *
    * @param property
    * @param value1
    * @param value2
    */
    public void andNotBetween(String property, Object value1, Object value2) {
    initCriteria();
    //数据库字段
    String colunm = getFieldSet().get(property);
    if (null == colunm || "".equals(colunm.trim())) {
    throw new RuntimeException("property " + colunm + " not exits");
    }
    oredCriteria.addCriterion(colunm + " not between", value1, value2, colunm);
    this.queryUpdateMap.put("oredCriteria", oredCriteria);
    }


    public static class Criteria {
    //设置复杂查询条件
    protected List<Criterion> criterion;

    protected Criteria() {
    super();
    criterion = new ArrayList<Criterion>();
    }

    public boolean isValid() {
    return criterion.size() > 0;
    }

    public List<Criterion> getAllCriterion() {
    return criterion;
    }

    public List<Criterion> getCriterion() {
    return criterion;
    }


    /**
    * 添加简单查询sql 只有条件 没有具体数值 例如 name is null
    *
    * @param condition
    */
    protected void addCriterion(String condition) {
    if (condition == null) {
    throw new RuntimeException("Value for condition cannot be null");
    }
    criterion.add(new Criterion(condition));
    }

    /**
    * 添加 有条件和条件数值sql
    *
    * @param condition
    * @param value
    * @param property
    */
    protected void addCriterion(String condition, Object value, String property) {
    if (value == null) {
    throw new RuntimeException("Value for " + property + " cannot be null");
    }
    criterion.add(new Criterion(condition, value));
    }

    /**
    * 添加有两个约束条件数值 age betweent 2 and 20
    *
    * @param condition
    * @param value1
    * @param value2
    * @param property
    */
    protected void addCriterion(String condition, Object value1, Object value2, String property) {
    if (value1 == null || value2 == null) {
    throw new RuntimeException("Between values for " + property + " cannot be null");
    }
    criterion.add(new Criterion(condition, value1, value2));
    }

    }


    /**
    * 复杂查询条件
    */

    public static class Criterion {
    /**
    * sql 条件
    */
    private String condition;
    /**
    * 条件数值
    */
    private Object value;
    /**
    * 条件第二个数值
    */
    private Object secondValue;

    /**
    * 无数值
    */
    private boolean noValue;
    /**
    * 单个数值
    */
    private boolean singleValue;
    /**
    * 二个数值,例如between 语句
    */
    private boolean betweenValue;
    /**
    * 数值是集合 例如 in 查询 list
    */
    private boolean listValue;

    public String getCondition() {
    return condition;
    }

    public void setCondition(String condition) {
    this.condition = condition;
    }

    public Object getValue() {
    return value;
    }

    public void setValue(Object value) {
    this.value = value;
    }

    public Object getSecondValue() {
    return secondValue;
    }

    public void setSecondValue(Object secondValue) {
    this.secondValue = secondValue;
    }

    public boolean isNoValue() {
    return noValue;
    }

    public void setNoValue(boolean noValue) {
    this.noValue = noValue;
    }

    public boolean isSingleValue() {
    return singleValue;
    }

    public void setSingleValue(boolean singleValue) {
    this.singleValue = singleValue;
    }

    public boolean isBetweenValue() {
    return betweenValue;
    }

    public void setBetweenValue(boolean betweenValue) {
    this.betweenValue = betweenValue;
    }

    public boolean isListValue() {
    return listValue;
    }

    public void setListValue(boolean listValue) {
    this.listValue = listValue;
    }

    /**
    * 单个条件
    *
    * @param condition
    */
    protected Criterion(String condition) {
    super();
    this.condition = condition;
    this.noValue = true;
    }

    /**
    * 一个条件一个数值
    *
    * @param condition
    * @param value
    */
    protected Criterion(String condition, Object value) {
    super();
    this.condition = condition;
    this.value = value;
    if (value instanceof List<?>) {
    this.listValue = true;
    } else {
    this.singleValue = true;
    }
    }

    /**
    * 一个条件两个数值(between 语句)
    *
    * @param condition
    * @param value
    * @param secondValue
    */
    protected Criterion(String condition, Object value, Object secondValue) {
    super();
    this.condition = condition;
    this.value = value;
    this.secondValue = secondValue;
    this.betweenValue = true;
    }


    }




    }

<#macro fieldLike type>
    <#if type?contains("bigint") || type?contains("decimal")>
    <#elseif type?contains("smallint")>
    <#elseif type?contains("bit(1)") || type?contains("tinyint(1)")>
    <#elseif type?contains("tinyint")>
    <#elseif type?contains("int") || type?contains("mediumint")>
    <#elseif type?contains("binary") || type?contains("blob") || type?contains("longblob")  || type?contains("tinyblob") || type?contains("varbinary") >
    <#elseif type?contains("char(1)") || type?contains("longtext") || type?contains("mediumtext") || type?contains("tinytext")|| type?contains("varchar")||type?contains("char")>
        <#nested>
    <#elseif type?contains("date") || type?contains("datetime")   || type?contains("time")  || type?contains("timestamp")  || type?contains("year")  >
    <#elseif type?contains("double")>
    <#elseif type?contains("float")>
    <#else>
        <#nested>
    </#if>
</#macro>



<#macro fieldType type>
    <#if type?contains("bigint")>
        long<#t/>
    <#elseif type?contains("decimal")>
        BigDecimal<#t/>
    <#elseif type?contains("smallint")>
        short<#t/>
    <#elseif type?contains("bit(1)") || type?contains("tinyint(1)")>
        boolean<#t/>
    <#elseif type?contains("tinyint")>
        byte<#t/>
    <#elseif type?contains("int") || type?contains("mediumint")>
        int<#t/>
    <#elseif type?contains("binary") || type?contains("blob") || type?contains("longblob")  || type?contains("tinyblob") || type?contains("varbinary") >
        byte[]<#t/>
    <#elseif type?contains("char(1)") || type?contains("longtext") || type?contains("mediumtext") || type?contains("tinytext")|| type?contains("varchar")||type?contains("char")>
        String<#t/>
    <#elseif type?contains("date") || type?contains("datetime")   || type?contains("time")  || type?contains("timestamp")  || type?contains("year")  >
        Date<#t/>
    <#elseif type?contains("double")>
        double<#t/>
    <#elseif type?contains("float")>
        float<#t/>
    <#else>
        String<#t/>
    </#if>
</#macro>