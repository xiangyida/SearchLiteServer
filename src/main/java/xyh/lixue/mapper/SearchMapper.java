package xyh.lixue.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import xyh.lixue.entity.Problem;

import java.util.List;

@Component
public interface SearchMapper {
    public List<Problem>searchProblem(@Param("name") String name);
    public  boolean insert(Problem problem);
}
