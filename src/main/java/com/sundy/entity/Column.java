package com.sundy.entity;

/**
 * Created by Administrator on 2015/8/15.
 * 表字段
 */
public class Column {
    /**
     * 表字段名称
     */
    private String name;
    /**
     * 字段类型
     */
    private String fieldType;
    /**
     * 默认值
     */
    private String fieldDefault;
    /**
     * 字段属性
     */
    private String fieldProperty;
    /**
     * 注释(字段说明)
     */
    private String comment;
    /**
     * 是否可以为空
     */
    private String nullable;
    /**
     * 附加内容
     */
    private String extra;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldDefault() {
        return fieldDefault;
    }

    public void setFieldDefault(String fieldDefault) {
        this.fieldDefault = fieldDefault;
    }

    public String getFieldProperty() {
        return fieldProperty;
    }

    public void setFieldProperty(String fieldProperty) {
        this.fieldProperty = fieldProperty;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNullable() {
        return nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
