package com.huayu.service.personal.impl;

import com.huayu.page.PageBean;
import com.huayu.exception.ServiceException;
import com.huayu.entity.personal.LotteryIntro;
import com.huayu.dao.personal.LotteryIntroDao;
import com.huayu.query.personal.LotteryIntroQuery;
import com.huayu.service.personal.LotteryIntroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
/**
*
* @author fly
* @Date 2015-10-27 0:39:29
* version 1.0
*/

@Service
public class  LotteryIntroServiceImpl implements LotteryIntroService {



    @Autowired
    LotteryIntroDao lotteryIntroDao;
    /**
    * 添加
    *
    * @throws SQLException
    */
    public boolean addLotteryIntro(LotteryIntro lotteryIntro) throws SQLException,ServiceException{
    try {
       return lotteryIntroDao.addLotteryIntro(lotteryIntro)>0;
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
    public boolean addLotteryIntros(List<LotteryIntro>  list) throws SQLException,ServiceException {
    try {
    return lotteryIntroDao.addLotteryIntros(list)>0;
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
    return lotteryIntroDao.deleteByKey(id)>0;
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
    return lotteryIntroDao.deleteByKeys(idList)>0;
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return false;
    }

    /**
    * 根据条件删除
    * @param lotteryIntroQuery
    * @return
    * @throws SQLException
    */
    public boolean deleteByQuery(LotteryIntroQuery lotteryIntroQuery) throws SQLException,ServiceException{
    try {
    return lotteryIntroDao.deleteByQuery(lotteryIntroQuery)>0;
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
    return lotteryIntroDao.deleteByMap(map)>0;
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
    public boolean updateLotteryIntroByKey(LotteryIntro lotteryIntro) throws SQLException,ServiceException{
    try {
    return lotteryIntroDao.updateLotteryIntroByKey(lotteryIntro)>0;
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
    public boolean updateLotteryIntroByMap(Map<String,Object>  map) throws SQLException,ServiceException{
    try {
    return lotteryIntroDao. updateLotteryIntroByMap(map)>0;
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
    public LotteryIntro getLotteryIntroByKey(long id) throws SQLException,ServiceException{
    try {
    return lotteryIntroDao.getLotteryIntroByKey(id);
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
    public List<LotteryIntro> getLotteryIntrosByKeys(List<Long> idList) throws SQLException,ServiceException{
    try {
    return lotteryIntroDao.getLotteryIntrosByKeys(idList);
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
    public List<LotteryIntro> getLotteryIntroList(Map<String,Object>  map) throws SQLException,ServiceException{
    try {
    return lotteryIntroDao.getLotteryIntroList(map);
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
    public PageBean<LotteryIntro> getLotteryIntroListWithPage(Map<String,Object>  map)  throws SQLException,ServiceException{
    try {
    return lotteryIntroDao.getLotteryIntroListWithPage(map);
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
    public int getLotteryIntroListCount(Map<String, Object> map) throws SQLException,ServiceException{
    try {

    return lotteryIntroDao.getLotteryIntroListCount(map);
    } catch (SQLException e) {
    throw e;
    }catch (Exception e) {

    }
    return 0;
    }



}

