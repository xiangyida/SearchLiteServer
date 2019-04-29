package xyh.lixue.service;

import org.springframework.stereotype.Service;
import xyh.lixue.entity.Problem;

import java.util.List;


public interface ProblemService {
    /**
     * 文本搜题
     * @param title  标题
     * @return 题目
     */
    List<Problem> searchProble(String title);


}
