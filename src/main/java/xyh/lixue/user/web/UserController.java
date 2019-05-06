package xyh.lixue.user.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyh.lixue.common.result.ApiResult;
import xyh.lixue.common.result.ResultUtil;
import xyh.lixue.user.entity.PPT;
import xyh.lixue.user.entity.Push;
import xyh.lixue.user.entity.SearchRecords;
import xyh.lixue.user.service.UserService;

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

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @RequestMapping("/ppts")
    public ApiResult<List<PPT>>getPPT(){
       return ResultUtil.success(userService.getPPT());
    }

    @RequestMapping("/searchRecords/{userId}")
    public ApiResult<List<SearchRecords>>getSearchRecords(@PathVariable String userId){
        return ResultUtil.success(userService.getSearchRecords(userId));
    }

    @RequestMapping("/pushs")
    public ApiResult<List<Push>>getPush(){
        return ResultUtil.success(userService.pushHtml());
    }

    @RequestMapping("/openId/{code}")
    public ApiResult<String> getOpenId(@PathVariable String code){
        return ResultUtil.success(userService.getOpenId(code));
    }


}
