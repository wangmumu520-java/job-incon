package com.wly.mapper;

import com.wly.entity.Company;
import com.wly.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Student)表数据库访问层
 *
 * @author 王林园
 * @since 2022-12-26 23:03:32
 */
@Mapper
public interface StudentMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param student 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Student> queryAllByLimit(Student student, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param student 查询条件
     * @return 总行数
     */
    long count();

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int insert(Student student);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Student> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Student> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Student> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Student> entities);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    //
    /**
     * 通过职位名称查询数据
     *
     * @return 实例对象
     */
    List<Student> queryByName(@Param("strIndex") int strIndex, @Param("row") int row, @Param("name") String studentName);

    /**
     * 查询指定行数据
     *
     * @param strIndex 查询起始位置
     * @param row  查询条数
     * @return 对象列表
     */
    List<Student> queryAllStudentByLimit(@Param("strIndex") int strIndex, @Param("row") int row);

    /**
     * 根据职位名称统计行数
     *
     * @return 总行数
     */
    long findCountByStudentName(@Param("name") String studentName);
}

