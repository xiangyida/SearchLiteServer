package xyh.lixue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyh.lixue.searchProblem.service.ProblemService;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class LixueApplicationTests {

    @Autowired
    private ProblemService service;

    @Test
    public void contextLoads() {

    }

}
