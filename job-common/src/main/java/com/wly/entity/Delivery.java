package com.wly.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (Delivery)实体类
 *
 * @author wanglinyuan
 * @since 2022-12-12 23:30:40
 */
public class Delivery implements Serializable {
    private static final long serialVersionUID = 400075597200614432L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 学生id
     */
    @JsonProperty("s_id")
    private Integer sId;
    /**
     * 企业id
     */
    @JsonProperty("c_id")
    private Integer cId;
    /**
     * 投递状态
     */
    @JsonProperty("final_status")
    private Integer finalStatus;
    /**
     * 投递时间
     */
    private Date date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public Integer getCId() {
        return cId;
    }

    public void setCId(Integer cId) {
        this.cId = cId;
    }

    public Integer getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(Integer finalStatus) {
        this.finalStatus = finalStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

