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
import org.springframework.web.multipart.MultipartFile;
import xyh.common.result.ApiResult;
import xyh.common.result.ResultUtil;
import xyh.lixue.entity.Problem;
import xyh.lixue.service.ProblemRepository;
import xyh.lixue.service.ProblemService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/problem")
@Slf4j
public class ProblemController {

    private ProblemService problemService;

    @Autowired
    public ProblemController(ProblemService problemService) {
        this.problemService=problemService;
    }

    @RequestMapping("/searchByString/{title}")
    public ApiResult<List<Problem>> searchByString(@PathVariable String title) {
       return ResultUtil.success(problemService.searchProblemByString(title));
    }

    @RequestMapping("/searchByPicture")
    public ApiResult<List<Problem>> searchByPicture(MultipartFile file) throws IOException {
        return ResultUtil.success(problemService.searchProblemByPicture(file.getBytes()));
    }

}
