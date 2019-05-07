package xyh.lixue.user.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyh.lixue.user.entity.User;
import xyh.lixue.user.service.UserService;

import static org.junit.Assert.*;

/**
 * @author XiangYida
 * @version 2019/5/7 16:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    private User user;

    @Before
    public void before(){
        user=new User();
        user.setId("xiangyida");
        user.setName("向益达");
    }

    @Test
    public void pushHtml() {
        userService.pushHtml();
    }

    @Test
    public void getSearchRecords() {
        userService.getSearchRecords(user.getId());
    }

    @Test
    public void getOpenId() {

    }

    @Test
    public void getPPT() {
        userService.getPPT();
    }

    @Test
    public void recordSearch() {
        userService.getSearchRecords(user.getId());
    }

    @Test
    public void recordLogin() {
        userService.recordLogin(user.getId());
    }

    @Test
    public void importUserToRedis() {
    }
}