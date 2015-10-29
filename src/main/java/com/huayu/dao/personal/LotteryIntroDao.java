package com.huayu.dao.personal;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.huayu.page.PageBean;
import com.huayu.entity.personal.LotteryIntro;
import com.huayu.query.personal.LotteryIntroQuery;

/**
*
* @author fly
* @Date 2015-10-27 0:39:29
* version 1.0
*/
public interface  LotteryIntroDao {
    /**
    * 添加
    *
    * @throws SQLException
    */
    int addLotteryIntro(LotteryIntro lotteryIntro) throws SQLException ;

    /**
    * 批量添加
    *
    * @throws SQLException
    */
    int addLotteryIntros(List<LotteryIntro>  list) throws SQLException ;

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
    * @param lotteryIntroQuery
    * @return
    * @throws SQLException
    */
    int deleteByQuery(LotteryIntroQuery lotteryIntroQuery) throws SQLException;

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
    int updateLotteryIntroByKey(LotteryIntro lotteryIntro) throws SQLException;

    /**
    * 根据主键更新
    *
    * @return
    * @throws SQLException
    */
    int updateLotteryIntroByMap(Map<String,Object>  map) throws SQLException;

    /**
    * 根据主键查找
    *
    * @throws SQLException
    */
    LotteryIntro getLotteryIntroByKey(long id) throws SQLException ;

    /**
    * 根据主键批量查找
    *
    * @throws SQLException
    */
    List<LotteryIntro> getLotteryIntrosByKeys(List<Long> idList) throws SQLException;

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    List<LotteryIntro> getLotteryIntroList(Map<String,Object>  map) throws SQLException ;

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    PageBean<LotteryIntro> getLotteryIntroListWithPage(Map<String,Object>  map)  throws SQLException ;

    /**
    * 总条数
    * @param map
    */
    int getLotteryIntroListCount(Map<String,Object>  map) throws SQLException ;



}

