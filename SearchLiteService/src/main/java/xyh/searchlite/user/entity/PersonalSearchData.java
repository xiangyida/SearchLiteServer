package xyh.searchlite.user.entity;


import lombok.Data;

/**
 * 用户个人的搜题数据
 */
@Data
public class PersonalSearchData {

    //今天搜题数量
    private Integer todaySearchCount;
    //总搜题数量
    private Integer totalSearchCount;
    //今天搜题排名
    private Integer todayRank;
    //排名百分比
    private String rankPercentage;


}
