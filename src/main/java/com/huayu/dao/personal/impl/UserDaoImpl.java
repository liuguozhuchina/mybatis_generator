package com.huayu.dao.personal.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.apache.ibatis.session.SqlSessionFactory;
import com.huayu.page.PageBean;
import  com.huayu.dao.personal.UserDao;
import com.huayu.entity.personal.User;
import com.huayu.query.personal.UserQuery;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
/**
*
* @author fly
* @Date 2015-10-27 0:48:00
* version 1.0
*/
@Repository
public class  UserDaoImpl extends SqlSessionDaoSupport implements UserDao  {

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    super.setSqlSessionFactory(sqlSessionFactory);
    }
    /**
    * 添加
    *
    * @throws SQLException
    */
    public int  addUser(User user) throws SQLException {
    try {
      return this.getSqlSession().insert("com.huayu.entity.personal.UserDao.addUser", user);
    } catch (Exception e) {
    throw new SQLException("com.huayu.entity.personal.UserDao.addUser", e);
    }
    }

    /**
    * 批量添加
    *
    * @throws SQLException
    */
    public int addUsers(List<User>  list) throws SQLException {
    try {
    return this.getSqlSession().insert("com.huayu.entity.personal.UserDao.addUsers", list);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserDao.addUsers", e);
    }
    }

    /**
    * 根据主键删除
    *
    * @return
    * @throws SQLException
    */
    public int deleteByKey(long id) throws SQLException{
    try{
    return this.getSqlSession().delete("com.huayu.entity.personal.UserDao.deleteByKey", id);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserDao.deleteByKey", e);
    }
    }

    /**
    * 根据主键批量删除
    *
    * @return
    * @throws SQLException
    */
    public int deleteByKeys(List<Long> keys) throws SQLException{
    try{
    return this.getSqlSession().delete("com.huayu.entity.personal.UserDao.deleteByKeys", keys);
     }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserDao.deleteByKeys", e);
     }
    }

    /**
    *根据条件删除
    * @param userQuery
    * @return
    * @throws SQLException
    */
    public int deleteByQuery(UserQuery userQuery) throws SQLException{
    try{
    return this.getSqlSession().delete("com.huayu.entity.personal.UserDao.deleteByQuery", userQuery);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserDao.deleteByQuery", e);
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
    return this.getSqlSession().delete("com.huayu.entity.personal.UserDao.deleteByMap", map);
    }catch (Exception e) {
    throw new SQLException("com.huayu.entity.personal.UserDao.deleteByMap", e);
    }
    }
    /**
    * 根据主键更新
    *
    * @return
    * @throws SQLException
    */
    public int updateUserByKey(User user) throws SQLException{
    try{
    return this.getSqlSession().update("com.huayu.entity.personal.UserDao.updateUserByKey", user);
     }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserDao.updateUserByKey", e);
     }
    }

    /**
    * 根据map更新
    *
    * @return
    * @throws SQLException
    */
    public int updateUserByMap(Map<String,Object>  map) throws SQLException{
    try{
    return this.getSqlSession().update("com.huayu.entity.personal.UserDao.updateUserByMap", map);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserDao.updateUserByMap", e);
    }
    }

    /**
    * 根据主键查找
    *
    * @throws SQLException
    */
    public User getUserByKey(long id) throws SQLException {
     try{
    return (User)this.getSqlSession().selectOne("com.huayu.entity.personal.UserDao.getUserByKey",id);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserDao.getUserByKey", e);
    }
    }

    /**
    * 根据主键批量查找
    *
    * @throws SQLException
    */
    public List<User> getUsersByKeys(List<Long> idList) throws SQLException{
    try{
    return this.getSqlSession().selectList("com.huayu.entity.personal.UserDao.getUsersByKeys",idList);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserDao.getUserByKeys", e);
    }
    }

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    public List<User> getUserList(Map<String,Object>  map) throws SQLException{
    try{
    return this.getSqlSession().selectList("com.huayu.entity.personal.UserDao.getUserList",map);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserDao.getUserList", e);
    }
    }

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    public PageBean<User> getUserListWithPage(Map<String,Object>  map)  throws SQLException{
     try{
        //总记录数
        int count = getUserListCount(map);
        //查询数据
        List<User> list = this.getSqlSession().selectList("com.huayu.entity.personal.UserDao.getUserListWithPage",map);
        int currentPage = (Integer) map.get("startRow");
        int pageSize = (Integer) map.get("pageSize");
        PageBean<User> pageBean = new PageBean<User>(currentPage, pageSize, count, list);
        return pageBean;
     }catch (Exception e) {
      throw new SQLException("com.huayu.entity.personal.UserDao.getUserListWithPag", e);
     }
    }

    /**
    * 总条数
    * @param map
    */
    public int getUserListCount(Map<String,Object>  map) throws SQLException{
    try{
    return (Integer)this.getSqlSession().selectOne("com.huayu.entity.personal.UserDao.getUserListCount",map);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserDao.getUserListCount", e);
    }
    }
}

