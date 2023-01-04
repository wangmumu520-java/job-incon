package com.wly.service;

import com.wly.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Map;

/**
 * (Student)表服务接口
 *
 * @author 王林园
 * @since 2022-12-26 23:03:32
 */
public interface StudentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(Integer id);

    /**
     * 分页查询
     *@param pageNow 起始位置
     *@param PageRow   每页记录数
     * @return 查询结果
     */
    Map<String,Object> queryByPage(int pageNow, int PageRow);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student update(Student student);

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
    Map<String,Object> queryByNamePage(int pageNow, int pageRow, String name);
}
