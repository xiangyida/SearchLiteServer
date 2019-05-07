package xyh.lixue.knowledgeFramework.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyh.lixue.common.enums.SearchTypeEnum;
import xyh.lixue.common.result.ApiResult;
import xyh.lixue.common.result.ResultUtil;
import xyh.lixue.knowledgeFramework.entity.Book;
import xyh.lixue.knowledgeFramework.entity.Chapter;
import xyh.lixue.knowledgeFramework.entity.Knowledge;
import xyh.lixue.knowledgeFramework.service.KnowledgeFrameworkService;
import xyh.lixue.searchProblem.entity.Problem;
import xyh.lixue.searchProblem.service.ProblemService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/knowledgeFramework")
@Slf4j
public class KnowledgeFrameworkController {

    private KnowledgeFrameworkService knowledgeFrameworkService;

    private ProblemService problemService;

    @Autowired
    public KnowledgeFrameworkController(KnowledgeFrameworkService knowledgeFrameworkService,ProblemService problemService){
        this.knowledgeFrameworkService=knowledgeFrameworkService;
        this.problemService=problemService;
    }

    @RequestMapping("/books")
    public List<Book> getBooks(){
        return knowledgeFrameworkService.getAllBooks();
    }

    @RequestMapping("/chapters/{bookId}")
    public List<Chapter>getChapters(@PathVariable String bookId){
        return knowledgeFrameworkService.getChaptersByBookId(bookId);
    }

    @RequestMapping("/knowledge/{chapterId}")
    public List<Knowledge>getKnowledge(@PathVariable String chapterId){
        return knowledgeFrameworkService.getKnowledgeByChapterId(chapterId);
    }

    @RequestMapping("/problems/{knowledge}")
    public List<Problem>getProblem(@PathVariable String knowledge){
        return problemService.searchProblemByString(SearchTypeEnum.KNOWLEDGEPOINT,knowledge);
    }

}