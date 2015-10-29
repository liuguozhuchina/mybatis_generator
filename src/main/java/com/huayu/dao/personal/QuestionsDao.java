package com.huayu.dao.personal;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.huayu.page.PageBean;
import com.huayu.entity.personal.Questions;
import com.huayu.query.personal.QuestionsQuery;

/**
*
* @author fly
* @Date 2015-10-27 0:57:31
* version 1.0
*/
public interface  QuestionsDao {
    /**
    * 添加
    *
    * @throws SQLException
    */
    int addQuestions(Questions questions) throws SQLException ;

    /**
    * 批量添加
    *
    * @throws SQLException
    */
    int addQuestionss(List<Questions>  list) throws SQLException ;

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
    * @param questionsQuery
    * @return
    * @throws SQLException
    */
    int deleteByQuery(QuestionsQuery questionsQuery) throws SQLException;

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
    int updateQuestionsByKey(Questions questions) throws SQLException;

    /**
    * 根据主键更新
    *
    * @return
    * @throws SQLException
    */
    int updateQuestionsByMap(Map<String,Object>  map) throws SQLException;

    /**
    * 根据主键查找
    *
    * @throws SQLException
    */
    Questions getQuestionsByKey(long id) throws SQLException ;

    /**
    * 根据主键批量查找
    *
    * @throws SQLException
    */
    List<Questions> getQuestionssByKeys(List<Long> idList) throws SQLException;

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    List<Questions> getQuestionsList(Map<String,Object>  map) throws SQLException ;

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    PageBean<Questions> getQuestionsListWithPage(Map<String,Object>  map)  throws SQLException ;

    /**
    * 总条数
    * @param map
    */
    int getQuestionsListCount(Map<String,Object>  map) throws SQLException ;



}

