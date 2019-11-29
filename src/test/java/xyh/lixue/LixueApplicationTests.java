package xyh.lixue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyh.lixue.addProblem.mapper.AddProblemMapper;
import xyh.lixue.addProblem.service.ProblemService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LixueApplicationTests {

    @Autowired
    private ProblemService service;

    @Autowired
    private AddProblemMapper mapper;

    @Test
    public void contextLoads() {
        service.addProblem(mapper.getProblems());
    }

}
