package com.wly.service;

import com.wly.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Company)表服务接口
 *
 * @author makejava
 * @since 2022-12-26 22:47:08
 */
public interface CompanyService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Company queryById(Integer id);

    /**
     * 分页查询
     *
     * @param company 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Company> queryByPage(Company company, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param company 实例对象
     * @return 实例对象
     */
    Company insert(Company company);

    /**
     * 修改数据
     *
     * @param company 实例对象
     * @return 实例对象
     */
    Company update(Company company);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
