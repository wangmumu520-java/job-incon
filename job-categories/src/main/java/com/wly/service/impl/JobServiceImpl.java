package com.wly.service.impl;

import com.wly.dao.JobDao;
import com.wly.entity.Job;
import com.wly.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Job)表服务实现类
 *
 * @author makejava
 * @since 2022-12-22 17:20:20
 */
@Service("jobService")
public class JobServiceImpl implements JobService {
    @Resource
    private JobDao jobDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public List<Job> queryById(Integer id) {
        List<Job> jobs = this.jobDao.queryById(id);
        if(jobs != null && jobs.size()>0){
            return jobs;
        }
        return null;
    }

    /**
     * 分页查询
     * @return 查询结果
     */
    @Override
    public List<Map<String,Object>> queryByPage(int pageNow, int PageRow) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        long total = this.jobDao.count();
        int strIndex = (pageNow - 1)*PageRow;
        int row = PageRow;
        List<Job> jobs = this.jobDao.queryAllByLimit(strIndex, row);

        if(jobs != null && jobs.size()>0){
            map.put("total",total);
            map.put("jobs",jobs);
            list.add(map);
            return list;
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
    public Job insert(Job job) {
        this.jobDao.insert(job);
        return job;
    }

    /**
     * 修改数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    @Override
    public Job update(Job job) {
        this.jobDao.update(job);
        List<Job> jobs = this.jobDao.queryById(job.getId());
        if(jobs != null && jobs.size()>0){
            return job;
        }
        return null;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.jobDao.deleteById(id) > 0;
    }

    @Override
    public List<Map<String, Object>> queryByNamePage(int pageNow, int PageRow, String position) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        long total = this.jobDao.findCountByPosition(position);
        int strIndex = (pageNow - 1)*PageRow;
        int row = PageRow;
        List<Job> jobs = this.jobDao.queryByName(strIndex, row, position);
        if(jobs != null && jobs.size()>0){
            map.put("total",total);
            map.put("jobs",jobs);
            list.add(map);
            return list;
        }
        return null;
    }
}
