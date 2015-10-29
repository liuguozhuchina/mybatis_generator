package com.huayu.service.personal;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.huayu.page.PageBean;
import com.huayu.exception.ServiceException;

import com.huayu.entity.personal.User;
import com.huayu.query.personal.UserQuery;

/**
*
* @author fly
* @Date 2015-10-27 0:48:00
* version 1.0
*/
public interface  UserService {
/**
* 添加
*
* @throws SQLException
*/
boolean addUser(User user) throws SQLException,ServiceException;

/**
* 批量添加
*
* @throws SQLException
*/
boolean addUsers(List<User>  list) throws SQLException,ServiceException ;

/**
* 根据主键删除
*
* @return
* @throws SQLException
*/
boolean deleteByKey(long id) throws SQLException,ServiceException;

/**
* 根据主键批量删除
*
* @return
* @throws SQLException
*/
boolean deleteByKeys(List<Long> idList) throws SQLException,ServiceException;

/**
* 根据条件删除
* @param userQuery
* @return
* @throws SQLException
*/
boolean deleteByQuery(UserQuery userQuery) throws SQLException,ServiceException;

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
boolean updateUserByKey(User user) throws SQLException,ServiceException;

/**
* 根据主键更新
*
* @return
* @throws SQLException
*/
boolean updateUserByMap(Map<String,Object>  map) throws SQLException,ServiceException;

/**
* 根据主键查找
*
* @throws SQLException
*/
User getUserByKey(long id) throws SQLException,ServiceException ;

/**
* 根据主键批量查找
*
* @throws SQLException
*/
List<User> getUsersByKeys(List<Long> idList) throws SQLException,ServiceException;

/**
* 根据条件查找
*
* @throws SQLException
*/
List<User> getUserList(Map<String,Object>  map) throws SQLException,ServiceException;

/**
* 根据条件查找
*
* @throws SQLException
*/
PageBean<User> getUserListWithPage(Map<String, Object> map)  throws SQLException,ServiceException;

/**
* 总条数
* @param map
*/
int getUserListCount(Map<String,Object>  map) throws SQLException,ServiceException;



}

