package ${serviceimpl_p};

import ${pagepacket}.PageBean;
import ${exceptionpacket}.ServiceException;
import ${entity_p}.${Entity};
import ${dao_p}.${Entity}Dao;
import ${query_p}.${Entity}Query;
import ${service_p}.${Entity}Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
/**
*
* @author ${author}
* @Date ${currentTime?datetime}
* version 1.0
*/

@Service
public class  ${Entity}ServiceImpl implements ${Entity}Service {



    @Autowired
    ${Entity}Dao ${entity}Dao;
    /**
    * 添加
    *
    * @throws SQLException
    */
    public boolean add${Entity}(${Entity} ${entity}) throws SQLException,ServiceException{
    try {
       return ${entity}Dao.add${Entity}(${entity})>0;
    } catch (SQLException e) {
       throw e;
    }catch (Exception e) {

    }
    return false;
    }

    /**
    * 批量添加
    *
    * @throws SQLException
    */
    public boolean add${Entity}s(List<${Entity}>  list) throws SQLException,ServiceException {
    try {
    return ${entity}Dao.add${Entity}s(list)>0;
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return false;
    }

    /**
    * 根据主键删除
    *
    * @return
    * @throws SQLException
    */
    public boolean deleteByKey(<@fieldType type=fields[0].fieldType/> id) throws SQLException,ServiceException{
    try {
    return ${entity}Dao.deleteByKey(id)>0;
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return false;
    }

    /**
    * 根据主键批量删除
    *
    * @return
    * @throws SQLException
    */
    public boolean deleteByKeys(List<<@ObjectfieldType type=fields[0].fieldType/>> idList) throws SQLException,ServiceException{
    try {
    return ${entity}Dao.deleteByKeys(idList)>0;
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return false;
    }

    /**
    * 根据条件删除
    * @param ${entity}Query
    * @return
    * @throws SQLException
    */
    public boolean deleteByQuery(${Entity}Query ${entity}Query) throws SQLException,ServiceException{
    try {
    return ${entity}Dao.deleteByQuery(${entity}Query)>0;
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return false;
    }


    /**
    * 根据条件删除
    * @param map
    * @return
    * @throws SQLException
    */
    public boolean deleteByMap(Map<String,Object>  map) throws SQLException,ServiceException{
    try {
    return ${entity}Dao.deleteByMap(map)>0;
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return false;
    }

    /**
    * 根据主键更新
    *
    * @return
    * @throws SQLException
    */
    public boolean update${Entity}ByKey(${Entity} ${entity}) throws SQLException,ServiceException{
    try {
    return ${entity}Dao.update${Entity}ByKey(${entity})>0;
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return false;
    }

    /**
    * 根据主键更新
    *
    * @return
    * @throws SQLException
    */
    public boolean update${Entity}ByMap(Map<String,Object>  map) throws SQLException,ServiceException{
    try {
    return ${entity}Dao. update${Entity}ByMap(map)>0;
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return false;
    }

    /**
    * 根据主键查找
    *
    * @throws SQLException
    */
    public ${Entity} get${Entity}ByKey(<@fieldType type=fields[0].fieldType/> id) throws SQLException,ServiceException{
    try {
    return ${entity}Dao.get${Entity}ByKey(id);
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return null;
    }

    /**
    * 根据主键批量查找
    *
    * @throws SQLException
    */
    public List<${Entity}> get${Entity}sByKeys(List<<@ObjectfieldType type=fields[0].fieldType/>> idList) throws SQLException,ServiceException{
    try {
    return ${entity}Dao.get${Entity}sByKeys(idList);
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return null;
    }

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    public List<${Entity}> get${Entity}List(Map<String,Object>  map) throws SQLException,ServiceException{
    try {
    return ${entity}Dao.get${Entity}List(map);
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return null;
    }

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    public PageBean<${Entity}> get${Entity}ListWithPage(Map<String,Object>  map)  throws SQLException,ServiceException{
    try {
    return ${entity}Dao.get${Entity}ListWithPage(map);
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return null;
    }

    /**
    * 总条数
    * @param map
    */
    public int get${Entity}ListCount(Map<String, Object> map) throws SQLException,ServiceException{
    try {

    return ${entity}Dao.get${Entity}ListCount(map);
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return 0;
    }



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