package com.wly;

import com.wly.entity.Job;
import com.wly.mapper.JobConStuMapper;
import com.wly.mapper.JobConnectCompanyMapper;
import com.wly.po.JobCompanyPO;
import com.wly.po.JobStuPO;
import com.wly.service.JobConCompanyService;
import com.wly.service.JobConStudentService;
import com.wly.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.handler.LogicalHandler;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = com.wly.CategoriesApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class CategoryApplicationTest {

    @Autowired
    private JobService jobService;

    @Autowired
    private JobConStuMapper jobConStuMapper;

    @Autowired
    private JobConnectCompanyMapper jobConnectCompanyMapper;

    @Autowired
    private JobConStudentService jobConStudentService;

    @Autowired
    private JobConCompanyService jobConCompanyService;

    @Test
    public void testCategory(){
        List<Map<String, Object>> list = jobService.queryByNamePage(1, 5,"实习");
        if (list != null && list.size()>0){
            for (Map<String, Object> map : list) {
                List<Job> jobs = (List<Job>) map.get("jobs");
                if(jobs != null && jobs.size()>0){
                    for (Job job : jobs) {
                        log.info("工作详情:{}",job.toString());
                    }
                }
                long  total = (long) map.get("total");
                log.info("总记录数：{}",total);
            }
        }

//        List<Job> jobs1 = jobDao.queryAllByLimit(1, 5);
//        log.info("jobs={}",jobs1);
//        long count = jobDao.count();
//        System.out.println(count);
//        List<Job> jobs = jobDao.queryAllByLimit(0, 3);
//        System.out.println(jobs);
//        if (list != null && list.size()>0){
//            for (Map<String, Object> map : list) {
//                List<Job> jobs = (List<Job>) map.get("jobs");
//                if(jobs != null && jobs.size()>0){
//                    for (Job job : jobs) {
//                        log.info("工作详情:{}=",job);
//                    }
//                }
//                long  total = (long) map.get("total");
//                log.info("总记录数：{}=",total);
//            }
//        }
    }

    @Test
    public void testStuJob(){
//        JobStuPO jobStuPOS = jobConStuMapper.queryById(1);
//        System.out.println(jobStuPOS);

        //name 查询
//        List<JobStuPO> jobStuPOS1 = jobConStuMapper.queryByName(0, 3, "java开发");
//        for (JobStuPO jobStuPO : jobStuPOS1) {
//            System.out.println(jobStuPO);
//        }
//        long count1 = jobConStuMapper.findCountByPosition("java开发");
//        long count = jobConStuMapper.count();
//        log.info("java开发记录数：{}",count1);
//        log.info("总记录数:{}",count);
//        JobStuPO jobStuPO = new JobStuPO();
//        jobStuPO.setSid(2);
//        jobStuPO.setPosition("初级java开发工程师");
//
//        int insert = this.jobConStuMapper.insert(jobStuPO);
//        log.info("插入记录数：{}",insert);

//        JobStuPO jobStuPOS = jobConStudentService.queryById(1);
//        log.info("查询：{}",jobStuPOS);
        Map<String, Object> map = jobConStudentService.queryByPage(1, 5);
        log.info("总记录数：{}",map.get("total"));
        List<JobStuPO> jobStuPOS1 = (List<JobStuPO>) map.get("jobStuPOS");
        for (JobStuPO jobStuPO : jobStuPOS1) {

            log.info("分页查询id{}:{}",jobStuPO.getId(),jobStuPO);
        }

    }

    @Test
    public void testCompanyJob(){
//        JobCompanyPO companyPO = jobConnectCompanyMapper.queryCompanyPoById(2);
//        log.info("id为2工作发布的企业：{}",companyPO);
//        long count1 = jobConnectCompanyMapper.findCountByPosition("C++");
//        long count = jobConnectCompanyMapper.count();
//        log.info("C++实习生开发记录数：{}",count1);
//        log.info("总记录数:{}",count);
//
//        JobCompanyPO jobCompanyPO = new JobCompanyPO();
//        jobCompanyPO.setCid(1);
//        jobCompanyPO.setPosition("运营实习生");
//        jobCompanyPO.setAllNumber(3);
//        int insert = jobConnectCompanyMapper.insert(jobCompanyPO);
//        log.info("插入总记录数：{}",insert);

        Map<String, Object> map = jobConCompanyService.queryByPage(1, 5);
        log.info("总记录数：{}",map.get("total"));
        List<JobCompanyPO> jobCompanyPOS = (List<JobCompanyPO>) map.get("jobCompanyPOS");
        for (JobCompanyPO jobCompanyPO : jobCompanyPOS) {
            log.info("分页查询id{}:{}",jobCompanyPO.getId(),jobCompanyPO);
        }
    }


}
