package xyh.lixue.searchProblem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import xyh.lixue.common.utils.HttpUtil;
import xyh.lixue.searchProblem.entity.SearchRecords;
import xyh.lixue.user.mapper.UserMapper;
import xyh.lixue.searchProblem.service.UserService;

import java.util.List;

/**
 * @author XiangYida
 * @version 2019/5/6 19:18
 */
@Service
@PropertySource("classpath:lixue.properties")
public class UserServiceImpl implements UserService{
    @Value("${wechat.url}")
    private String url;

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){
       this.userMapper=userMapper;
    }

    @Override
    public List<Push> pushHtml() {
       return userMapper.getPush();
    }

    @Override
    public List<SearchRecords> getSearchRecords(String userId) {
        return userMapper.getSearchRecords(userId);
    }

    @Override
    public String getOpenId(String code) {
       String url=this.url+code;
       return HttpUtil.get(url);
    }

    @Override
    public List<PPT> getPPT() {
        return userMapper.getPPT();
    }
}
