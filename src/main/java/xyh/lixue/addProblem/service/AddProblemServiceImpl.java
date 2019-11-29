package xyh.lixue.addProblem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyh.lixue.addProblem.mapper.AddProblemMapper;
import xyh.lixue.searchProblem.entity.Problem;
import xyh.lixue.searchProblem.service.ProblemRepository;

import java.util.List;

@Service
public class AddProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    @Override
    public void addProblem(List<Problem> list) {
        problemRepository.saveAll(list);
    }


}
