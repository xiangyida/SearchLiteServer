package xyh.lixue.entity;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

@Data
public class Problem {
    //题目id
    private int problemId;
    //知识点
    private String knowledgePoint;
    //题目标题
    private String title;
    //出版社
    private String publish;
    //题目图片名字
    private String problemPictureName;
    //答案图片名字
    private String answerPictureName;
    //热度
    private int hotPoint;

}
