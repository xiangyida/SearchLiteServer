package xyh.lixue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import xyh.lixue.entity.Problem;
import xyh.lixue.mapper.SearchMapper;
import xyh.lixue.service.ProblemService;

import java.util.List;

/**
 * @author XiangYida
 * @version 2019/4/29 10:15
 */
@Service
public class ProblemServiceImpl implements ProblemService {

    private SearchMapper searchMapper;
    @Autowired
    public ProblemServiceImpl(SearchMapper searchMapper){
        this.searchMapper=searchMapper;
    }

    @Override
    public List<Problem> searchProblem(String title) {
        return null;
    }

    @Override
    public List<Problem> getAll() {
        return searchMapper.getAll();
    }
}
