package com.wly.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wly.entity.Company;

import java.io.Serializable;
import java.util.Date;
/**
 * @author wanglinyuan
 */
public class JobCompanyPO implements Serializable {
        /**
         * 主键
         */
        private Integer id;
        /**
         * 企业id
         */
        private Integer cid;
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
         * 关联Company
         */
        private Company company;

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

        public Company getCompany() {
                return company;
        }

        public void setCompany(Company company) {
                this.company = company;
        }

        public Integer getCid() {
                return cid;
        }

        public void setCid(Integer cid) {
                this.cid = cid;
        }

        @Override
        public String toString() {
                return "JobCompanyPO{" +
                        "id=" + id +
                        ", cid=" + cid +
                        ", position='" + position + '\'' +
                        ", allNumber=" + allNumber +
                        ", category='" + category + '\'' +
                        ", nowNumber=" + nowNumber +
                        ", salary=" + salary +
                        ", requirement='" + requirement + '\'' +
                        ", date=" + date +
                        ", company=" + company +
                        '}';
        }
}
