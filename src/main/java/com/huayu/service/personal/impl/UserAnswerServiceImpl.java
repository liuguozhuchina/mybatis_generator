package com.huayu.service.personal.impl;

import com.huayu.page.PageBean;
import com.huayu.exception.ServiceException;
import com.huayu.entity.personal.UserAnswer;
import com.huayu.dao.personal.UserAnswerDao;
import com.huayu.query.personal.UserAnswerQuery;
import com.huayu.service.personal.UserAnswerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
/**
*
* @author fly
* @Date 2015-10-27 0:52:21
* version 1.0
*/

@Service
public class  UserAnswerServiceImpl implements UserAnswerService {



    @Autowired
    UserAnswerDao userAnswerDao;
    /**
    * 添加
    *
    * @throws SQLException
    */
    public boolean addUserAnswer(UserAnswer userAnswer) throws SQLException,ServiceException{
    try {
       return userAnswerDao.addUserAnswer(userAnswer)>0;
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
    public boolean addUserAnswers(List<UserAnswer>  list) throws SQLException,ServiceException {
    try {
    return userAnswerDao.addUserAnswers(list)>0;
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
    return userAnswerDao.deleteByKey(id)>0;
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
    return userAnswerDao.deleteByKeys(idList)>0;
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return false;
    }

    /**
    * 根据条件删除
    * @param userAnswerQuery
    * @return
    * @throws SQLException
    */
    public boolean deleteByQuery(UserAnswerQuery userAnswerQuery) throws SQLException,ServiceException{
    try {
    return userAnswerDao.deleteByQuery(userAnswerQuery)>0;
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
    return userAnswerDao.deleteByMap(map)>0;
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
    public boolean updateUserAnswerByKey(UserAnswer userAnswer) throws SQLException,ServiceException{
    try {
    return userAnswerDao.updateUserAnswerByKey(userAnswer)>0;
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
    public boolean updateUserAnswerByMap(Map<String,Object>  map) throws SQLException,ServiceException{
    try {
    return userAnswerDao. updateUserAnswerByMap(map)>0;
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
    public UserAnswer getUserAnswerByKey(long id) throws SQLException,ServiceException{
    try {
    return userAnswerDao.getUserAnswerByKey(id);
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
    public List<UserAnswer> getUserAnswersByKeys(List<Long> idList) throws SQLException,ServiceException{
    try {
    return userAnswerDao.getUserAnswersByKeys(idList);
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
    public List<UserAnswer> getUserAnswerList(Map<String,Object>  map) throws SQLException,ServiceException{
    try {
    return userAnswerDao.getUserAnswerList(map);
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
    public PageBean<UserAnswer> getUserAnswerListWithPage(Map<String,Object>  map)  throws SQLException,ServiceException{
    try {
    return userAnswerDao.getUserAnswerListWithPage(map);
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
    public int getUserAnswerListCount(Map<String, Object> map) throws SQLException,ServiceException{
    try {

    return userAnswerDao.getUserAnswerListCount(map);
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return 0;
    }



}

