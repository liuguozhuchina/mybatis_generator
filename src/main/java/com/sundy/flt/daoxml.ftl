<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${entity_p}.${Entity}Dao">
    <resultMap id="${entity}" type="${entity_p}.${Entity}">
    <#list fields as field>
        <#if field_index == 0>
        <id column="${field.name}" property="<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>"/>
        <#else>
        <result column="${field.name}" property="<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>"/>
        </#if>
    </#list>
    </resultMap>

    <!-- Select SQL -->
    <sql id="selector">
        SELECT
        <if test="fields != null and fields!='' ">
        ${r'${fields}'}
        </if>
        <if test="fields == null or fields=='' ">
        <#list fields as field><#if field_has_next>${field.name},<#else>${field.name}</#if></#list>
        </if>
        FROM ${table}
    </sql>


    <!-- Where SQL -->
    <sql id="Listwhere">
        <where>
        <#list fields as field>
            <if test="<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>!= null<@fieldLike type=field.fieldType> and <#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>!=''</@fieldLike> ">
                AND ${field.name}= ${r'#'}{<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>}
            </if>
        </#list>
        <if test="oredCriteria!=null">
                <foreach collection="oredCriteria.criterion" item="criterion">
                    <choose>
                        <when test="criterion.noValue">
                            and  ${r'${criterion.condition}'}
                        </when>
                        <when test="criterion.singleValue">
                            and  ${r'${criterion.condition}'}  ${r'#{criterion.value}'}
                        </when>
                        <when test="criterion.betweenValue">
                            and ${r'${criterion.condition}'}  ${r'#{criterion.value}'} and  ${r'#{criterion.secondValue}'}
                        </when>
                        <when test="criterion.listValue">
                            and ${r'${criterion.condition}'}
                            <foreach collection="criterion.value" item="listItem" open="(" close=")" separator=",">
                            ${r'#{listItem}'}
                            </foreach>
                        </when>
                    </choose>
                </foreach>
        </if>

        </where>
    </sql>

    <!-- Order SQL -->
    <sql id="Listorder">
        <if test="orderFields != null and orderFields.size >0">
            order by
            <foreach collection="orderFields" separator="," item="orderField">
            ${r'${orderField.fieldName} ${orderField.order}'}
            </foreach>
        </if>
    </sql>

    <!-- Page limit SQL -->
    <sql id="ListLimit">
        <if test="startRow >=0">
        ${r' limit #{startRow},#{pageSize}'}
        </if>
    </sql>

    <!-- 添加 -->
    <insert id="add${Entity}" parameterType="${entity_p}.${Entity}">
        INSERT INTO  ${table}
        <trim prefix="(" suffix=")" suffixOverrides=",">
        <#list fields as field>
            <if test="<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>!= null<@fieldLike type=field.fieldType> and <#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>!=''</@fieldLike> ">
             ${field.name},
            </if>
        </#list>
        </trim>
        <trim prefix="VALUES (" suffix=")" suffixOverrides=",">
        <#list fields as field>
            <if test="<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>!= null<@fieldLike type=field.fieldType> and <#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>!=''</@fieldLike> ">
              ${r'#'}{<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>},
            </if>
        </#list>
        </trim>
    </insert>

    <!-- 批量添加 -->
    <insert id="add${Entity}s" parameterType="java.util.List">
        INSERT INTO  ${table}(<#list fields as field><#if !field_has_next>${field.name}<#else>${field.name},</#if></#list>)
        VALUES
        <foreach collection="list" item="item" index="index" separator=",">
            (<#list fields as field>${r'#'}{<#list field.name?split('_') as n><#if n_index ==0>item.${n}<#else>${n?cap_first}</#if></#list>}<#if !field_has_next><#else>,</#if></#list>)
        </foreach>
    </insert>

    <!-- 根据主键删除 -->
    <delete id="deleteByKey" parameterType="long">
        DELETE FROM  ${table}
        WHERE  <#list fields as field><#if field_index == 0> ${field.name}=${r'#'}{id}</#if></#list>
    </delete>

    <!-- 根据主键批量删除 -->
    <delete id="deleteByKeys">
        DELETE FROM  ${table}
        WHERE  <#list fields as field><#if field_index == 0>  ${field.name}</#if></#list> in
        <foreach collection="list" separator="," item="id" open="(" close=")">
        ${r'#'}{id}
        </foreach>
    </delete>

    <!-- 根据条件删除 -->
    <delete id="deleteByQuery" parameterType="${entity_p}.${Entity}">
        DELETE FROM  ${table}
        <include refid="Listwhere" />
    </delete>

    <!-- 根据条件删除 -->
    <delete id="deleteByMap" parameterType="map">
        DELETE FROM  ${table}
        <include refid="Listwhere" />
    </delete>

       <!-- 根据主键更新 -->
    <update id="update${Entity}ByKey" parameterType="${entity_p}.${Entity}">
        UPDATE ${table}
        <set>
            <trim suffixOverrides=",">
            <#list fields as field>
                <if test="<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>!= null<@fieldLike type=field.fieldType> and <#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>!=''</@fieldLike> ">
                ${field.name}= ${r'#'}{<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>},
                </if>
            </#list>
            </trim>
        </set>
        WHERE  ${fields[0].name}= ${r'#'}{${fields[0].name}}
    </update>

    <!-- 根据map更新 -->
    <update id="update${Entity}ByMap" parameterType="map">
        UPDATE ${table}
        <set>
            <trim suffixOverrides=",">
            <#list fields as field>
                <if test="<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>!= null<@fieldLike type=field.fieldType> and <#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>!=''</@fieldLike>" >
                ${field.name}= ${r'#'}{<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>},
                </if>
            </#list>
            </trim>
        </set>
        WHERE  ${fields[0].name}= ${r'#'}{${fields[0].name}}
    </update>

    <!-- 根据主键查询 -->
    <select id="get${Entity}ByKey" resultMap="${entity}" parameterType="${entity_p}.${Entity}">
        SELECT <#list fields as field><#if field_has_next>${field.name},<#else>${field.name}</#if></#list> FROM ${table}
        WHERE  ${fields[0].name}= ${r'#'}{${fields[0].name}}
    </select>

    <!-- 根据主键批量查询 -->
    <select id="get${Entity}sByKeys" resultMap="${entity}" parameterType="map">
        SELECT <#list fields as field><#if field_has_next>${field.name},<#else>${field.name}</#if></#list> FROM ${table}
        WHERE
    ${fields[0].name} in
        <foreach collection="list" separator="," item="id" open="(" close=")">
        ${r'#'}{id}
        </foreach>
    </select>

    <!-- 分页 -->
    <select id="get${Entity}ListWithPage" parameterType="map" resultMap="${entity}">
        <include refid="selector" />
        <include refid="Listwhere" />
        <include refid="Listorder" />
        <include refid="ListLimit" />
    </select>

    <!-- 数据集合 -->
    <select id="get${Entity}List" parameterType="map" resultMap="${entity}">
        <include refid="selector" />
        <include refid="Listwhere" />
        <include refid="Listorder" />
    </select>

    <!-- 数据总数 -->
    <select id="get${Entity}ListCount" parameterType="map" resultType="int">
        SELECT count(1) FROM ${table}
        <include refid="Listwhere" />
    </select>


</mapper>



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


<#macro jdbcType type>
    <#if type?contains("bigint")>
    BIGINT<#t/>
    <#elseif type?contains("varbinary") >
    VARBINARY<#t/>
    <#elseif type?contains("binary")||type?contains("tinyblob")>
    BINARY<#t/>
    <#elseif type?contains("bit(1)")||type?contains("tinyint(1)")>
    BIT<#t/>
    <#elseif type?contains("char(1)")>
    CHAR<#t/>
    <#elseif type?contains("datetime")||type?contains("timestamp")>
    TIMESTAMP<#t/>
    <#elseif type?contains("date")||type?contains("year(4)")>
    DATE<#t/>
    <#elseif type?contains("decimal")>
    DECIMAL<#t/>
    <#elseif type?contains("double")>
    DOUBLE<#t/>
    <#elseif type?contains("float")>
    REAL<#t/>
    <#elseif type?contains("smallint")>
    SMALLINT<#t/>
    <#elseif type?contains("int") ||type?contains("mediumint")>
    INTEGER<#t/>
    <#elseif type?contains("time")>
    TIME<#t/>
    <#elseif type?contains("tinyint(4)")>
    TINYINT<#t/>
    <#elseif type?contains("tinytext") || type?contains("varchar")>
    VARCHAR<#t/>
    <#elseif type?contains("blob") || type?contains("longblob")||type?contains("mediumblob")>
    LONGVARBINARY<#t/>
    <#elseif type?contains("longtext") || type?contains("mediumtext") || type?contains("text") >
    LONGVARCHAR<#t/>
    <#elseif type?contains("tinyblob") >
    BINARY<#t/>
    <#else>
    String<#t/>
    </#if>
</#macro>

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
