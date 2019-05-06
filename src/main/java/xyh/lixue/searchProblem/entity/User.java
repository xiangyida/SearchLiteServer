package xyh.lixue.searchProblem.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author XiangYida
 * @version 2019/5/4 17:55
 * 用户
 */
@Data
public class User implements Serializable {
    //用户的openId
    private String userId;
    //用户名
    private String userName;
    //注册时间
    private String time;

}
