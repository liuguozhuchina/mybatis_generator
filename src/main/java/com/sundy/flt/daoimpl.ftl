package ${daoimpl_p};

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.apache.ibatis.session.SqlSessionFactory;
import ${pagepacket}.PageBean;
import  ${dao_p}.${Entity}Dao;
import ${entity_p}.${Entity};
import ${query_p}.${Entity}Query;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
/**
*
* @author ${author}
* @Date ${currentTime?datetime}
* version 1.0
*/
@Repository
public class  ${Entity}DaoImpl extends SqlSessionDaoSupport implements ${Entity}Dao  {

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    super.setSqlSessionFactory(sqlSessionFactory);
    }
    /**
    * 添加
    *
    * @throws SQLException
    */
    public int  add${Entity}(${Entity} ${entity}) throws SQLException {
    try {
      return this.getSqlSession().insert("${entity_p}.${Entity}Dao.add${Entity}", ${entity});
    } catch (Exception e) {
    throw new SQLException("${entity_p}.${Entity}Dao.add${Entity}", e);
    }
    }

    /**
    * 批量添加
    *
    * @throws SQLException
    */
    public int add${Entity}s(List<${Entity}>  list) throws SQLException {
    try {
    return this.getSqlSession().insert("${entity_p}.${Entity}Dao.add${Entity}s", list);
    }catch (Exception e) {
     throw new SQLException("${entity_p}.${Entity}Dao.add${Entity}s", e);
    }
    }

    /**
    * 根据主键删除
    *
    * @return
    * @throws SQLException
    */
    public int deleteByKey(<@fieldType type=fields[0].fieldType/> id) throws SQLException{
    try{
    return this.getSqlSession().delete("${entity_p}.${Entity}Dao.deleteByKey", id);
    }catch (Exception e) {
     throw new SQLException("${entity_p}.${Entity}Dao.deleteByKey", e);
    }
    }

    /**
    * 根据主键批量删除
    *
    * @return
    * @throws SQLException
    */
    public int deleteByKeys(List<<@ObjectfieldType type=fields[0].fieldType/>> keys) throws SQLException{
    try{
    return this.getSqlSession().delete("${entity_p}.${Entity}Dao.deleteByKeys", keys);
     }catch (Exception e) {
     throw new SQLException("${entity_p}.${Entity}Dao.deleteByKeys", e);
     }
    }

    /**
    *根据条件删除
    * @param ${entity}Query
    * @return
    * @throws SQLException
    */
    public int deleteByQuery(${Entity}Query ${entity}Query) throws SQLException{
    try{
    return this.getSqlSession().delete("${entity_p}.${Entity}Dao.deleteByQuery", ${entity}Query);
    }catch (Exception e) {
     throw new SQLException("${entity_p}.${Entity}Dao.deleteByQuery", e);
     }
    }


    /**
    * 根据条件删除
    * @param map
    * @return
    * @throws SQLException
    */
    public int deleteByMap(Map<String,Object>  map) throws SQLException{
    try{
    return this.getSqlSession().delete("${entity_p}.${Entity}Dao.deleteByMap", map);
    }catch (Exception e) {
    throw new SQLException("${entity_p}.${Entity}Dao.deleteByMap", e);
    }
    }
    /**
    * 根据主键更新
    *
    * @return
    * @throws SQLException
    */
    public int update${Entity}ByKey(${Entity} ${entity}) throws SQLException{
    try{
    return this.getSqlSession().update("${entity_p}.${Entity}Dao.update${Entity}ByKey", ${entity});
     }catch (Exception e) {
     throw new SQLException("${entity_p}.${Entity}Dao.update${Entity}ByKey", e);
     }
    }

    /**
    * 根据map更新
    *
    * @return
    * @throws SQLException
    */
    public int update${Entity}ByMap(Map<String,Object>  map) throws SQLException{
    try{
    return this.getSqlSession().update("${entity_p}.${Entity}Dao.update${Entity}ByMap", map);
    }catch (Exception e) {
     throw new SQLException("${entity_p}.${Entity}Dao.update${Entity}ByMap", e);
    }
    }

    /**
    * 根据主键查找
    *
    * @throws SQLException
    */
    public ${Entity} get${Entity}ByKey(<@fieldType type=fields[0].fieldType/> id) throws SQLException {
     try{
    return (${Entity})this.getSqlSession().selectOne("${entity_p}.${Entity}Dao.get${Entity}ByKey",id);
    }catch (Exception e) {
     throw new SQLException("${entity_p}.${Entity}Dao.get${Entity}ByKey", e);
    }
    }

    /**
    * 根据主键批量查找
    *
    * @throws SQLException
    */
    public List<${Entity}> get${Entity}sByKeys(List<<@ObjectfieldType type=fields[0].fieldType/>> idList) throws SQLException{
    try{
    return this.getSqlSession().selectList("${entity_p}.${Entity}Dao.get${Entity}sByKeys",idList);
    }catch (Exception e) {
     throw new SQLException("${entity_p}.${Entity}Dao.get${Entity}ByKeys", e);
    }
    }

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    public List<${Entity}> get${Entity}List(Map<String,Object>  map) throws SQLException{
    try{
    return this.getSqlSession().selectList("${entity_p}.${Entity}Dao.get${Entity}List",map);
    }catch (Exception e) {
     throw new SQLException("${entity_p}.${Entity}Dao.get${Entity}List", e);
    }
    }

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    public PageBean<${Entity}> get${Entity}ListWithPage(Map<String,Object>  map)  throws SQLException{
     try{
        //总记录数
        int count = get${Entity}ListCount(map);
        //查询数据
        List<${Entity}> list = this.getSqlSession().selectList("${entity_p}.${Entity}Dao.get${Entity}ListWithPage",map);
        int currentPage = (Integer) map.get("startRow");
        int pageSize = (Integer) map.get("pageSize");
        PageBean<${Entity}> pageBean = new PageBean<${Entity}>(currentPage, pageSize, count, list);
        return pageBean;
     }catch (Exception e) {
      throw new SQLException("${entity_p}.${Entity}Dao.get${Entity}ListWithPag", e);
     }
    }

    /**
    * 总条数
    * @param map
    */
    public int get${Entity}ListCount(Map<String,Object>  map) throws SQLException{
    try{
    return (Integer)this.getSqlSession().selectOne("${entity_p}.${Entity}Dao.get${Entity}ListCount",map);
    }catch (Exception e) {
     throw new SQLException("${entity_p}.${Entity}Dao.get${Entity}ListCount", e);
    }
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
    <#elseif type?contains("char(1)") || type?contains("longtext") || type?contains("mediumtext") || type?contains("tinytext")|| type?contains("varchar")>
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
    <#elseif type?contains("char(1)") || type?contains("longtext") || type?contains("mediumtext") || type?contains("tinytext")|| type?contains("varchar")>
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
