package com.sundy.dao;

import com.sundy.entity.Column;
import com.sundy.entity.Table;

import java.util.List;

/**
 * Created by Administrator on 2015/8/16.
 */
public interface TableDao {

    Table findTable(String db, String tablename);

    public List<Table> listTables(String db);

    List<Column> listColumns(String db, String tablename);

}
