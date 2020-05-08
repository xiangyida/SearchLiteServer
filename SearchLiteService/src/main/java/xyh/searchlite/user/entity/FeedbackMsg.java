package xyh.searchlite.user.entity;

import lombok.Data;

/**
 * 用户的问题反馈
 */
@Data
public class FeedbackMsg {
    //问题
    private String problem;
    //联系方式
    private String contact;
    //备注
    private String others;
}
