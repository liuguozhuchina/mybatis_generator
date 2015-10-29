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
        private static Map<String, String> fieldMap;

        private static Map<String, String> getFieldSet() {
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
    <#if type?contains("bigint") || type?contains("decimal")>
        long<#t/>
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