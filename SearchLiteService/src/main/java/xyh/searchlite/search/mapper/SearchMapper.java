package xyh.searchlite.search.mapper;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xyh.searchlite.search.entity.Problem;

import java.util.List;

@Component
public interface SearchMapper {
    //得到数据库中所有的题目
    List<Problem>getAll();

    Problem getProblemById(@Param("id") String id);
}