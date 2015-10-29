package com.huayu.service.personal.impl;

import com.huayu.page.PageBean;
import com.huayu.exception.ServiceException;
import com.huayu.entity.personal.Questions;
import com.huayu.dao.personal.QuestionsDao;
import com.huayu.query.personal.QuestionsQuery;
import com.huayu.service.personal.QuestionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
/**
*
* @author fly
* @Date 2015-10-27 0:57:31
* version 1.0
*/

@Service
public class  QuestionsServiceImpl implements QuestionsService {



    @Autowired
    QuestionsDao questionsDao;
    /**
    * 添加
    *
    * @throws SQLException
    */
    public boolean addQuestions(Questions questions) throws SQLException,ServiceException{
    try {
       return questionsDao.addQuestions(questions)>0;
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
    public boolean addQuestionss(List<Questions>  list) throws SQLException,ServiceException {
    try {
    return questionsDao.addQuestionss(list)>0;
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
    return questionsDao.deleteByKey(id)>0;
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
    return questionsDao.deleteByKeys(idList)>0;
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return false;
    }

    /**
    * 根据条件删除
    * @param questionsQuery
    * @return
    * @throws SQLException
    */
    public boolean deleteByQuery(QuestionsQuery questionsQuery) throws SQLException,ServiceException{
    try {
    return questionsDao.deleteByQuery(questionsQuery)>0;
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
    return questionsDao.deleteByMap(map)>0;
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
    public boolean updateQuestionsByKey(Questions questions) throws SQLException,ServiceException{
    try {
    return questionsDao.updateQuestionsByKey(questions)>0;
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
    public boolean updateQuestionsByMap(Map<String,Object>  map) throws SQLException,ServiceException{
    try {
    return questionsDao. updateQuestionsByMap(map)>0;
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
    public Questions getQuestionsByKey(long id) throws SQLException,ServiceException{
    try {
    return questionsDao.getQuestionsByKey(id);
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
    public List<Questions> getQuestionssByKeys(List<Long> idList) throws SQLException,ServiceException{
    try {
    return questionsDao.getQuestionssByKeys(idList);
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
    public List<Questions> getQuestionsList(Map<String,Object>  map) throws SQLException,ServiceException{
    try {
    return questionsDao.getQuestionsList(map);
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
    public PageBean<Questions> getQuestionsListWithPage(Map<String,Object>  map)  throws SQLException,ServiceException{
    try {
    return questionsDao.getQuestionsListWithPage(map);
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
    public int getQuestionsListCount(Map<String, Object> map) throws SQLException,ServiceException{
    try {

    return questionsDao.getQuestionsListCount(map);
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return 0;
    }



}

