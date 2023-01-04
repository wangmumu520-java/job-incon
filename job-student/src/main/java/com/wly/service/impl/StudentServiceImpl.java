package com.wly.service.impl;

import com.wly.entity.Student;
import com.wly.exception.IllegalParamException;
import com.wly.mapper.StudentMapper;
import com.wly.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Student)表服务实现类
 *
 * @author 王林园
 * @since 2022-12-26 23:03:32
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(Integer id) {
        return this.studentMapper.queryById(id);
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
            throw new IllegalParamException("参数传递错误,页码和页行数必须>=1");
        }
        HashMap<String, Object> map = new HashMap<>();
        long total = this.studentMapper.count();
        int strIndex = (pageNow -1)*pageRow;
        int row = pageRow;
        try {
            List<Student> students = this.studentMapper.queryAllStudentByLimit(strIndex, row);
            if(students != null && students.size()>0){
                map.put("total",total);
                map.put("students",students);
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
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student insert(Student student) {
        this.studentMapper.insert(student);
        return student;
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student update(Student student) {
        this.studentMapper.update(student);
        return this.queryById(student.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.studentMapper.deleteById(id) > 0;
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
            throw new IllegalParamException("参数传递错误,页码和页行数必须>=1");
        }
        HashMap<String, Object> map = new HashMap<>();
        long count = this.studentMapper.findCountByStudentName(name);
        int strIndex = (pageNow -1)*pageNow;
        int row = pageRow;
        try {
            List<Student> students = this.studentMapper.queryByName(strIndex, row, name);
            if(students != null && students.size()>0){
                map.put("total",count);
                map.put("students",students);
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
