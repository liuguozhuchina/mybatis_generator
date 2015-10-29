package com.huayu.entity.personal;

import java.util.*;
import java.io.Serializable;

/**
*
* @author fly
* @Date 2015-10-27 0:52:21
* version 1.0
*/
public class UserAnswer implements Serializable {
/**
* 序列化ID
*/
private static final long serialVersionUID = 1L;

    /**
    * 主键
    */
    private long         id;
    /**
    * 用户id
    */
    private long         userId;
    /**
    * 问题id
    */
    private int         questionId;
    /**
    * 答案
    */
    private String         answer;
    /**
    * 问题类型(1问题一 2问题二 3问题三)
    */
    private int         type;
    /**
    * 更新时间
    */
    private Date         updateTime;
    /**
    * 创建时间
    */
    private Date         createTime;

    public long getId() {
    return id;
    }

    public void setId(long id) {
    this.id = id;
    }

    public long getUserId() {
    return userId;
    }

    public void setUserId(long userId) {
    this.userId = userId;
    }

    public int getQuestionId() {
    return questionId;
    }

    public void setQuestionId(int questionId) {
    this.questionId = questionId;
    }

    public String getAnswer() {
    return answer;
    }

    public void setAnswer(String answer) {
    this.answer = answer;
    }

    public int getType() {
    return type;
    }

    public void setType(int type) {
    this.type = type;
    }

    public Date getUpdateTime() {
    return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
    }

    public Date getCreateTime() {
    return createTime;
    }

    public void setCreateTime(Date createTime) {
    this.createTime = createTime;
    }

    public String toString() {
    return "UserAnswer [id=" + id + ",userId=" + userId + ",questionId=" + questionId + ",answer=" + answer + ",type=" + type + ",updateTime=" + updateTime + ",createTime=" + createTime + "]";
    }
    }
