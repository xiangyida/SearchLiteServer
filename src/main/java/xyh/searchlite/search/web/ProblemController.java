package xyh.searchlite.search.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyh.searchlite.common.enums.SearchTypeEnum;
import xyh.searchlite.common.result.ApiResult;
import xyh.searchlite.common.result.ResultUtil;
import xyh.searchlite.search.entity.Problem;
import xyh.searchlite.search.service.ProblemService;

import java.io.IOException;
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
       return ResultUtil.success(problemService.searchProblemByString(SearchTypeEnum.TITLE,title));
    }

    @RequestMapping("/searchByPicture")
    public ApiResult<List<Problem>> searchByPicture(@RequestParam(value = "file")MultipartFile file) throws IOException {
        return ResultUtil.success(problemService.searchProblemByPicture(file.getBytes()));
    }

    /**
     * 将MySQL中的题库导入的Elasticsearch中，仅供开发用
     * @return apiResult
     */
    @GetMapping("/transfer")
    public ApiResult transfer(){
        problemService.transfer();
        return ResultUtil.success();
    }

    @GetMapping("/{id}")
    public ApiResult getProblemById(@PathVariable String id){
        Problem problem=problemService.getProblemById(id);
        return ResultUtil.success(problem);
    }


}