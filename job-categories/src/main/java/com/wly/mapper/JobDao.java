package com.wly.mapper;

import com.wly.entity.Job;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Job)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-22 17:20:20
 */
@Mapper
public interface JobDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<Job> queryById(Integer id);

    /**
     * 通过职位名称查询数据
     *
     * @return 实例对象
     */
    List<Job> queryByName(@Param("strIndex") int strIndex, @Param("row") int row, @Param("position") String position);

    /**
     * 查询指定行数据
     *
     * @param strIndex 查询起始位置
     * @param row  查询条数
     * @return 对象列表
     */
    List<Job> queryAllByLimit(@Param("strIndex") int strIndex, @Param("row") int row);

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
     * @param job 实例对象
     * @return 影响行数
     */
    int insert(Job job);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Job> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Job> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Job> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Job> entities);

    /**
     * 修改数据
     *
     * @param job 实例对象
     * @return 影响行数
     */
    int update(Job job);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

