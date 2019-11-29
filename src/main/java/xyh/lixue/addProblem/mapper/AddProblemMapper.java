package xyh.lixue.addProblem.mapper;


import org.springframework.stereotype.Component;
import xyh.lixue.searchProblem.entity.Problem;

import java.util.List;

@Component
public interface AddProblemMapper {
    List<Problem> getProblems();
}
