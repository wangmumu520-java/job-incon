package com.wly.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author wanglinyuan
 * @since 2022-12-12 23:32:03
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 802555897999799637L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 现住址
     */
    @JsonProperty("now_address")
    private String nowAddress;
    /**
     * 专业
     */
    private String major;
    /**
     * 学校
     */
    private String college;
    /**
     * 简介
     */
    private String introduction;
    /**
     * 粉丝数
     */
    @JsonProperty("")
    private Integer fansNumber;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 身份证号
     */
    @JsonProperty("identity_card")
    private String identityCard;
    /**
     * 期望薪资
     */
    @JsonProperty("expect_salary")
    private Integer expectSalary;
    /**
     * 期望职位
     */
    @JsonProperty("expect_position")
    private String expectPosition;
    /**
     * 最高学历
     */
    @JsonProperty("h_education")
    private String hEducation;
    /**
     *  信箱状态
     */
    @JsonProperty("box_status")
    private String boxStatus;
    /**
     *  信箱通知
     */
    @JsonProperty("notice")
    private String notice;


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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getFansNumber() {
        return fansNumber;
    }

    public void setFansNumber(Integer fansNumber) {
        this.fansNumber = fansNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public Integer getExpectSalary() {
        return expectSalary;
    }

    public void setExpectSalary(Integer expectSalary) {
        this.expectSalary = expectSalary;
    }

    public String getExpectPosition() {
        return expectPosition;
    }

    public void setExpectPosition(String expectPosition) {
        this.expectPosition = expectPosition;
    }

    public String getHEducation() {
        return hEducation;
    }

    public void setHEducation(String hEducation) {
        this.hEducation = hEducation;
    }

    public String getBoxStatus() {
        return boxStatus;
    }

    public void setBoxStatus(String boxStatus) {
        this.boxStatus = boxStatus;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}

