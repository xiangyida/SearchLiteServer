package xyh.lixue.knowledgeFramework.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyh.lixue.knowledgeFramework.entity.Book;
import xyh.lixue.knowledgeFramework.service.KnowledgeFrameworkService;

import static org.junit.Assert.*;

/**
 * @author XiangYida
 * @version 2019/5/7 16:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class KnowledgeFrameworkServiceImplTest {
    @Autowired
    private KnowledgeFrameworkService knowledgeFrameworkService;

    private Book book;

    @Before
    public void before(){
        book=new Book();
        book.setId("1");
        book.setBookName("材料力学简明教程-景荣春");
    }

    @Test
    public void getAllBooks() {
        knowledgeFrameworkService.getAllBooks();
    }

    @Test
    public void getChaptersByBookId() {
        knowledgeFrameworkService.getChaptersByBookId(book.getId());
    }

    @Test
    public void getKnowledgeByChapterId() {
        knowledgeFrameworkService.getKnowledgeByChapterId("1");
    }
}