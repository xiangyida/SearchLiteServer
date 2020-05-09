package xyh.searchlite.user.service;

import xyh.searchlite.search.entity.Problem;
import xyh.searchlite.user.entity.FeedbackMsg;
import xyh.searchlite.user.entity.PersonalSearchData;
import xyh.searchlite.user.entity.SearchRecords;

import java.util.List;

/**
 * @author XiangYida
 * @version 2019/5/6 19:13
 */
public interface UserService {
    /**
     * 用户通过userId查询搜题记录
     * @param userId userId
     * @return List
     */
    List<SearchRecords> getSearchRecords(String userId);

    /**
     * 根据用户的code去获取openId
     * @param code
     * @return
     */
    String getOpenId(String code);

    /**
     * 记录搜题
     * @param searchRecords
     */
    void  recordSearch(SearchRecords searchRecords);

    /**
     * 记录用户登录
     * @param userId userId
     */
    void recordLogin(String userId);

    /**
     * 将用户表中的数据加载到redis中
     * 在启动完成后系统会调用
     */
    void importUserToRedis();

    /**
     * 得到用户的个人搜题数据
     * @return 个人搜题数据
     */
    PersonalSearchData getPersonalSearchData(String openId);

    /**
     * 用户反馈
     * @param message feedback
     */
    void feedback(FeedbackMsg message);

    /**
     * 题目推送
     * @param openId
     * @return problem
     */
    List<Problem> problemPush(String openId);
}
