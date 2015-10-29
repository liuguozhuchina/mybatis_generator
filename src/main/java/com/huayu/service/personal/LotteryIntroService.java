package com.huayu.service.personal;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.huayu.page.PageBean;
import com.huayu.exception.ServiceException;

import com.huayu.entity.personal.LotteryIntro;
import com.huayu.query.personal.LotteryIntroQuery;

/**
*
* @author fly
* @Date 2015-10-27 0:39:29
* version 1.0
*/
public interface  LotteryIntroService {
/**
* 添加
*
* @throws SQLException
*/
boolean addLotteryIntro(LotteryIntro lotteryIntro) throws SQLException,ServiceException;

/**
* 批量添加
*
* @throws SQLException
*/
boolean addLotteryIntros(List<LotteryIntro>  list) throws SQLException,ServiceException ;

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
* @param lotteryIntroQuery
* @return
* @throws SQLException
*/
boolean deleteByQuery(LotteryIntroQuery lotteryIntroQuery) throws SQLException,ServiceException;

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
boolean updateLotteryIntroByKey(LotteryIntro lotteryIntro) throws SQLException,ServiceException;

/**
* 根据主键更新
*
* @return
* @throws SQLException
*/
boolean updateLotteryIntroByMap(Map<String,Object>  map) throws SQLException,ServiceException;

/**
* 根据主键查找
*
* @throws SQLException
*/
LotteryIntro getLotteryIntroByKey(long id) throws SQLException,ServiceException ;

/**
* 根据主键批量查找
*
* @throws SQLException
*/
List<LotteryIntro> getLotteryIntrosByKeys(List<Long> idList) throws SQLException,ServiceException;

/**
* 根据条件查找
*
* @throws SQLException
*/
List<LotteryIntro> getLotteryIntroList(Map<String,Object>  map) throws SQLException,ServiceException;

/**
* 根据条件查找
*
* @throws SQLException
*/
PageBean<LotteryIntro> getLotteryIntroListWithPage(Map<String, Object> map)  throws SQLException,ServiceException;

/**
* 总条数
* @param map
*/
int getLotteryIntroListCount(Map<String,Object>  map) throws SQLException,ServiceException;



}

