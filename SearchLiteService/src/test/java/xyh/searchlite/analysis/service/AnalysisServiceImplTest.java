package xyh.searchlite.analysis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyh.SearchLiteApplication;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SearchLiteApplication.class)
public class AnalysisServiceImplTest {


    @Autowired
    private AnalysisService analysisService;


    @Test
    public void getWordCount() {
        analysisService.getWordCount();
    }
}