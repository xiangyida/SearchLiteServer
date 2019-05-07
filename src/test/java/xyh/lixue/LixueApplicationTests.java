package xyh.lixue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyh.lixue.searchProblem.service.impl.ProblemServiceImplTest;
import xyh.lixue.user.service.impl.UserServiceImplTest;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class LixueApplicationTests {

    @Test
    public void contextLoads() {
    }

}
