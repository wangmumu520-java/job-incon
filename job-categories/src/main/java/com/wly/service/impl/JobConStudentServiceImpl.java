package com.wly.service.impl;

import com.wly.entity.Job;
import com.wly.exception.IllegalParamsException;
import com.wly.mapper.JobConStuMapper;
import com.wly.po.JobStuPO;
import com.wly.service.JobConStudentService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("JobConStudentService")
@SuppressWarnings("all")
public class JobConStudentServiceImpl implements JobConStudentService {

    @Autowired
    private JobConStuMapper jobConStuMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public JobStuPO queryById(Integer id) {
        JobStuPO jobStuPO = this.jobConStuMapper.queryById(id);
        if(ObjectUtils.isNotEmpty(jobStuPO)){
            return (JobStuPO) jobStuPO;
        }
        return null;
    }

    /**
     * 分页查询
     * @return 查询结果
     */
    @Override
    public Map<String, Object> queryByPage(int pageNow, int pageRow) {
        //传参错误
        if(pageNow <=0 || pageRow<=0){
            throw new IllegalParamsException("参数传递错误,页码和页行数必须>=1");
        }

        Map<String, Object> map = new HashMap<>();
        long total = this.jobConStuMapper.count();
        int strIndex = (pageNow - 1)*pageRow;
        int row = pageRow;

        try {
            List<JobStuPO> jobStuPOS = jobConStuMapper.queryAllByLimit(strIndex, row);
            if(jobStuPOS != null && jobStuPOS.size()>0){
                map.put("total",total);
                map.put("jobStuPOS",jobStuPOS);
                return map;
            }
        } catch (Exception e) {
            throw new IllegalParamsException("数据查询失败，请重试！");
        }
        return null;
    }


    /**
     * 新增数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    @Override
    public JobStuPO insert(JobStuPO jobStuPO) {
        this.jobConStuMapper.insert(jobStuPO);
        return jobStuPO;
    }

    /**
     * 修改数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    @Override
    public JobStuPO update(JobStuPO jobStuPO) {
        this.jobConStuMapper.update(jobStuPO);
        return this.jobConStuMapper.queryById(jobStuPO.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.jobConStuMapper.deleteById(id) >0;
    }


    /**
     * 根据职位名称分页查询
     * @param pageNow
     * @param pageRow
     * @param position
     * @return
     */
    @Override
    public Map<String, Object> queryByNamePage(int pageNow, int pageRow, String position) {
        //传参错误
        if(pageNow <=0 || pageRow<=0){
            throw new IllegalParamsException("参数传递错误,页码和页行数必须>=1");
        }

        Map<String, Object> map = new HashMap<>();
        long total = this.jobConStuMapper.count();
        int strIndex = (pageNow - 1)*pageRow;
        int row = pageRow;

        try {
            List<JobStuPO> jobStuPOS = jobConStuMapper.queryByName(strIndex, row, position);
            if(jobStuPOS != null && jobStuPOS.size()>0){
                map.put("total",total);
                map.put("jobStuPOS",jobStuPOS);
                return map;
            }
        } catch (Exception e) {
            throw new IllegalParamsException("数据查询失败，请重试！");
        }
        return null;
    }
}
