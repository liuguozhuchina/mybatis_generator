package com.sundy.dao.impl;

import com.sundy.dao.TableDao;
import com.sundy.entity.Column;
import com.sundy.entity.Table;
import com.sundy.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/8/16.
 */
public class TableDaoImpl implements TableDao {
    @Override
    public Table findTable(String db, String tablename) {
        String sql = "select table_name,table_comment,engine,table_rows,auto_increment from information_schema.tables where table_schema=? and table_name=?";
        List<Table> tables = new ArrayList<Table>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, db);
            ps.setString(2, tablename);
            rs = ps.executeQuery();
            while (rs.next()) {
                Table table = new Table();
                table.setName(rs.getString(1));
                table.setComment(rs.getString(2).split(";")[0]);
                table.setEngine(rs.getString(3));
                table.setRows(rs.getInt(4));
                table.setAutoIncrement(rs.getInt(5));
                tables.add(table);
            }
            if (tables.size() > 1) {
                throw new RuntimeException("find more than one table " + tablename);
            } else if (tables.size() == 0) {
                throw new RuntimeException("can not find table " + tablename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.release(connection, ps, rs);
        }
        if (tables.size() > 0) {
            return tables.get(0);
        } else {
            return null;
        }

    }

    @Override
    public List<Table> listTables(String db) {
        String sql = "select table_name,table_comment,engine,table_rows,auto_increment from information_schema.tables where table_schema=?";
        List<Table> tables = new ArrayList<Table>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, db);
            rs = ps.executeQuery();
            while (rs.next()) {
                Table table = new Table();
                table.setName(rs.getString(1));
                table.setComment(rs.getString(2).split(";")[0]);
                table.setEngine(rs.getString(3));
                table.setRows(rs.getInt(4));
                table.setAutoIncrement(rs.getInt(5));
                tables.add(table);
            }
        } catch (Exception e) {

        } finally {
            JdbcUtil.release(connection, ps, rs);
        }
        return tables;
    }

    @Override
    public List<Column> listColumns(String db, String tablename) {
        String sql = "select column_name,column_type,column_default,column_key,column_comment,is_nullable,extra from information_schema.columns where table_schema=?  and table_name=?";
        List<Column> columnList = new ArrayList<Column>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, db);
            ps.setString(2, tablename);
            rs = ps.executeQuery();
            while (rs.next()) {
                Column column = new Column();
                column.setName(rs.getString(1));
                column.setFieldType(rs.getString(2));
                column.setFieldDefault(rs.getString(3));
                column.setFieldProperty(rs.getString(4));
                column.setComment(rs.getString(5));
                column.setNullable(rs.getString(6));
                column.setExtra(rs.getString(7));
                columnList.add(column);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.release(connection, ps, rs);
        }
        for (Column column : columnList) {
            //System.out.println(column.getName() + ":" + column.getFieldType());
        }
        return columnList;
    }


}
