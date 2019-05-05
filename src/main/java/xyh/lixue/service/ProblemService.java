package xyh.lixue.service;

import xyh.lixue.entity.Problem;

import java.util.List;


public interface ProblemService {
    /**
     * 文本搜题
     * @param title  标题
     * @return 题目
     */
    List<Problem> searchProblemByString(String title);


    /**
     * 拍照搜题
     * @param imageData 图片的byte[]
     * @return 题
     */
    List<Problem> searchProblemByPicture(byte[] imageData);


}
