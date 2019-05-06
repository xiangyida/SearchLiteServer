package xyh.lixue.searchProblem.service;

import xyh.lixue.searchProblem.entity.SearchRecords;

import java.util.List;

/**
 * @author XiangYida
 * @version 2019/5/6 19:13
 */
public interface UserService {
    /**
     * 向用户推送文章
     */
    List<Push> pushHtml();

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
     * 返回ppt信息
     * @return ppt
     */
    List<PPT> getPPT();

}
