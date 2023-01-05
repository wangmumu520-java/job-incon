package com.wly;

import com.wly.entity.Company;
import com.wly.entity.Student;
import com.wly.mapper.StudentMapper;
import com.wly.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Slf4j
@SpringBootTest(classes = com.wly.StudentApplication.class)
@RunWith(SpringRunner.class)
public class StudentApplicationTest {
    @Autowired
    public StudentMapper studentMapper;
    @Autowired
    public StudentService studentService;
    @Test
    public void test(){
//        long count = studentMapper.count();
//        System.out.println("学生注册总人数："+count);
//        List<Student> studentList = studentMapper.queryByName(0, 3, "张");
//        for (Student student : studentList) {
//            System.out.println("姓张同学"+student.getId()+"的信息："+student);
//        }
//        long countByStudentName = studentMapper.findCountByStudentName("张");
//        System.out.println("姓张同学个数："+countByStudentName);
//        List<Student> students = studentMapper.queryAllStudentByLimit(0, 3);
//        for (Student student : students) {
//            System.out.println("学生"+student.getId()+"信息："+student);
//        }
//        Student student = new Student();
//        student.setId(4);
//        student.setName("徐云");
//        student.setSex("男");
//        student.setPassword("123456");
//        int res = studentMapper.update(student);
//        System.out.println("插入记录数"+res);
//        System.out.println("更新记录数"+res);

        Map<String, Object> map = this.studentService.queryByPage(1, 5);
        long total = (long) map.get("total");
        log.info(" 总记录数：{}", total);
        List<Student> students = (List<Student>) map.get("students");
        for (Student student : students) {
            log.info("学生对象{}的信息：{}",student.getId(),student);
        }
    }
}
