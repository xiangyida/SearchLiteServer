package xyh.lixue.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import xyh.lixue.entity.Problem;

import java.util.List;

@Component
public interface SearchMapper {
    public List<Problem>sarchProblem(@Param("name") String name);
}
