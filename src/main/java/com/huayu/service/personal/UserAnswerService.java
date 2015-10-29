package com.huayu.service.personal;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.huayu.page.PageBean;
import com.huayu.exception.ServiceException;

import com.huayu.entity.personal.UserAnswer;
import com.huayu.query.personal.UserAnswerQuery;

/**
*
* @author fly
* @Date 2015-10-27 0:52:21
* version 1.0
*/
public interface  UserAnswerService {
/**
* 添加
*
* @throws SQLException
*/
boolean addUserAnswer(UserAnswer userAnswer) throws SQLException,ServiceException;

/**
* 批量添加
*
* @throws SQLException
*/
boolean addUserAnswers(List<UserAnswer>  list) throws SQLException,ServiceException ;

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
* @param userAnswerQuery
* @return
* @throws SQLException
*/
boolean deleteByQuery(UserAnswerQuery userAnswerQuery) throws SQLException,ServiceException;

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
boolean updateUserAnswerByKey(UserAnswer userAnswer) throws SQLException,ServiceException;

/**
* 根据主键更新
*
* @return
* @throws SQLException
*/
boolean updateUserAnswerByMap(Map<String,Object>  map) throws SQLException,ServiceException;

/**
* 根据主键查找
*
* @throws SQLException
*/
UserAnswer getUserAnswerByKey(long id) throws SQLException,ServiceException ;

/**
* 根据主键批量查找
*
* @throws SQLException
*/
List<UserAnswer> getUserAnswersByKeys(List<Long> idList) throws SQLException,ServiceException;

/**
* 根据条件查找
*
* @throws SQLException
*/
List<UserAnswer> getUserAnswerList(Map<String,Object>  map) throws SQLException,ServiceException;

/**
* 根据条件查找
*
* @throws SQLException
*/
PageBean<UserAnswer> getUserAnswerListWithPage(Map<String, Object> map)  throws SQLException,ServiceException;

/**
* 总条数
* @param map
*/
int getUserAnswerListCount(Map<String,Object>  map) throws SQLException,ServiceException;



}

