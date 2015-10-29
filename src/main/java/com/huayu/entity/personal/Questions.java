package com.huayu.entity.personal;

import java.util.*;
import java.io.Serializable;

/**
*
* @author fly
* @Date 2015-10-27 0:57:31
* version 1.0
*/
public class Questions implements Serializable {
/**
* 序列化ID
*/
private static final long serialVersionUID = 1L;

    /**
    * 主键
    */
    private long         id;
    /**
    * 问题
    */
    private String         dnaQues;
    /**
    * 问题类型(1问题一 2问题二 3问题三)
    */
    private int         type;
    /**
    * 问题id
    */
    private int         questionId;

    public long getId() {
    return id;
    }

    public void setId(long id) {
    this.id = id;
    }

    public String getDnaQues() {
    return dnaQues;
    }

    public void setDnaQues(String dnaQues) {
    this.dnaQues = dnaQues;
    }

    public int getType() {
    return type;
    }

    public void setType(int type) {
    this.type = type;
    }

    public int getQuestionId() {
    return questionId;
    }

    public void setQuestionId(int questionId) {
    this.questionId = questionId;
    }

    public String toString() {
    return "Questions [id=" + id + ",dnaQues=" + dnaQues + ",type=" + type + ",questionId=" + questionId + "]";
    }
    }
