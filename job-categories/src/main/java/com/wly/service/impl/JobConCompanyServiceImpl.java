package com.wly.service.impl;

import com.wly.exception.IllegalParamsException;
import com.wly.mapper.JobConnectCompanyMapper;
import com.wly.po.JobCompanyPO;
import com.wly.po.JobStuPO;
import com.wly.service.JobConCompanyService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("JobConCompanyService")
@SuppressWarnings("all")
public class JobConCompanyServiceImpl implements JobConCompanyService {

    @Autowired
    private JobConnectCompanyMapper jobConnectCompanyMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public JobCompanyPO queryById(Integer id) {
        JobCompanyPO jobCompanyPO = this.jobConnectCompanyMapper.queryCompanyPoById(id);
        if(ObjectUtils.isNotEmpty(jobCompanyPO)){
            return (JobCompanyPO) jobCompanyPO;
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
        long total = this.jobConnectCompanyMapper.count();
        int strIndex = (pageNow - 1)*pageRow;
        int row = pageRow;

        try {
            List<JobCompanyPO> jobCompanyPOS = jobConnectCompanyMapper.queryAllByLimit(strIndex, row);
            if(jobCompanyPOS != null && jobCompanyPOS.size()>0){
                map.put("total",total);
                map.put("jobCompanyPOS",jobCompanyPOS);
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
    public JobCompanyPO insert(JobCompanyPO jobCompanyPO) {
        this.jobConnectCompanyMapper.insert(jobCompanyPO);
        return jobCompanyPO;
    }

    /**
     * 修改数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    @Override
    public JobCompanyPO update(JobCompanyPO jobCompanyPO) {
        this.jobConnectCompanyMapper.update(jobCompanyPO);
        return this.jobConnectCompanyMapper.queryCompanyPoById(jobCompanyPO.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.jobConnectCompanyMapper.deleteById(id) >0;
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
        long total = this.jobConnectCompanyMapper.count();
        int strIndex = (pageNow - 1)*pageRow;
        int row = pageRow;

        try {
            List<JobCompanyPO> jobCompanyPOS = jobConnectCompanyMapper.queryByName(strIndex, row, position);
            if(jobCompanyPOS != null && jobCompanyPOS.size()>0){
                map.put("total",total);
                map.put("jobCompanyPOS",jobCompanyPOS);
                return map;
            }
        } catch (Exception e) {
            throw new IllegalParamsException("数据查询失败，请重试！");
        }
        return null;
    }
}
