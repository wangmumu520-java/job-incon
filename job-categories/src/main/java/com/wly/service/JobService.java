package com.wly.service;

import com.wly.entity.Job;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

/**
 * (Job)表服务接口
 *
 * @author makejava
 * @since 2022-12-22 17:20:20
 */
public interface JobService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<Job> queryById(Integer id);

    /**
     * 分页查询
     *
     * @param pageNow 起始位置
     * @param PageRow   每页记录数
     * @return 查询结果
     */
    List<Map<String,Object>> queryByPage(int pageNow, int PageRow);

    /**
     * 新增数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    Job insert(Job job);

    /**
     * 修改数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    Job update(Job job);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 条件分页查询
     *
     * @return 实例对象
     */
    List<Map<String,Object>> queryByNamePage(int pageNow, int pageRow, String position);
}
