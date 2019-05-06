package xyh.lixue.user.mapper;

import org.springframework.stereotype.Component;
import xyh.lixue.user.entity.PPT;
import xyh.lixue.user.entity.Push;
import xyh.lixue.user.entity.SearchRecords;


import java.util.List;

/**
 * @author XiangYida
 * @version 2019/5/6 19:24
 */
@Component
public interface UserMapper {
    //得到推送的HTML相关
    List<Push> getPush();
    //得到搜索记录
    List<SearchRecords> getSearchRecords(String userId);
    //得到ppt
    List<PPT> getPPT();
}
