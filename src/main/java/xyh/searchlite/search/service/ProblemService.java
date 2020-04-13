package xyh.searchlite.search.service;

import xyh.searchlite.common.enums.SearchTypeEnum;
import xyh.searchlite.search.entity.Problem;

import java.util.List;


public interface ProblemService {
    /**
     * 文本搜题
     * @param title  标题
     * @return 题目
     */
    List<Problem> searchProblemByString(SearchTypeEnum typeEnum,String title);


    /**
     * 拍照搜题
     * @param imageData 图片的byte[]
     * @return 题
     */
    List<Problem> searchProblemByPicture(byte[] imageData);

    /**
     * 将MySQL中的数据导入到elasticsearch中
     */
    void transfer();

    /**
     * 根据题目id返回题目
     * @param id 题目id
     * @return 题目
     */
    Problem getProblemById(String id);



}
