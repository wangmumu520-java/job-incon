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
    private Integer scope;
    /**
     * 融资状态
     */
    private Integer status;
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
    @JsonProperty("r_fund")
    private String rFund;


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

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public String getRFund() {
        return rFund;
    }

    public void setRFund(String rFund) {
        this.rFund = rFund;
    }

}

