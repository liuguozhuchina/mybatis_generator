package ${entity_p};

import java.math.BigDecimal;
import java.util.*;
import java.io.Serializable;


/**
*
* @author ${author}
* @Date ${currentTime?datetime}
* version 1.0
*/
public class ${Entity} implements Serializable {
/**
* 序列化ID
*/
private static final long serialVersionUID = 1L;

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

    public void set<#list field.name?split('_') as n>${n?cap_first}</#list>(<@fieldType type=field.fieldType/> <#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>) {
    this.<#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list> = <#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>;
    }

    </#list>
    public String toString() {
    return "${Entity} [<#list fields as field><#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list>=" + <#list field.name?split('_') as n><#if n_index ==0>${n}<#else>${n?cap_first}</#if></#list> + "<#if field_has_next>,</#if></#list>]";
    }
    }
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