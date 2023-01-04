package com.wly.mapper;

import com.wly.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Company)表数据库访问层
 *
 * @author 王林园
 * @since 2022-12-26 22:47:08
 */
@Mapper
public interface CompanyMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Company queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param company 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Company> queryAllByLimit(Company company, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @return 总行数
     */
    long count();

    /**
     * 新增数据
     *
     * @param company 实例对象
     * @return 影响行数
     */
    int insert(Company company);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Company> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Company> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Company> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Company> entities);

    /**
     * 修改数据
     *
     * @param company 实例对象
     * @return 影响行数
     */
    int update(Company company);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过职位名称查询数据
     *
     * @return 实例对象
     */
    List<Company> queryByName(@Param("strIndex") int strIndex, @Param("row") int row, @Param("name") String companyName);

    /**
     * 查询指定行数据
     *
     * @param strIndex 查询起始位置
     * @param row  查询条数
     * @return 对象列表
     */
    List<Company> queryAllCompanyByLimit(@Param("strIndex") int strIndex, @Param("row") int row);

    /**
     * 根据职位名称统计行数
     *
     * @return 总行数
     */
    long findCountByCompanyName(@Param("name") String companyName);
}

