package com.huayu.dao.personal;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.huayu.page.PageBean;
import com.huayu.entity.personal.User;
import com.huayu.query.personal.UserQuery;

/**
*
* @author fly
* @Date 2015-10-27 0:48:00
* version 1.0
*/
public interface  UserDao {
    /**
    * 添加
    *
    * @throws SQLException
    */
    int addUser(User user) throws SQLException ;

    /**
    * 批量添加
    *
    * @throws SQLException
    */
    int addUsers(List<User>  list) throws SQLException ;

    /**
    * 根据主键删除
    *
    * @return
    * @throws SQLException
    */
    int deleteByKey(long id) throws SQLException;

    /**
    * 根据主键批量删除
    *
    * @return
    * @throws SQLException
    */
    int deleteByKeys(List<Long> idList) throws SQLException;

    /**
    * 根据条件删除
    * @param userQuery
    * @return
    * @throws SQLException
    */
    int deleteByQuery(UserQuery userQuery) throws SQLException;

    /**
    * 根据条件删除
    * @param map
    * @return
    * @throws SQLException
    */
    int deleteByMap(Map<String,Object>  map) throws SQLException;


    /**
    * 根据主键更新
    *
    * @return
    * @throws SQLException
    */
    int updateUserByKey(User user) throws SQLException;

    /**
    * 根据主键更新
    *
    * @return
    * @throws SQLException
    */
    int updateUserByMap(Map<String,Object>  map) throws SQLException;

    /**
    * 根据主键查找
    *
    * @throws SQLException
    */
    User getUserByKey(long id) throws SQLException ;

    /**
    * 根据主键批量查找
    *
    * @throws SQLException
    */
    List<User> getUsersByKeys(List<Long> idList) throws SQLException;

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    List<User> getUserList(Map<String,Object>  map) throws SQLException ;

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    PageBean<User> getUserListWithPage(Map<String,Object>  map)  throws SQLException ;

    /**
    * 总条数
    * @param map
    */
    int getUserListCount(Map<String,Object>  map) throws SQLException ;



}

