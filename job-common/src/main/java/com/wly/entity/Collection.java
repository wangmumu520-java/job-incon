package com.wly.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * (Collection)实体类
 *
 * @author wanglinyuan
 * @since 2022-12-12 23:28:04
 */
public class Collection implements Serializable {
    private static final long serialVersionUID = 619041219830640845L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 工作id
     */
    private Integer jid;
    /**
     * 学生id
     */
    @JsonProperty("stu_id")
    private Integer stuId;
    /**
     * 收藏次数
     */
    @JsonProperty("coll_number")
    private Integer collNumber;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getCollNumber() {
        return collNumber;
    }

    public void setCollNumber(Integer collNumber) {
        this.collNumber = collNumber;
    }

}

