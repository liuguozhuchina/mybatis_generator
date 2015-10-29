package com.sundy.utils;

import com.sundy.entity.Config;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Administrator on 2015/8/16.
 * 数据库连接对象
 */
public class JdbcUtil {
    public static Config config;

    static {
        try {
            Properties properties = new Properties();
            properties.load(JdbcUtil.class.getClassLoader().getResourceAsStream("config.properties"));
            config = new Config();
            /**生存实体对象、mapper、接口、service、作者等配置文件**/
            config.setBasepacket(properties.getProperty("basepacket"));
            config.setEntitypacket(properties.getProperty("entitypacket"));
            config.setQuerypacket(properties.getProperty("querypacket"));
            config.setDaopacket(properties.getProperty("daopacket"));
            config.setServicepacket(properties.getProperty("servicepacket"));
            config.setActionpacket(properties.getProperty("actionpacket"));
            config.setTablename(properties.getProperty("tablename"));
            config.setAuthor(properties.getProperty("author"));

            /**数据库配置文件**/
            config.setDb(properties.getProperty("db"));
            config.setDriverClass(properties.getProperty("driverClass"));
            config.setUrl(properties.getProperty("jdbcUrl"));
            config.setUrl(config.getUrl() + config.getDb());
            config.setUsername(properties.getProperty("username"));
            config.setPassword(properties.getProperty("password"));
            Class.forName(config.getDriverClass());

        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
    }


    public static void release(Connection conn, Statement st, ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();   //throw new
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (st != null) {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            st = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

}
