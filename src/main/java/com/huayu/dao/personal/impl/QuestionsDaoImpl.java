package com.huayu.dao.personal.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.apache.ibatis.session.SqlSessionFactory;
import com.huayu.page.PageBean;
import  com.huayu.dao.personal.QuestionsDao;
import com.huayu.entity.personal.Questions;
import com.huayu.query.personal.QuestionsQuery;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
/**
*
* @author fly
* @Date 2015-10-27 0:57:31
* version 1.0
*/
@Repository
public class  QuestionsDaoImpl extends SqlSessionDaoSupport implements QuestionsDao  {

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    super.setSqlSessionFactory(sqlSessionFactory);
    }
    /**
    * 添加
    *
    * @throws SQLException
    */
    public int  addQuestions(Questions questions) throws SQLException {
    try {
      return this.getSqlSession().insert("com.huayu.entity.personal.QuestionsDao.addQuestions", questions);
    } catch (Exception e) {
    throw new SQLException("com.huayu.entity.personal.QuestionsDao.addQuestions", e);
    }
    }

    /**
    * 批量添加
    *
    * @throws SQLException
    */
    public int addQuestionss(List<Questions>  list) throws SQLException {
    try {
    return this.getSqlSession().insert("com.huayu.entity.personal.QuestionsDao.addQuestionss", list);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.QuestionsDao.addQuestionss", e);
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
    return this.getSqlSession().delete("com.huayu.entity.personal.QuestionsDao.deleteByKey", id);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.QuestionsDao.deleteByKey", e);
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
    return this.getSqlSession().delete("com.huayu.entity.personal.QuestionsDao.deleteByKeys", keys);
     }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.QuestionsDao.deleteByKeys", e);
     }
    }

    /**
    *根据条件删除
    * @param questionsQuery
    * @return
    * @throws SQLException
    */
    public int deleteByQuery(QuestionsQuery questionsQuery) throws SQLException{
    try{
    return this.getSqlSession().delete("com.huayu.entity.personal.QuestionsDao.deleteByQuery", questionsQuery);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.QuestionsDao.deleteByQuery", e);
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
    return this.getSqlSession().delete("com.huayu.entity.personal.QuestionsDao.deleteByMap", map);
    }catch (Exception e) {
    throw new SQLException("com.huayu.entity.personal.QuestionsDao.deleteByMap", e);
    }
    }
    /**
    * 根据主键更新
    *
    * @return
    * @throws SQLException
    */
    public int updateQuestionsByKey(Questions questions) throws SQLException{
    try{
    return this.getSqlSession().update("com.huayu.entity.personal.QuestionsDao.updateQuestionsByKey", questions);
     }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.QuestionsDao.updateQuestionsByKey", e);
     }
    }

    /**
    * 根据map更新
    *
    * @return
    * @throws SQLException
    */
    public int updateQuestionsByMap(Map<String,Object>  map) throws SQLException{
    try{
    return this.getSqlSession().update("com.huayu.entity.personal.QuestionsDao.updateQuestionsByMap", map);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.QuestionsDao.updateQuestionsByMap", e);
    }
    }

    /**
    * 根据主键查找
    *
    * @throws SQLException
    */
    public Questions getQuestionsByKey(long id) throws SQLException {
     try{
    return (Questions)this.getSqlSession().selectOne("com.huayu.entity.personal.QuestionsDao.getQuestionsByKey",id);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.QuestionsDao.getQuestionsByKey", e);
    }
    }

    /**
    * 根据主键批量查找
    *
    * @throws SQLException
    */
    public List<Questions> getQuestionssByKeys(List<Long> idList) throws SQLException{
    try{
    return this.getSqlSession().selectList("com.huayu.entity.personal.QuestionsDao.getQuestionssByKeys",idList);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.QuestionsDao.getQuestionsByKeys", e);
    }
    }

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    public List<Questions> getQuestionsList(Map<String,Object>  map) throws SQLException{
    try{
    return this.getSqlSession().selectList("com.huayu.entity.personal.QuestionsDao.getQuestionsList",map);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.QuestionsDao.getQuestionsList", e);
    }
    }

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    public PageBean<Questions> getQuestionsListWithPage(Map<String,Object>  map)  throws SQLException{
     try{
        //总记录数
        int count = getQuestionsListCount(map);
        //查询数据
        List<Questions> list = this.getSqlSession().selectList("com.huayu.entity.personal.QuestionsDao.getQuestionsListWithPage",map);
        int currentPage = (Integer) map.get("startRow");
        int pageSize = (Integer) map.get("pageSize");
        PageBean<Questions> pageBean = new PageBean<Questions>(currentPage, pageSize, count, list);
        return pageBean;
     }catch (Exception e) {
      throw new SQLException("com.huayu.entity.personal.QuestionsDao.getQuestionsListWithPag", e);
     }
    }

    /**
    * 总条数
    * @param map
    */
    public int getQuestionsListCount(Map<String,Object>  map) throws SQLException{
    try{
    return (Integer)this.getSqlSession().selectOne("com.huayu.entity.personal.QuestionsDao.getQuestionsListCount",map);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.QuestionsDao.getQuestionsListCount", e);
    }
    }
}

