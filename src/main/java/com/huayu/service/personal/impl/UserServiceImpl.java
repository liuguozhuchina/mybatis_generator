package com.huayu.service.personal.impl;

import com.huayu.page.PageBean;
import com.huayu.exception.ServiceException;
import com.huayu.entity.personal.User;
import com.huayu.dao.personal.UserDao;
import com.huayu.query.personal.UserQuery;
import com.huayu.service.personal.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
/**
*
* @author fly
* @Date 2015-10-27 0:48:00
* version 1.0
*/

@Service
public class  UserServiceImpl implements UserService {



    @Autowired
    UserDao userDao;
    /**
    * 添加
    *
    * @throws SQLException
    */
    public boolean addUser(User user) throws SQLException,ServiceException{
    try {
       return userDao.addUser(user)>0;
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
    public boolean addUsers(List<User>  list) throws SQLException,ServiceException {
    try {
    return userDao.addUsers(list)>0;
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
    public boolean deleteByKey(long id) throws SQLException,ServiceException{
    try {
    return userDao.deleteByKey(id)>0;
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
    public boolean deleteByKeys(List<Long> idList) throws SQLException,ServiceException{
    try {
    return userDao.deleteByKeys(idList)>0;
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return false;
    }

    /**
    * 根据条件删除
    * @param userQuery
    * @return
    * @throws SQLException
    */
    public boolean deleteByQuery(UserQuery userQuery) throws SQLException,ServiceException{
    try {
    return userDao.deleteByQuery(userQuery)>0;
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
    return userDao.deleteByMap(map)>0;
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
    public boolean updateUserByKey(User user) throws SQLException,ServiceException{
    try {
    return userDao.updateUserByKey(user)>0;
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
    public boolean updateUserByMap(Map<String,Object>  map) throws SQLException,ServiceException{
    try {
    return userDao. updateUserByMap(map)>0;
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
    public User getUserByKey(long id) throws SQLException,ServiceException{
    try {
    return userDao.getUserByKey(id);
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
    public List<User> getUsersByKeys(List<Long> idList) throws SQLException,ServiceException{
    try {
    return userDao.getUsersByKeys(idList);
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
    public List<User> getUserList(Map<String,Object>  map) throws SQLException,ServiceException{
    try {
    return userDao.getUserList(map);
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
    public PageBean<User> getUserListWithPage(Map<String,Object>  map)  throws SQLException,ServiceException{
    try {
    return userDao.getUserListWithPage(map);
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
    public int getUserListCount(Map<String, Object> map) throws SQLException,ServiceException{
    try {

    return userDao.getUserListCount(map);
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return 0;
    }



}

