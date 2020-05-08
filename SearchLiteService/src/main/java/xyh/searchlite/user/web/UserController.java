package xyh.searchlite.user.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import xyh.searchlite.common.result.ApiResult;
import xyh.searchlite.common.result.ResultUtil;
import xyh.searchlite.user.entity.FeedbackMsg;
import xyh.searchlite.user.entity.LoginResult;
import xyh.searchlite.user.entity.PersonalSearchData;
import xyh.searchlite.user.entity.SearchRecords;
import xyh.searchlite.user.service.UserService;

import java.util.List;

/**
 * @author XiangYida
 * @version 2019/5/6 21:23
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Value("${cos.uri}")
    private String cosUri;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @RequestMapping("/searchRecords/{userId}")
    public ApiResult<List<SearchRecords>>getSearchRecords(@PathVariable String userId){
        return ResultUtil.success(userService.getSearchRecords(userId));
    }

    @RequestMapping("/login/{code}")
    public ApiResult<LoginResult> login(@PathVariable String code){
        //获取openid
        String userId=userService.getOpenId(code);
        //记录登陆
        userService.recordLogin(userId);
        LoginResult loginResult=new LoginResult();
        //返回用户的openId
        loginResult.setOpenId(userId);
        //返回云对象存储的uri，后面加装图片会用到
        loginResult.setCosUri(this.cosUri);
        return ResultUtil.success(loginResult);
    }

    @RequestMapping("/recordSearch")
    public ApiResult<?> recordSearch(String openId,String problemId){
        SearchRecords searchRecords=new SearchRecords();
        searchRecords.setOpenId(openId);
        searchRecords.setProblemId(problemId);
        userService.recordSearch(searchRecords);
        return ResultUtil.success();
    }


    @RequestMapping("/personalSearchData/{openId}")
    public ApiResult<PersonalSearchData> personalSearchData(@PathVariable String openId){
        return ResultUtil.success(userService.getPersonalSearchData(openId));
    }

    @PostMapping("/feedback/")
    public ApiResult<?> userFeedback(@RequestBody FeedbackMsg message){
        userService.feedback(message);
        return ResultUtil.success();
    }



}
