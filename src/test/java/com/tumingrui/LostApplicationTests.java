package com.tumingrui;

import com.tumingrui.dao.IssueDao;
import com.tumingrui.dao.LostDao;
import com.tumingrui.dao.UserDao;
import com.tumingrui.service.IssueService;
import com.tumingrui.service.LostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LostApplicationTests {


    @Autowired
    private LostDao lostDao;
    @Autowired
    private LostService lostService;
    @Autowired
    private IssueDao IssueDao;
    @Autowired
    private IssueService IssueService;
    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {
        System.out.println(lostService.getById(1));
        System.out.println(lostDao.selectById(1));
    }
    @Test
    void sdaw(){
        System.out.println(lostDao.selectById(1));
    }
    @Test
    void hshf(){
        System.out.println(IssueDao.selectById(2));
        System.out.println(IssueService.getById(2));
    }
    @Test
    void yonghu(){
        System.out.println(userDao.selectById(8));
    }

}
