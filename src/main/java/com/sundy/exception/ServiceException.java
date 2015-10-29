package com.sundy.exception;

/**
* @author fly
* @Date 2015-8-25 19:36:09
* version 1.0
* 服务service异常类,所有业务异常必须继承该类
*/
public class ServiceException extends Exception {

//未知错误
public static final ServiceException UNKNOWN = new ServiceException(0, "UNKNOWN");

/**
* 异常信息
*/
protected String msg;

/**
* 具体异常码
*/
protected int code;


public String getMsg() {
return msg;
}

public void setMsg(String msg) {
this.msg = msg;
}

public int getCode() {
return code;
}

public void setCode(int code) {
this.code = code;
}

public ServiceException(int code, String msg) {
this.msg = msg;
this.code = code;
}

public ServiceException(String message) {
super(message);
}

public ServiceException(String message, Throwable cause) {
super(message, cause);
}

public ServiceException(Throwable cause) {
super(cause);
}
}
