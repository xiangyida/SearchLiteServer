package xyh.lixue.addProblem.service;


import xyh.lixue.searchProblem.entity.Problem;

import java.util.List;

public interface ProblemService {
    /**
     * 向Es中添加题目
     * @param list
     */
    void addProblem(List<Problem> list);



}
