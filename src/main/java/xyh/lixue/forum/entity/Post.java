package xyh.lixue.forum.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author XiangYida
 * @version 2019/5/8 20:12
 * 论坛模块-帖子
 */
@Data
public class Post implements Serializable {
    //帖子Id
    private String id;
    //发帖人的userId
    private String userId;
    //内容
    private String content;
    //浏览量
    private Integer pageView;
    //发帖时间
    private String time;
    //暂时先不考虑图片，后面再迭代
}