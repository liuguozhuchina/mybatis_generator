package com.huayu.dao.personal.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.apache.ibatis.session.SqlSessionFactory;
import com.huayu.page.PageBean;
import  com.huayu.dao.personal.LotteryIntroDao;
import com.huayu.entity.personal.LotteryIntro;
import com.huayu.query.personal.LotteryIntroQuery;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
/**
*
* @author fly
* @Date 2015-10-27 0:39:29
* version 1.0
*/
@Repository
public class  LotteryIntroDaoImpl extends SqlSessionDaoSupport implements LotteryIntroDao  {

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    super.setSqlSessionFactory(sqlSessionFactory);
    }
    /**
    * 添加
    *
    * @throws SQLException
    */
    public int  addLotteryIntro(LotteryIntro lotteryIntro) throws SQLException {
    try {
      return this.getSqlSession().insert("com.huayu.entity.personal.LotteryIntroDao.addLotteryIntro", lotteryIntro);
    } catch (Exception e) {
    throw new SQLException("com.huayu.entity.personal.LotteryIntroDao.addLotteryIntro", e);
    }
    }

    /**
    * 批量添加
    *
    * @throws SQLException
    */
    public int addLotteryIntros(List<LotteryIntro>  list) throws SQLException {
    try {
    return this.getSqlSession().insert("com.huayu.entity.personal.LotteryIntroDao.addLotteryIntros", list);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.LotteryIntroDao.addLotteryIntros", e);
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
    return this.getSqlSession().delete("com.huayu.entity.personal.LotteryIntroDao.deleteByKey", id);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.LotteryIntroDao.deleteByKey", e);
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
    return this.getSqlSession().delete("com.huayu.entity.personal.LotteryIntroDao.deleteByKeys", keys);
     }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.LotteryIntroDao.deleteByKeys", e);
     }
    }

    /**
    *根据条件删除
    * @param lotteryIntroQuery
    * @return
    * @throws SQLException
    */
    public int deleteByQuery(LotteryIntroQuery lotteryIntroQuery) throws SQLException{
    try{
    return this.getSqlSession().delete("com.huayu.entity.personal.LotteryIntroDao.deleteByQuery", lotteryIntroQuery);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.LotteryIntroDao.deleteByQuery", e);
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
    return this.getSqlSession().delete("com.huayu.entity.personal.LotteryIntroDao.deleteByMap", map);
    }catch (Exception e) {
    throw new SQLException("com.huayu.entity.personal.LotteryIntroDao.deleteByMap", e);
    }
    }
    /**
    * 根据主键更新
    *
    * @return
    * @throws SQLException
    */
    public int updateLotteryIntroByKey(LotteryIntro lotteryIntro) throws SQLException{
    try{
    return this.getSqlSession().update("com.huayu.entity.personal.LotteryIntroDao.updateLotteryIntroByKey", lotteryIntro);
     }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.LotteryIntroDao.updateLotteryIntroByKey", e);
     }
    }

    /**
    * 根据map更新
    *
    * @return
    * @throws SQLException
    */
    public int updateLotteryIntroByMap(Map<String,Object>  map) throws SQLException{
    try{
    return this.getSqlSession().update("com.huayu.entity.personal.LotteryIntroDao.updateLotteryIntroByMap", map);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.LotteryIntroDao.updateLotteryIntroByMap", e);
    }
    }

    /**
    * 根据主键查找
    *
    * @throws SQLException
    */
    public LotteryIntro getLotteryIntroByKey(long id) throws SQLException {
     try{
    return (LotteryIntro)this.getSqlSession().selectOne("com.huayu.entity.personal.LotteryIntroDao.getLotteryIntroByKey",id);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.LotteryIntroDao.getLotteryIntroByKey", e);
    }
    }

    /**
    * 根据主键批量查找
    *
    * @throws SQLException
    */
    public List<LotteryIntro> getLotteryIntrosByKeys(List<Long> idList) throws SQLException{
    try{
    return this.getSqlSession().selectList("com.huayu.entity.personal.LotteryIntroDao.getLotteryIntrosByKeys",idList);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.LotteryIntroDao.getLotteryIntroByKeys", e);
    }
    }

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    public List<LotteryIntro> getLotteryIntroList(Map<String,Object>  map) throws SQLException{
    try{
    return this.getSqlSession().selectList("com.huayu.entity.personal.LotteryIntroDao.getLotteryIntroList",map);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.LotteryIntroDao.getLotteryIntroList", e);
    }
    }

    /**
    * 根据条件查找
    *
    * @throws SQLException
    */
    public PageBean<LotteryIntro> getLotteryIntroListWithPage(Map<String,Object>  map)  throws SQLException{
     try{
        //总记录数
        int count = getLotteryIntroListCount(map);
        //查询数据
        List<LotteryIntro> list = this.getSqlSession().selectList("com.huayu.entity.personal.LotteryIntroDao.getLotteryIntroListWithPage",map);
        int currentPage = (Integer) map.get("startRow");
        int pageSize = (Integer) map.get("pageSize");
        PageBean<LotteryIntro> pageBean = new PageBean<LotteryIntro>(currentPage, pageSize, count, list);
        return pageBean;
     }catch (Exception e) {
      throw new SQLException("com.huayu.entity.personal.LotteryIntroDao.getLotteryIntroListWithPag", e);
     }
    }

    /**
    * 总条数
    * @param map
    */
    public int getLotteryIntroListCount(Map<String,Object>  map) throws SQLException{
    try{
    return (Integer)this.getSqlSession().selectOne("com.huayu.entity.personal.LotteryIntroDao.getLotteryIntroListCount",map);
    }catch (Exception e) {
     throw new SQLException("com.huayu.entity.personal.LotteryIntroDao.getLotteryIntroListCount", e);
    }
    }
}

