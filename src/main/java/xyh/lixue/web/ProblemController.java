package xyh.lixue.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyh.lixue.entity.Problem;
import xyh.lixue.service.ProblemService;

import java.util.List;

@RestController
@RequestMapping("/problem")
@Slf4j
public class ProblemController {
    private ProblemService service;
    @Autowired
    public ProblemController(ProblemService service){
        this.service=service;

    }

    @RequestMapping("/search/{title}")
    public List<Problem>searchProblem(@PathVariable String title){
       log.info("=");
        return service.searchProble(title);

    }

}
