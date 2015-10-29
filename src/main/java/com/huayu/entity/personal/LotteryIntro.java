package com.huayu.entity.personal;

import java.util.*;
import java.io.Serializable;

/**
*
* @author fly
* @Date 2015-10-27 0:39:29
* version 1.0
*/
public class LotteryIntro implements Serializable {
/**
* 序列化ID
*/
private static final long serialVersionUID = 1L;

    /**
    * 主键
    */
    private long         id;
    /**
    * 彩种类型
    */
    private int         typeCode;
    /**
    * 彩种编号
    */
    private int         lotteryId;
    /**
    * 彩种介绍
    */
    private String         intro;

    public long getId() {
    return id;
    }

    public void setId(long id) {
    this.id = id;
    }

    public int getTypeCode() {
    return typeCode;
    }

    public void setTypeCode(int typeCode) {
    this.typeCode = typeCode;
    }

    public int getLotteryId() {
    return lotteryId;
    }

    public void setLotteryId(int lotteryId) {
    this.lotteryId = lotteryId;
    }

    public String getIntro() {
    return intro;
    }

    public void setIntro(String intro) {
    this.intro = intro;
    }

    public String toString() {
    return "LotteryIntro [id=" + id + ",typeCode=" + typeCode + ",lotteryId=" + lotteryId + ",intro=" + intro + "]";
    }
    }
