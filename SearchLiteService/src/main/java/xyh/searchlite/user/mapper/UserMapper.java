package xyh.searchlite.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xyh.searchlite.user.entity.*;


import java.util.List;

/**
 * @author XiangYida
 * @version 2019/5/6 19:24
 */
@Component
public interface UserMapper {
    //得到搜索记录
    List<SearchRecords> getSearchRecords(@Param("openId") String openId);
    //插入搜索记录
    void insertSearchRecords(@Param("searchRecords") SearchRecords searchRecords);
    //插入登录记录
    void insertLoginRecords(@Param("openId") String openId);
    //获取user表中所有的记录
    List<String> getAllOpenId();
    //向用户表中添加数据
    void insertUser(@Param("openId") String openId);
    //得到用户今天的搜题数量
    Integer getPersonalTodaySearchCount(@Param("openId") String openId);
    //得到用户总搜题数量
    Integer getPersonalTotalSearchCount(@Param("openId") String openId);
    //得到用户今日搜题排名
    Integer getPersonalTodaySearchRank(@Param("openId") String openId);
    //得到今天的搜题总人数
    Integer getTodaySearchPeople();
    //插入用户反馈
    void insertFeedback(@Param("message") FeedbackMsg message);
}
