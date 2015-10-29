package com.huayu.entity.personal;

import java.util.*;
import java.io.Serializable;

/**
*
* @author fly
* @Date 2015-10-27 0:48:00
* version 1.0
*/
public class User implements Serializable {
/**
* 序列化ID
*/
private static final long serialVersionUID = 1L;

    /**
    * 主键id
    */
    private long         id;
    /**
    * 用户名
    */
    private String         userName;
    /**
    * 昵称
    */
    private String         nickName;
    /**
    * 密码
    */
    private String         password;
    /**
    * 团队id
    */
    private long         teamId;
    /**
    * 登录ip
    */
    private String         ip;
    /**
    * 登录时间
    */
    private Date         loginTime;
    /**
    * 个性签名
    */
    private String         signature;
    /**
    * 省分
    */
    private String         province;
    /**
    * 城市
    */
    private String         city;
    /**
    * 县
    */
    private String         county;
    /**
    * 地址
    */
    private String         address;
    /**
    * 邮编
    */
    private String         zipCode;
    /**
    * 真实姓名
    */
    private String         realName;
    /**
    * 手机号码
    */
    private String         phoneNumber;
    /**
    * 邮箱
    */
    private String         email;
    /**
    * 邮件是否验证
    */
    private byte         isEmailVerified;
    /**
    * qq号码
    */
    private String         qq;
    /**
    * 提款密码
    */
    private String         pinNumber;
    /**
    * 人名币(单位元)
    */
    private long         money;
    /**
    * 消费金额
    */
    private long         consumptionAmount;
    /**
    * 创建时间
    */
    private Date         createTime;
    /**
    * 更新时间
    */
    private Date         updateTime;

    public long getId() {
    return id;
    }

    public void setId(long id) {
    this.id = id;
    }

    public String getUserName() {
    return userName;
    }

    public void setUserName(String userName) {
    this.userName = userName;
    }

    public String getNickName() {
    return nickName;
    }

    public void setNickName(String nickName) {
    this.nickName = nickName;
    }

    public String getPassword() {
    return password;
    }

    public void setPassword(String password) {
    this.password = password;
    }

    public long getTeamId() {
    return teamId;
    }

    public void setTeamId(long teamId) {
    this.teamId = teamId;
    }

    public String getIp() {
    return ip;
    }

    public void setIp(String ip) {
    this.ip = ip;
    }

    public Date getLoginTime() {
    return loginTime;
    }

    public void setLoginTime(Date loginTime) {
    this.loginTime = loginTime;
    }

    public String getSignature() {
    return signature;
    }

    public void setSignature(String signature) {
    this.signature = signature;
    }

    public String getProvince() {
    return province;
    }

    public void setProvince(String province) {
    this.province = province;
    }

    public String getCity() {
    return city;
    }

    public void setCity(String city) {
    this.city = city;
    }

    public String getCounty() {
    return county;
    }

    public void setCounty(String county) {
    this.county = county;
    }

    public String getAddress() {
    return address;
    }

    public void setAddress(String address) {
    this.address = address;
    }

    public String getZipCode() {
    return zipCode;
    }

    public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
    }

    public String getRealName() {
    return realName;
    }

    public void setRealName(String realName) {
    this.realName = realName;
    }

    public String getPhoneNumber() {
    return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
    return email;
    }

    public void setEmail(String email) {
    this.email = email;
    }

    public byte getIsEmailVerified() {
    return isEmailVerified;
    }

    public void setIsEmailVerified(byte isEmailVerified) {
    this.isEmailVerified = isEmailVerified;
    }

    public String getQq() {
    return qq;
    }

    public void setQq(String qq) {
    this.qq = qq;
    }

    public String getPinNumber() {
    return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
    this.pinNumber = pinNumber;
    }

    public long getMoney() {
    return money;
    }

    public void setMoney(long money) {
    this.money = money;
    }

    public long getConsumptionAmount() {
    return consumptionAmount;
    }

    public void setConsumptionAmount(long consumptionAmount) {
    this.consumptionAmount = consumptionAmount;
    }

    public Date getCreateTime() {
    return createTime;
    }

    public void setCreateTime(Date createTime) {
    this.createTime = createTime;
    }

    public Date getUpdateTime() {
    return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
    }

    public String toString() {
    return "User [id=" + id + ",userName=" + userName + ",nickName=" + nickName + ",password=" + password + ",teamId=" + teamId + ",ip=" + ip + ",loginTime=" + loginTime + ",signature=" + signature + ",province=" + province + ",city=" + city + ",county=" + county + ",address=" + address + ",zipCode=" + zipCode + ",realName=" + realName + ",phoneNumber=" + phoneNumber + ",email=" + email + ",isEmailVerified=" + isEmailVerified + ",qq=" + qq + ",pinNumber=" + pinNumber + ",money=" + money + ",consumptionAmount=" + consumptionAmount + ",createTime=" + createTime + ",updateTime=" + updateTime + "]";
    }
    }
