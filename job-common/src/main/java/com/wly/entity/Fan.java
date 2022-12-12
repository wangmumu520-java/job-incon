package com.wly.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (Fan)实体类
 *
 * @author wanglinyuan
 * @since 2022-12-12 23:31:11
 */
public class Fan implements Serializable {
    private static final long serialVersionUID = 972667259470594006L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 学生id
     */
    @JsonProperty("student_id")
    private Integer studentId;
    /**
     * 工作id
     */
    @JsonProperty("job_id")
    private Integer jobId;
    /**
     *  关注时间
     */
    private Date date;
    /**
     * 数量
     */
    private Integer count;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}

