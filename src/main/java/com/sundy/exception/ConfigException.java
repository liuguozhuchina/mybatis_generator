package com.sundy.exception;

/**
 * Created by Administrator on 2015/8/16.
 * 配置文件异常类
 */
public class ConfigException extends Exception {

    public ConfigException(String message) {
        super(message);
    }

    public ConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigException(Throwable cause) {
        super(cause);
    }
}
