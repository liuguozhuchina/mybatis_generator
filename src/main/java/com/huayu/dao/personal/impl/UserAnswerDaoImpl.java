package com.huayu.dao.personal.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.apache.ibatis.session.SqlSessionFactory;
import com.huayu.page.PageBean;
import  com.huayu.dao.personal.UserAnswerDao;
import com.huayu.entity.personal.UserAnswer;
import com.huayu.query.personal.UserAnswerQuery;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
/**
*
* @author fly
* @Date 2015-10-27 0:52:21
* version 1.0
*/
@Repository
public class  UserAnswerDaoImpl extends SqlSessionDaoSupport implements UserAnswerDao  {

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    super.setSqlSessionFactory(sqlSessionFactory);
    }
    /**
    * 添加
    *
    * @throws SQLException
    */
    public int  addUserAnswer(UserAnswer userAnswer) throws SQLException {
    try {
      return this.getSqlSession().insert("com.huayu.entity.personal.UserAnswerDao.addUserAnswer", userAnswer);
    } catch (Exception e) {
    throw new SQLException("com.huayu.entity.personal.UserAnswerDao.addUserAnswer", e);
    }
    }

    /**
    * 批量添加
    *
    * @throws SQLException
    */
    public int addUserAnswers(List<UserAnswer>  list) throws SQLException {
    try {
    return this.getSqlSession().insert("com.huayu.entity.personal.UserAnswerDao.addUserAnswers", list);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserAnswerDao.addUserAnswers", e);
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
    return this.getSqlSession().delete("com.huayu.entity.personal.UserAnswerDao.deleteByKey", id);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserAnswerDao.deleteByKey", e);
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
    return this.getSqlSession().delete("com.huayu.entity.personal.UserAnswerDao.deleteByKeys", keys);
     }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserAnswerDao.deleteByKeys", e);
     }
    }

    /**
    *根据条件删除
    * @param userAnswerQuery
    * @return
    * @throws SQLException
    */
    public int deleteByQuery(UserAnswerQuery userAnswerQuery) throws SQLException{
    try{
    return this.getSqlSession().delete("com.huayu.entity.personal.UserAnswerDao.deleteByQuery", userAnswerQuery);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserAnswerDao.deleteByQuery", e);
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
    return this.getSqlSession().delete("com.huayu.entity.personal.UserAnswerDao.deleteByMap", map);
    }catch (Exception e) {
    throw new SQLException("com.huayu.entity.personal.UserAnswerDao.deleteByMap", e);
    }
    }
    /**
    * 根据主键更新
    *
    * @return
    * @throws SQLException
    */
    public int updateUserAnswerByKey(UserAnswer userAnswer) throws SQLException{
    try{
    return this.getSqlSession().update("com.huayu.entity.personal.UserAnswerDao.updateUserAnswerByKey", userAnswer);
     }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserAnswerDao.updateUserAnswerByKey", e);
     }
    }

    /**
    * 根据map更新
    *
    * @return
    * @throws SQLException
    */
    public int updateUserAnswerByMap(Map<String,Object>  map) throws SQLException{
    try{
    return this.getSqlSession().update("com.huayu.entity.personal.UserAnswerDao.updateUserAnswerByMap", map);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserAnswerDao.updateUserAnswerByMap", e);
    }
    }

    /**
    * 根据主键查找
    *
    * @throws SQLException
    */
    public UserAnswer getUserAnswerByKey(long id) throws SQLException {
     try{
    return (UserAnswer)this.getSqlSession().selectOne("com.huayu.entity.personal.UserAnswerDao.getUserAnswerByKey",id);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserAnswerDao.getUserAnswerByKey", e);
    }
    }

    /**
    * 根据主键批量查找
    *
    * @throws SQLException
    */
    public List<UserAnswer> getUserAnswersByKeys(List<Long> idList) throws SQLException{
    try{
    return this.getSqlSession().selectList("com.huayu.entity.personal.UserAnswerDao.getUserAnswersByKeys",idList);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserAnswerDao.getUserAnswerByKeys", e);
    }
    }

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    public List<UserAnswer> getUserAnswerList(Map<String,Object>  map) throws SQLException{
    try{
    return this.getSqlSession().selectList("com.huayu.entity.personal.UserAnswerDao.getUserAnswerList",map);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserAnswerDao.getUserAnswerList", e);
    }
    }

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    public PageBean<UserAnswer> getUserAnswerListWithPage(Map<String,Object>  map)  throws SQLException{
     try{
        //总记录数
        int count = getUserAnswerListCount(map);
        //查询数据
        List<UserAnswer> list = this.getSqlSession().selectList("com.huayu.entity.personal.UserAnswerDao.getUserAnswerListWithPage",map);
        int currentPage = (Integer) map.get("startRow");
        int pageSize = (Integer) map.get("pageSize");
        PageBean<UserAnswer> pageBean = new PageBean<UserAnswer>(currentPage, pageSize, count, list);
        return pageBean;
     }catch (Exception e) {
      throw new SQLException("com.huayu.entity.personal.UserAnswerDao.getUserAnswerListWithPag", e);
     }
    }

    /**
    * 总条数
    * @param map
    */
    public int getUserAnswerListCount(Map<String,Object>  map) throws SQLException{
    try{
    return (Integer)this.getSqlSession().selectOne("com.huayu.entity.personal.UserAnswerDao.getUserAnswerListCount",map);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.UserAnswerDao.getUserAnswerListCount", e);
    }
    }
}

