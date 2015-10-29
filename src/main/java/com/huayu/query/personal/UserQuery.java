package com.huayu.query.personal;

import com.huayu.page.PageBean;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
*
* @author  fly
* @Date 2015-10-27 0:48:00
* version 1.0
*/
public class UserQuery{

    /**
    * 开始页
    */
    private int startRow;
    /**
    * 分页数据大小
    */
    private int pageSize= PageBean.PAGESIZE;

    /** ==============================批量查询、更新、删除时的Where条件设置====================== **/
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

    public UserQuery setId(long id) {
    this.id = id;
    return this;
    }

    public String getUserName() {
    return userName;
    }

    public UserQuery setUserName(String userName) {
    this.userName = userName;
    return this;
    }

    public String getNickName() {
    return nickName;
    }

    public UserQuery setNickName(String nickName) {
    this.nickName = nickName;
    return this;
    }

    public String getPassword() {
    return password;
    }

    public UserQuery setPassword(String password) {
    this.password = password;
    return this;
    }

    public long getTeamId() {
    return teamId;
    }

    public UserQuery setTeamId(long teamId) {
    this.teamId = teamId;
    return this;
    }

    public String getIp() {
    return ip;
    }

    public UserQuery setIp(String ip) {
    this.ip = ip;
    return this;
    }

    public Date getLoginTime() {
    return loginTime;
    }

    public UserQuery setLoginTime(Date loginTime) {
    this.loginTime = loginTime;
    return this;
    }

    public String getSignature() {
    return signature;
    }

    public UserQuery setSignature(String signature) {
    this.signature = signature;
    return this;
    }

    public String getProvince() {
    return province;
    }

    public UserQuery setProvince(String province) {
    this.province = province;
    return this;
    }

    public String getCity() {
    return city;
    }

    public UserQuery setCity(String city) {
    this.city = city;
    return this;
    }

    public String getCounty() {
    return county;
    }

    public UserQuery setCounty(String county) {
    this.county = county;
    return this;
    }

    public String getAddress() {
    return address;
    }

    public UserQuery setAddress(String address) {
    this.address = address;
    return this;
    }

    public String getZipCode() {
    return zipCode;
    }

    public UserQuery setZipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
    }

    public String getRealName() {
    return realName;
    }

    public UserQuery setRealName(String realName) {
    this.realName = realName;
    return this;
    }

    public String getPhoneNumber() {
    return phoneNumber;
    }

    public UserQuery setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
    }

    public String getEmail() {
    return email;
    }

    public UserQuery setEmail(String email) {
    this.email = email;
    return this;
    }

    public byte getIsEmailVerified() {
    return isEmailVerified;
    }

    public UserQuery setIsEmailVerified(byte isEmailVerified) {
    this.isEmailVerified = isEmailVerified;
    return this;
    }

    public String getQq() {
    return qq;
    }

    public UserQuery setQq(String qq) {
    this.qq = qq;
    return this;
    }

    public String getPinNumber() {
    return pinNumber;
    }

    public UserQuery setPinNumber(String pinNumber) {
    this.pinNumber = pinNumber;
    return this;
    }

    public long getMoney() {
    return money;
    }

    public UserQuery setMoney(long money) {
    this.money = money;
    return this;
    }

    public long getConsumptionAmount() {
    return consumptionAmount;
    }

    public UserQuery setConsumptionAmount(long consumptionAmount) {
    this.consumptionAmount = consumptionAmount;
    return this;
    }

    public Date getCreateTime() {
    return createTime;
    }

    public UserQuery setCreateTime(Date createTime) {
    this.createTime = createTime;
    return this;
    }

    public Date getUpdateTime() {
    return updateTime;
    }

    public UserQuery setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
    return this;
    }


    public int getStartRow() {
    return startRow;
    }

    public void setStartRow(int startRow) {
    this.startRow = startRow;
    queryUpdateMap.put("startRow",startRow);
    }

    public int getPageSize() {
    return pageSize;
    }

    public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
    queryUpdateMap.put("pageSize",pageSize);
    }

    /** ==============================批量查询时的Order条件顺序设置====================== **/

    public class OrderField {
    /**
    * 字段名称
    */
    private String fieldName;
    /**
    * 升降序
    */
    private String order;

    public OrderField(String fieldName, String order) {
    super();
    this.fieldName = fieldName;
    this.order = order;
    }

    public String getFieldName() {
    return fieldName;
    }

    public OrderField setFieldName(String fieldName) {
    this.fieldName = fieldName;
    return this;
    }

    public String getOrder() {
    return order;
    }

    public OrderField setOrder(String order) {
    this.order = order;
    return this;
    }
    }

    /** ==============================批量查询时的Order条件顺序设置====================== **/
    /**
    * 排序列表字段
    **/
    private List<OrderField> orderFields = new ArrayList<OrderField>();

        /**
        * 设置排序按属性：id
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyId(boolean isAsc) {
        orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：user_name
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyUserName(boolean isAsc) {
        orderFields.add(new OrderField("user_name", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：nick_name
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyNickName(boolean isAsc) {
        orderFields.add(new OrderField("nick_name", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：password
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyPassword(boolean isAsc) {
        orderFields.add(new OrderField("password", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：team_id
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyTeamId(boolean isAsc) {
        orderFields.add(new OrderField("team_id", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：ip
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyIp(boolean isAsc) {
        orderFields.add(new OrderField("ip", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：login_time
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyLoginTime(boolean isAsc) {
        orderFields.add(new OrderField("login_time", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：signature
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbySignature(boolean isAsc) {
        orderFields.add(new OrderField("signature", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：province
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyProvince(boolean isAsc) {
        orderFields.add(new OrderField("province", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：city
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyCity(boolean isAsc) {
        orderFields.add(new OrderField("city", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：county
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyCounty(boolean isAsc) {
        orderFields.add(new OrderField("county", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：address
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyAddress(boolean isAsc) {
        orderFields.add(new OrderField("address", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：zip_code
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyZipCode(boolean isAsc) {
        orderFields.add(new OrderField("zip_code", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：real_name
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyRealName(boolean isAsc) {
        orderFields.add(new OrderField("real_name", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：phone_number
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyPhoneNumber(boolean isAsc) {
        orderFields.add(new OrderField("phone_number", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：email
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyEmail(boolean isAsc) {
        orderFields.add(new OrderField("email", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：isEmail_verified
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyIsEmailVerified(boolean isAsc) {
        orderFields.add(new OrderField("isEmail_verified", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：qq
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyQq(boolean isAsc) {
        orderFields.add(new OrderField("qq", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：pin_number
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyPinNumber(boolean isAsc) {
        orderFields.add(new OrderField("pin_number", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：money
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyMoney(boolean isAsc) {
        orderFields.add(new OrderField("money", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：consumption_amount
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyConsumptionAmount(boolean isAsc) {
        orderFields.add(new OrderField("consumption_amount", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：create_time
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyCreateTime(boolean isAsc) {
        orderFields.add(new OrderField("create_time", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        /**
        * 设置排序按属性：update_time
        *
        * @param isAsc
        * 是否升序，否则为降序
        */
        public void orderbyUpdateTime(boolean isAsc) {
        orderFields.add(new OrderField("update_time", isAsc ? "ASC" : "DESC"));
        queryUpdateMap.put("orderFields",orderFields);
        }
        private String fields;
        /**
        * 提供自定义字段使用
        */
        private static Map<String, String> fieldMap;

        private static Map<String, String> getFieldSet() {
        if (fieldMap == null) {
        fieldMap = new HashMap<String, String>();
        fieldMap.put("id","id");
        fieldMap.put("userName","user_name");
        fieldMap.put("nickName","nick_name");
        fieldMap.put("password","password");
        fieldMap.put("teamId","team_id");
        fieldMap.put("ip","ip");
        fieldMap.put("loginTime","login_time");
        fieldMap.put("signature","signature");
        fieldMap.put("province","province");
        fieldMap.put("city","city");
        fieldMap.put("county","county");
        fieldMap.put("address","address");
        fieldMap.put("zipCode","zip_code");
        fieldMap.put("realName","real_name");
        fieldMap.put("phoneNumber","phone_number");
        fieldMap.put("email","email");
        fieldMap.put("isEmailVerified","isEmail_verified");
        fieldMap.put("qq","qq");
        fieldMap.put("pinNumber","pin_number");
        fieldMap.put("money","money");
        fieldMap.put("consumptionAmount","consumption_amount");
        fieldMap.put("createTime","create_time");
        fieldMap.put("updateTime","update_time");
        }
        return fieldMap;
        }

        public String getFields() {
        return this.fields;
        }

        public void setFields(String fields) {
        if (fields == null)
        return;
        String[] array = fields.split(",");
        StringBuffer buffer = new StringBuffer();
        for (String field : array) {
        if (getFieldSet().containsKey(field)) {
        buffer.append(getFieldSet().get(field)).append(" as ")
        .append(field).append(" ,");
        }
        if (getFieldSet().containsKey("`" + field + "`")) {
        buffer.append("`" + getFieldSet().get(field) + "`").append(" as ")
        .append(field).append(" ,");
        }
        }
        if (buffer.length() != 0) {
        this.fields = buffer.substring(0, buffer.length() - 1);
        } else {
        this.fields = " 1 ";// 没有一个参数可能会报错
        }
        }

    /**
    * ==============================查询更新map条件======================
    **/
    private Map<String, Object> queryUpdateMap = new HashMap<String, Object>();

    /**
    * 清空更新集合
    */
    public void clear() {
    queryUpdateMap.clear();
    }

    public Map getQueryUpdateMap() {
    return queryUpdateMap;
    }

    public void setQueryUpdateMap(Map queryUpdateMap) {
    this.queryUpdateMap = queryUpdateMap;
    }


        /**
         *设置Id
         */
        public void setIdMap(long value) {
        queryUpdateMap.put("id", value);
        }
        /**
         *设置UserName
         */
        public void setUserNameMap(String value) {
        queryUpdateMap.put("userName", value);
        }
        /**
         *设置NickName
         */
        public void setNickNameMap(String value) {
        queryUpdateMap.put("nickName", value);
        }
        /**
         *设置Password
         */
        public void setPasswordMap(String value) {
        queryUpdateMap.put("password", value);
        }
        /**
         *设置TeamId
         */
        public void setTeamIdMap(long value) {
        queryUpdateMap.put("teamId", value);
        }
        /**
         *设置Ip
         */
        public void setIpMap(String value) {
        queryUpdateMap.put("ip", value);
        }
        /**
         *设置LoginTime
         */
        public void setLoginTimeMap(Date value) {
        queryUpdateMap.put("loginTime", value);
        }
        /**
         *设置Signature
         */
        public void setSignatureMap(String value) {
        queryUpdateMap.put("signature", value);
        }
        /**
         *设置Province
         */
        public void setProvinceMap(String value) {
        queryUpdateMap.put("province", value);
        }
        /**
         *设置City
         */
        public void setCityMap(String value) {
        queryUpdateMap.put("city", value);
        }
        /**
         *设置County
         */
        public void setCountyMap(String value) {
        queryUpdateMap.put("county", value);
        }
        /**
         *设置Address
         */
        public void setAddressMap(String value) {
        queryUpdateMap.put("address", value);
        }
        /**
         *设置ZipCode
         */
        public void setZipCodeMap(String value) {
        queryUpdateMap.put("zipCode", value);
        }
        /**
         *设置RealName
         */
        public void setRealNameMap(String value) {
        queryUpdateMap.put("realName", value);
        }
        /**
         *设置PhoneNumber
         */
        public void setPhoneNumberMap(String value) {
        queryUpdateMap.put("phoneNumber", value);
        }
        /**
         *设置Email
         */
        public void setEmailMap(String value) {
        queryUpdateMap.put("email", value);
        }
        /**
         *设置IsEmailVerified
         */
        public void setIsEmailVerifiedMap(byte value) {
        queryUpdateMap.put("isEmailVerified", value);
        }
        /**
         *设置Qq
         */
        public void setQqMap(String value) {
        queryUpdateMap.put("qq", value);
        }
        /**
         *设置PinNumber
         */
        public void setPinNumberMap(String value) {
        queryUpdateMap.put("pinNumber", value);
        }
        /**
         *设置Money
         */
        public void setMoneyMap(long value) {
        queryUpdateMap.put("money", value);
        }
        /**
         *设置ConsumptionAmount
         */
        public void setConsumptionAmountMap(long value) {
        queryUpdateMap.put("consumptionAmount", value);
        }
        /**
         *设置CreateTime
         */
        public void setCreateTimeMap(Date value) {
        queryUpdateMap.put("createTime", value);
        }
        /**
         *设置UpdateTime
         */
        public void setUpdateTimeMap(Date value) {
        queryUpdateMap.put("updateTime", value);
        }
    }

