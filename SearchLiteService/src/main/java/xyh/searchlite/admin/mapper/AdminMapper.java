package xyh.searchlite.admin.mapper;

import org.springframework.stereotype.Component;
import xyh.searchlite.search.entity.Problem;

import java.util.List;

@Component
public interface AdminMapper {
    //向题库中添加题目
    void insertProblem(List<Problem> list);
}
