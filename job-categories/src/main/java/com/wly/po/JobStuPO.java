package com.wly.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wly.entity.Student;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * @author wanglinyuan
 */
public class JobStuPO implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 学生id
     */
    private Integer sid;
    /**
     * 职位
     */
    private String position;
    /**
     * 找人总数
     */
    @JsonProperty("all_number")
    private Integer allNumber;
    /**
     * 工作类别
     */
    private String category;
    /**
     * 剩余职位
     */
    @JsonProperty("now_number")
    private Integer nowNumber;
    /**
     * 薪资
     */
    private Integer salary;
    /**
     * 要求
     */
    private String requirement;
    /**
     * 发表日期
     */
    private Date date;
    /**
     * 关联Student
     */
    private Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAllNumber() {
        return allNumber;
    }

    public void setAllNumber(Integer allNumber) {
        this.allNumber = allNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getNowNumber() {
        return nowNumber;
    }

    public void setNowNumber(Integer nowNumber) {
        this.nowNumber = nowNumber;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "JobStuPO{" +
                "id=" + id +
                ", sid=" + sid +
                ", position='" + position + '\'' +
                ", allNumber=" + allNumber +
                ", category='" + category + '\'' +
                ", nowNumber=" + nowNumber +
                ", salary=" + salary +
                ", requirement='" + requirement + '\'' +
                ", date=" + date +
                ", student=" + student +
                '}';
    }
}
