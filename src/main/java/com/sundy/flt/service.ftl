package ${service_p};

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import ${pagepacket}.PageBean;
import ${exceptionpacket}.ServiceException;

import ${entity_p}.${Entity};
import ${query_p}.${Entity}Query;

/**
*
* @author ${author}
* @Date ${currentTime?datetime}
* version 1.0
*/
public interface  ${Entity}Service {
/**
* 添加
*
* @throws SQLException
*/
boolean add${Entity}(${Entity} ${entity}) throws SQLException,ServiceException;

/**
* 批量添加
*
* @throws SQLException
*/
boolean add${Entity}s(List<${Entity}>  list) throws SQLException,ServiceException ;

/**
* 根据主键删除
*
* @return
* @throws SQLException
*/
boolean deleteByKey(<@fieldType type=fields[0].fieldType/> id) throws SQLException,ServiceException;

/**
* 根据主键批量删除
*
* @return
* @throws SQLException
*/
boolean deleteByKeys(List<<@ObjectfieldType type=fields[0].fieldType/>> idList) throws SQLException,ServiceException;

/**
* 根据条件删除
* @param ${entity}Query
* @return
* @throws SQLException
*/
boolean deleteByQuery(${Entity}Query ${entity}Query) throws SQLException,ServiceException;

/**
* 根据条件删除
* @param map
* @return
* @throws SQLException
*/
boolean deleteByMap(Map<String,Object>  map) throws SQLException,ServiceException;

/**
* 根据主键更新
*
* @return
* @throws SQLException
*/
boolean update${Entity}ByKey(${Entity} ${entity}) throws SQLException,ServiceException;

/**
* 根据主键更新
*
* @return
* @throws SQLException
*/
boolean update${Entity}ByMap(Map<String,Object>  map) throws SQLException,ServiceException;

/**
* 根据主键查找
*
* @throws SQLException
*/
${Entity} get${Entity}ByKey(<@fieldType type=fields[0].fieldType/> id) throws SQLException,ServiceException ;

/**
* 根据主键批量查找
*
* @throws SQLException
*/
List<${Entity}> get${Entity}sByKeys(List<<@ObjectfieldType type=fields[0].fieldType/>> idList) throws SQLException,ServiceException;

/**
* 根据条件查找
*
* @throws SQLException
*/
List<${Entity}> get${Entity}List(Map<String,Object>  map) throws SQLException,ServiceException;

/**
* 根据条件查找
*
* @throws SQLException
*/
PageBean<${Entity}> get${Entity}ListWithPage(Map<String, Object> map)  throws SQLException,ServiceException;

/**
* 总条数
* @param map
*/
int get${Entity}ListCount(Map<String,Object>  map) throws SQLException,ServiceException;



}

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

<#macro ObjectfieldType type>
    <#if type?contains("bigint") || type?contains("decimal")>
    Long<#t/>
    <#elseif type?contains("smallint")>
    Short<#t/>
    <#elseif type?contains("bit(1)") || type?contains("tinyint(1)")>
    Boolean<#t/>
    <#elseif type?contains("tinyint")>
    Byte<#t/>
    <#elseif type?contains("int") || type?contains("mediumint")>
    Integer<#t/>
    <#elseif type?contains("binary") || type?contains("blob") || type?contains("longblob")  || type?contains("tinyblob") || type?contains("varbinary") >
    Byte[]<#t/>
    <#elseif type?contains("char(1)") || type?contains("longtext") || type?contains("mediumtext") || type?contains("tinytext")|| type?contains("varchar")||type?contains("char")>
    String<#t/>
    <#elseif type?contains("date") || type?contains("datetime")   || type?contains("time")  || type?contains("timestamp")  || type?contains("year")  >
    Date<#t/>
    <#elseif type?contains("double")>
    Double<#t/>
    <#elseif type?contains("float")>
    Float<#t/>
    <#else>
    String<#t/>
    </#if>
</#macro>