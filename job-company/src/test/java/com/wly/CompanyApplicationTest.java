package com.wly;

import com.wly.entity.Company;
import com.wly.entity.Job;
import com.wly.mapper.CompanyDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
@SpringBootTest(classes = com.wly.CompanyApplication.class)
@RunWith(SpringRunner.class)
public class CompanyApplicationTest {
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testCategory() {
        long count = companyDao.count();
        System.out.println("企业数量："+count);
        List<Company> Companies = companyDao.queryAllCompanyByLimit(0, 5);
        for (Company company : Companies) {
            System.out.println(company);
        }
//        Company company = new Company();
//        company.setName("杭州安恒信息技术股份有限公司");
//        company.setScope("1000-9999");
//        company.setStatus("已上市");
//        company.setCategory("信息安全");
//        company.setAddress("杭州滨江区安恒大厦");
//        company.setPassword("ahxx@2007");
//company.setId(5);
//        company.setCreateDate(new Date(2007,05,15));
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2007,05,15,00,00,00);
//        company.setCreateDate(calendar.getTime());
//        company.setFund("7850.4696万人民币");
//        company.setPublish(15);
//        company.setIntroduction(null);
//        company.setRepresentative("吴卓群");
//        int res = companyDao.update(company);
//        System.out.println("插入记录数"+res);
//        System.out.println("更新记录数"+res);
//        int i = companyDao.deleteById(4);
//        System.out.println("删除记录数："+i);
    }
}
