package com.wly.service.impl;

import com.wly.exception.IllegalParamsException;
import com.wly.mapper.JobMapper;
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
@SuppressWarnings("all")
public class JobServiceImpl implements JobService {
    @Resource
    private JobMapper jobMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public List<Job> queryById(Integer id) {
        List<Job> jobs = this.jobMapper.queryById(id);
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
    public List<Map<String,Object>> queryByPage(int pageNow, int pageRow) {
        if(pageNow <=0 || pageRow<=0){
            throw new IllegalParamsException("参数传递错误,页码和页行数必须>=1");
        }
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        long total = this.jobMapper.count();
        int strIndex = (pageNow - 1)*pageRow;
        int row = pageRow;
        List<Job> jobs = this.jobMapper.queryAllByLimit(strIndex, row);

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
        this.jobMapper.insert(job);
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
        this.jobMapper.update(job);
        List<Job> jobs = this.jobMapper.queryById(job.getId());
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
        return this.jobMapper.deleteById(id) > 0;
    }

    /**
     * 根据职位名称分页查询
     * @param pageNow
     * @param pageRow
     * @param position
     * @return
     */
    @Override
    public List<Map<String, Object>> queryByNamePage(int pageNow, int pageRow, String position) {
        if(pageNow <=0 || pageRow<=0){
            throw new IllegalParamsException("参数传递错误,页码和页行数必须>=1");
        }
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        long total = this.jobMapper.findCountByPosition(position);
        int strIndex = (pageNow - 1)*pageRow;
        int row = pageRow;
        List<Job> jobs = this.jobMapper.queryByName(strIndex, row, position);
        if(jobs != null && jobs.size()>0){
            map.put("total",total);
            map.put("jobs",jobs);
            list.add(map);
            return list;
        }
        return null;
    }
}
