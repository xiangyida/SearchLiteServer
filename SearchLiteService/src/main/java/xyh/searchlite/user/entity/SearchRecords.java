package xyh.searchlite.user.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author XiangYida
 * @version 2019/5/6 7:45
 * 用户的搜题记录
 */
@Data
public class SearchRecords implements Serializable {
    //用户Id
    String openId;

    //题目Id
    String problemId;

    //搜索日期
    String time;
}
