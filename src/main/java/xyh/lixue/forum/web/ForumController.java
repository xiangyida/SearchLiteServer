package xyh.lixue.forum.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyh.lixue.common.result.ApiResult;
import xyh.lixue.common.result.ResultUtil;
import xyh.lixue.forum.entity.Post;
import xyh.lixue.forum.service.ForumService;

import java.util.List;

/**
 * @author XiangYida
 * @version 2019/5/9 21:48
 */
@RestController
@Slf4j
@RequestMapping("/forum")
public class ForumController {

    private ForumService forumService;

    @Autowired
    public ForumController(ForumService forumService){
        this.forumService=forumService;
    }

    @RequestMapping("/getAllPost")
    public ApiResult<List<Post>>getAllPost(){
        return ResultUtil.success(forumService.getAllPost());
    }

    @RequestMapping("/posting")
    public ApiResult posting(){
        Post post=new Post();
        post.setId("1");
        post.setPageView(100);
        post.setContent("hello");
        post.setUserId("xiangyida");
        post.setTime("now");
        forumService.posting(post);
        return ResultUtil.success();

    }



}
