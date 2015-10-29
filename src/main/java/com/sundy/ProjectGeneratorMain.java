package com.sundy;

import com.sundy.dao.TableDao;
import com.sundy.dao.impl.TableDaoImpl;
import com.sundy.entity.Config;
import com.sundy.entity.Table;
import com.sundy.exception.ConfigException;
import com.sundy.utils.JdbcUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/8/16.
 */
public class ProjectGeneratorMain extends TestCase {

    //系统路径分隔符
    public static final String SPT = File.separator;
    //freemarker编码
    public static final String ENCODING = "UTF-8";

    //freemarker配置文件
    public static final String TEMPLATE_DIR = "com.sundy.flt";
    //实体模版文件
    public static final String ENTITY_FTL = "entity.ftl";
    //封装查询条件实体模版文件
    public static final String QUERY_FTL = "query.ftl";
    //mybatis dao 模版文件
    public static final String DAO_FTL = "dao.ftl";
    //mybatis daoimpl 模版文件
    public static final String DAOIMPL_FTL = "daoimpl.ftl";
    //mybatis xml 模版文件
    public static final String MAPPER_XML_FTL = "daoxml.ftl";
    //service 模版文件
    public static final String SERVICE_FTL = "service.ftl";
    //serviceimpl 模版文件
    public static final String SERVICE_IMPL_FTL = "serviceimpl.ftl";
    //page 模版文件
    public static final String PAGE_FTL = "page.ftl";
    //exception 模版文件
    public static final String EXCEPTION_FTL = "exception.ftl";
    //springmvc 控制器模版文件
    public static final String control_flt = "controler.ftl";


    private TableDao tableDao;
    private Config config;
    private Configuration cfg;

    private File f = null;
    private String tpl = null;
    private Map<String, Object> data = new HashMap<String, Object>();


    @Override
    protected void setUp() throws Exception {
        tableDao = new TableDaoImpl();
        config = JdbcUtil.config;
        //freemarker 配置对象
        cfg = new Configuration();
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


    @Test
    public void testgenerator() throws ConfigException, IOException, TemplateException {
        if (config != null) {
            if (config.getTablename() == null || "".equals(config.getTablename())) {
                throw new ConfigException("tableName is null");
            } else {
                //查询数据库表
                if (config.getTablename().equals("all")) {

                } else {
                    //查询单个数据库表
                    Table table = tableDao.findTable(config.getDb(), config.getTablename());
                    if (table == null) {
                        throw new ConfigException("can not find table " + config.getTablename());
                    }
                    String entity = replaceLine((formatTable(table.getName())));
                    //表
                    data.put("table", table.getName());
                    //表字段
                    data.put("fields", tableDao.listColumns(config.getDb(), table.getName()));
                    loadData(entity);
                    generatorAll();
                }
            }
        } else {
            throw new ConfigException("config is null");
        }

    }

    private void loadData(String entity) {
        String Entity = upperCaseFirst(entity);
        //freemarker默认模版文件路径
        data.put("template_dir", TEMPLATE_DIR);
        data.put("basepacket", config.getBasepacket());
        data.put("exceptionpacket", config.getBasepacket() + ".exception");
        data.put("pagepacket", config.getBasepacket() + ".page");
        //实体名称
        data.put("Entity", Entity);
        data.put("Query", Entity + "Query");
        data.put("Dao", Entity + "Dao");
        data.put("entity", entity);
        data.put("entity_p", config.getEntitypacket());
        data.put("query_p", config.getQuerypacket());
        data.put("dao_p", config.getDaopacket());
        data.put("daoimpl_p", config.getDaopacket() + ".impl");
        data.put("service_p", config.getServicepacket());
        data.put("serviceimpl_p", config.getServicepacket() + ".impl");
        data.put("action_p", config.getActionpacket());
        //作者
        data.put("author", config.getAuthor());
        //创建日期
        data.put("currentTime", new Date());
    }

    public void generatorAll() throws TemplateException, IOException {
        //entity
        f = new File(getFilePath((String) data.get("entity_p"), data.get("Entity") + ".java"));
        freemarkerGen(ENTITY_FTL, f);
        //query
        f = new File(getFilePath((String) data.get("query_p"), data.get("Query") + ".java"));
        freemarkerGen(QUERY_FTL, f);
        //dao
        f = new File(getFilePath((String) data.get("dao_p"), data.get("Dao") + ".java"));
        freemarkerGen(DAO_FTL, f);
        //daoimpl
        f = new File(getFilePath((String) data.get("daoimpl_p"), data.get("Dao") + "Impl" + ".java"));
        freemarkerGen(DAOIMPL_FTL, f);
        //dao.xml
        f = new File(getFilePath((String) data.get("entity_p"), data.get("Entity") + "Dao" + ".xml"));
        freemarkerGen(MAPPER_XML_FTL, f);
        //service
        f = new File(getFilePath((String) data.get("service_p"), data.get("Entity") + "Service" + ".java"));
        freemarkerGen(SERVICE_FTL, f);
        //serviceimpl
        f = new File(getFilePath((String) data.get("serviceimpl_p"), data.get("Entity") + "ServiceImpl" + ".java"));
        freemarkerGen(SERVICE_IMPL_FTL, f);
        //page
        f = new File(getFilePath((String) data.get("pagepacket"), "PageBean" + ".java"));
        freemarkerGen(PAGE_FTL, f);
        //exception
        f = new File(getFilePath((String) data.get("exceptionpacket"), "ServiceException" + ".java"));
        freemarkerGen(EXCEPTION_FTL, f);


    }


    /**
     * freemarker 模版生成
     *
     * @param tpl
     * @param f
     * @throws TemplateException
     * @throws IOException
     */
    public void freemarkerGen(String tpl, File f) throws TemplateException, IOException {
        File parent = f.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        if (!f.exists()) {
            f.createNewFile();
        }

        Writer out = null;
        try {
            // FileWriter不能指定编码确实是个问题，只能用这个代替了。
            out = new OutputStreamWriter(new FileOutputStream(f), ENCODING);
            //导入模版目录
            File temp = new File(getFilePath((String) data.get("template_dir"), ""));
            cfg.setDirectoryForTemplateLoading(temp);
            Template template = cfg.getTemplate(tpl);
            template.process(data, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }

    }

    /**
     * 项目classpath相对路径
     *
     * @param packageName
     * @param name
     * @return
     */
    private String getFilePath(String packageName, String name) {
        String path = converString(packageName);
        return "src/main/java/" + path + "/" + name;
    }

    /**
     * \\.  换 /
     *
     * @param s
     * @return
     */
    private String converString(String s) {
        return s.replaceAll("\\.", "/");
    }

    /**
     * 头字母大写
     *
     * @param s
     * @return
     */
    private String upperCaseFirst(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    /**
     * 头字母小写
     *
     * @param s
     * @return
     */
    private String lowCaseFirst(String s) {
        return s.substring(0, 1).toLowerCase() + s.substring(1);
    }

    /**
     * 去掉下划线
     *
     * @param s
     * @return
     */
    private String replaceLine(String s) {
        return s.replaceAll("_", "");
    }

    /**
     * 去掉表头
     *
     * @return
     */
    private String formatTable(String tableName) {
        String[] splits = tableName.split("_");
        StringBuffer sb = new StringBuffer();
        if (splits != null && splits.length > 0) {
            for (int i = 0; i < splits.length; i++) {
                if (i == 0) {
                    sb.append(lowCaseFirst(splits[i]));
                } else {
                    sb.append(upperCaseFirst(splits[i]));
                }
            }
        }
        return sb.toString();
    }


}
