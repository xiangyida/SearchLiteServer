package xyh.lixue.web;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyh.lixue.entity.Problem;
import xyh.lixue.service.ProblemRepository;
import xyh.lixue.service.ProblemService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/problem")
@Slf4j
public class ProblemController {
    private ProblemService service;
    private ProblemRepository problemRepository;

    @Autowired
    public ProblemController(ProblemService service, ProblemRepository problemRepository) {
        this.service = service;
        this.problemRepository = problemRepository;

    }

    @RequestMapping("/search")
    public List<Problem> searchProblem() {
        return problemRepository.findProblemsByTitleOrKnowledgePointOrPublish("景荣春","title","1");
    }
    @RequestMapping("/search1/{title}")
    public List<Problem> searchProblem1(@PathVariable String title) {
        Iterable<Problem> iterable=problemRepository.search(new MatchQueryBuilder("title",title));
        List list=new ArrayList();
        iterable.forEach(problem->{list.add(problem);});
        return list;
    }

    @GetMapping("/transfer")
    public void transfer() {
        List<Problem> list = service.getAll();
        problemRepository.saveAll(list);
        log.info("--------->" + problemRepository.count());
    }

}
