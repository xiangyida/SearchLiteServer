package xyh.searchlite.user.entity;

import lombok.Data;
import xyh.searchlite.common.entity.RootEntity;

import java.io.Serializable;

/**
 * @author XiangYida
 * @version 2019/5/4 17:55
 * 用户
 */
@Data
public class User  implements Serializable{

    private String id;
    //用户的openId
    private String openId;
    //注册时间
    private String time;

}
