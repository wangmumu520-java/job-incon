package com.wly.entity;

import com.alibaba.fastjson.annotation.JSONPOJOBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (Company)实体类
 *
 * @author wanglinyuan
 * @since 2022-12-12 23:29:51
 */
public class Company implements Serializable {
    private static final long serialVersionUID = -56524144793967933L;
    /**
     *  主键
     */
    private Integer id;
    /**
     * 企业名
     */
    private String name;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 企业介绍
     */
    private String introduction;
    /**
     * 规模
     */
    private String scope;
    /**
     * 融资状态
     */
    private String status;
    /**
     *  地址
     */
    private String address;
    /**
     * 创立时间
     */
    @JsonProperty("create_date")
    private Date createDate;
    /**
     * 法定代表人
     */
    private String representative;
    /**
     * 注册资金
     */
    private String fund;
    /**
     *  企业类别
     */
    private String category;
    /**
     * 每天可发布职位数
     */
    private Integer publish;
    /**
     * 密码
     */
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPublish() {
        return publish;
    }

    public void setPublish(Integer publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", introduction='" + introduction + '\'' +
                ", scope='" + scope + '\'' +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", createDate=" + createDate +
                ", representative='" + representative + '\'' +
                ", fund='" + fund + '\'' +
                ", category='" + category + '\'' +
                ", publish=" + publish +
                ", password='" + password + '\'' +
                '}';
    }
}

