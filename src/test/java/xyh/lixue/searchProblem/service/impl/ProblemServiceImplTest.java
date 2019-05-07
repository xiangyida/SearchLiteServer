package xyh.lixue.searchProblem.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyh.lixue.common.enums.SearchTypeEnum;
import xyh.lixue.searchProblem.service.ProblemService;

import static org.junit.Assert.*;

/**
 * @author XiangYida
 * @version 2019/5/7 16:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProblemServiceImplTest {
    @Autowired
    private ProblemService problemService;

    @Test
    public void searchProblemByString() {
        problemService.searchProblemByString(SearchTypeEnum.KNOWLEDGEPOINT,"应力");
        problemService.searchProblemByString(SearchTypeEnum.TITLE,"杠杆");
    }

    @Test
    public void searchProblemByPicture() {
    }

    @Test
    public void transfer() {
    }

    @Test
    public void ocr() {
    }

    @Test
    public void getString() {
    }

    @Test
    public void setAccessToken() {
    }

    @Test
    public void getAccessToken() {
    }
}