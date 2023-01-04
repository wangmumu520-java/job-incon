package com.wly.service.impl;

import com.wly.entity.Company;
import com.wly.exception.IllegalException;
import com.wly.mapper.CompanyMapper;
import com.wly.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Company)表服务实现类
 *
 * @author 王林园
 * @since 2022-12-26 22:47:08
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private CompanyMapper companyMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Company queryById(Integer id) {
        return this.companyMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param pageNow 当前页码
     * @param pageRow 当前页行数
     * @return 查询结果
     */
    @Override
    public Map<String,Object> queryByPage(int pageNow, int pageRow) {
        if(pageNow <=0 || pageRow<=0){
            throw new IllegalException("参数传递错误,页码和页行数必须>=1");
        }
        HashMap<String, Object> map = new HashMap<>();
        long total = this.companyMapper.count();
        int strIndex = (pageNow -1)*pageRow;
        int row = pageRow;
        try {
            List<Company> companies = this.companyMapper.queryAllCompanyByLimit(strIndex, row);
            if(companies != null && companies.size() >0){
                map.put("total",total);
                map.put("companies",companies);
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 新增数据
     *
     * @param company 实例对象
     * @return 实例对象
     */
    @Override
    public Company insert(Company company) {
        this.companyMapper.insert(company);
        return company;
    }

    /**
     * 修改数据
     *
     * @param company 实例对象
     * @return 实例对象
     */
    @Override
    public Company update(Company company) {
        this.companyMapper.update(company);
        return this.queryById(company.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.companyMapper.deleteById(id) > 0;
    }

    /**
     * 根据name分页查询
     * @param pageNow 当前页码
     * @param pageRow 当前页行数
     * @param name
     * @return
     */
    @Override
    public Map<String, Object> queryByNamePage(int pageNow, int pageRow, String name) {
        if(pageNow <=0 || pageRow<=0){
            throw new IllegalException("参数传递错误,页码和页行数必须>=1");
        }
        HashMap<String, Object> map = new HashMap<>();
        long count = this.companyMapper.findCountByCompanyName(name);
        int strIndex = (pageNow -1)*pageNow;
        int row = pageRow;
        try {
            List<Company> companies = this.companyMapper.queryByName(strIndex, row, name);
            if(companies != null && companies.size() >0){
                map.put("total",count);
                map.put("companies",companies);
                return map;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
