package com.wly.mapper;

import com.wly.po.JobCompanyPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author wanglinyuan
 */
@Mapper
public interface JobConnectCompanyMapper {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JobCompanyPO queryCompanyPoById(Integer id);

    /**
     * 通过职位名称查询数据
     *
     * @return 实例对象
     */
    List<JobCompanyPO> queryByName(@Param("strIndex") int strIndex, @Param("row") int row, @Param("position") String position);

    /**
     * 查询指定行数据
     *
     * @param strIndex 查询起始位置
     * @param row  查询条数
     * @return 对象列表
     */
    List<JobCompanyPO> queryAllByLimit(@Param("strIndex") int strIndex, @Param("row") int row);

    /**
     * 根据职位名称统计行数
     *
     * @return 总行数
     */
    long findCountByPosition(@Param("position") String position);

    /**
     * 统计总行数
     *
     * @return 总行数
     */
    long count();

    /**
     * 新增数据
     *
     * @param jobCompanyPO 实例对象
     * @return 影响行数
     */
    int insert(JobCompanyPO jobCompanyPO);


    /**
     * 修改数据
     *
     * @param jobCompanyPO 实例对象
     * @return 影响行数
     */
    int update(JobCompanyPO jobCompanyPO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
}
