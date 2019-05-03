package xyh.lixue.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyh.lixue.entity.Problem;
import xyh.lixue.service.ProblemRepository;
import xyh.lixue.service.ProblemService;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/problem")
@Slf4j
public class ProblemController {
    private ProblemService service;
    private ProblemRepository problemRepository;
    @Autowired
    public ProblemController(ProblemService service,ProblemRepository problemRepository){
        this.service=service;
        this.problemRepository=problemRepository;

    }

    @RequestMapping("/search/{title}")
    public List<Problem>searchProblem(@PathVariable String title){
       return problemRepository.findProblemsByTitleOrKnowledgePointOrPublish(title);
    }

    @GetMapping("/transfer")
    public void transfer(){
       List<Problem> list=service.getAll();
//       for(Problem problem:list){
//           log.info(" save--------->  "+problem.getTitle());
//           problemRepository.save(problem);
//       }
        log.info("--------->"+problemRepository.count());
    }

}
