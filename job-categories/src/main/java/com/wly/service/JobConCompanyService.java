package com.wly.service;

import com.wly.po.JobCompanyPO;

import java.util.List;
import java.util.Map;

/**
 * author wanglinyuan
 */
public interface JobConCompanyService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JobCompanyPO queryById(Integer id);

    /**
     * 分页查询
     *
     * @param pageNow 起始位置
     * @param pageRow   每页记录数
     * @return 查询结果
     */
    Map<String,Object> queryByPage(int pageNow, int pageRow);

    /**
     * 新增数据
     *
     * @param jobCompanyPO 实例对象
     * @return 实例对象
     */
    JobCompanyPO insert(JobCompanyPO jobCompanyPO);

    /**
     * 修改数据
     *
     * @param jobCompanyPO 实例对象
     * @return 实例对象
     */
    JobCompanyPO update(JobCompanyPO jobCompanyPO);

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
    Map<String,Object> queryByNamePage(int pageNow, int pageRow, String position);
}
