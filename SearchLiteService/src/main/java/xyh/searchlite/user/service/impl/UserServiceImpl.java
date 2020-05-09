package xyh.searchlite.user.service.impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import xyh.searchlite.common.utils.HttpUtil;
import xyh.searchlite.search.entity.Problem;
import xyh.searchlite.user.entity.FeedbackMsg;
import xyh.searchlite.user.entity.PersonalSearchData;
import xyh.searchlite.user.entity.User;
import xyh.searchlite.user.mapper.UserMapper;
import xyh.searchlite.user.entity.SearchRecords;
import xyh.searchlite.user.service.UserService;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XiangYida
 * @version 2019/5/6 19:18
 */
@Service
public class UserServiceImpl implements UserService {
    private static final String REDIS_SET_KEY = "user";

    @Value("${wechat.url}")
    private String url;

    private final UserMapper userMapper;
    private final RedisTemplate<String,String> redisTemplate;

    public UserServiceImpl(UserMapper userMapper, RedisTemplate<String, String> redisTemplate) {
        this.userMapper = userMapper;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<SearchRecords> getSearchRecords(String openId) {
        return userMapper.getSearchRecords(openId);
    }

    @Override
    public String getOpenId(String code) {
       String url=this.url+code;
       String json=HttpUtil.get(url);
       JSONObject jsonObject = new JSONObject(json);
       return jsonObject.getString("openid");
    }

    @Override
    public void recordSearch(SearchRecords searchRecords) {
        userMapper.insertSearchRecords(searchRecords);
    }

    @Override
    public void recordLogin(String openId) {
        SetOperations<String,String>  setOperations = redisTemplate.opsForSet();
        //查询用户是否为新用户
        if(!setOperations.isMember(REDIS_SET_KEY,openId)){
            //添加到redis中
            setOperations.add(REDIS_SET_KEY,openId);
            //添加到mysql中
            userMapper.insertUser(openId);
        }
        userMapper.insertLoginRecords(openId);
    }

    @Override
    public void importUserToRedis() {
        SetOperations<String,String>  setOperations = redisTemplate.opsForSet();
        userMapper.getAllOpenId().forEach(s-> setOperations.add(REDIS_SET_KEY,s));
    }

    @Override
    public PersonalSearchData getPersonalSearchData(String openId) {
        PersonalSearchData personalSearchData = new PersonalSearchData();
        // 当天个人搜题数量
        Integer todaySearchCount = userMapper.getPersonalTodaySearchCount(openId);
        todaySearchCount = todaySearchCount == null ? 0 :todaySearchCount;
        personalSearchData.setTodaySearchCount(todaySearchCount);

        // 个人搜题总量
        Integer totalSearchCount = userMapper.getPersonalTotalSearchCount(openId);
        totalSearchCount = totalSearchCount == null ? 0 : totalSearchCount;
        personalSearchData.setTotalSearchCount(totalSearchCount);

        // 当天的搜题数量排名
        Integer todayRank = userMapper.getPersonalTodaySearchRank(openId);
        todayRank = todayRank == null ? 0 : todayRank;
        personalSearchData.setTodayRank(todayRank);

        // 计算排名比例
        Integer todayPeople = userMapper.getTodaySearchPeople();
        todayPeople = todayPeople == null ? 0 : todayPeople;
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float) todayRank / (float) todayPeople * 100);
        result = result.equals("0") ? "100" : result;
        personalSearchData.setRankPercentage(result);

        return  personalSearchData;
    }

    @Override
    public void feedback(FeedbackMsg message) {
        userMapper.insertFeedback(message);
    }

    @Override
    public List<Problem> problemPush(String openId) {
        return userMapper.problemPush(openId);
    }
}
