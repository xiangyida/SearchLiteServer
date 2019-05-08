package xyh.lixue.forum.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author XiangYida
 * @version 2019/5/8 20:21
 * 论坛模块-回复
 */
@Data
public class Reply implements Serializable {
    //回复id
    private String id;
    //用户id
    private String userId;
    //帖子id
    private String postId;
    //评论内容
    private String content;
    //点赞数量
    private Integer praise;
}
