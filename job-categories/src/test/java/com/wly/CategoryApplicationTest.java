package com.wly;

import com.wly.dao.JobDao;
import com.wly.entity.Job;
import com.wly.service.JobService;
import com.wly.service.impl.JobServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@SpringBootTest(classes = com.wly.CategoriesApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class CategoryApplicationTest {

    @Autowired
    private JobService jobService;

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
}
