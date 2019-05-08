package xyh.lixue.searchProblem.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;

/**
 * @author XiangYida
 * @version 2019/5/4 17:51
 * 题目信息
 */

@Document(indexName = "lixue",type = "problem")
@PropertySource("classpath:lixue.properties")
public class Problem implements Serializable {
    @Value("${cos.uri}")
    private String cosUri;
    //题目id
    @Id
    private String id;
    @Field(type = FieldType.Text, searchAnalyzer = "ik_smart", analyzer = "ik_max_word")
    private String knowledgePoint;
    //题目标题
    @Field(type = FieldType.Text, searchAnalyzer = "ik_smart", analyzer = "ik_max_word")
    private String title;
    //出版社
    private String publisher;
    //题目图片名字
    private String problemPictureName;
    //答案图片名字
    private String answerPictureName;
    //热度
    private int hotPoint;

    public String getCosUri() {
        return cosUri;
    }

    public void setCosUri(String cosUri) {
        this.cosUri = cosUri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKnowledgePoint() {
        return knowledgePoint;
    }

    public void setKnowledgePoint(String knowledgePoint) {
        this.knowledgePoint = knowledgePoint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getProblemPictureName() {
        return problemPictureName;
    }

    public void setProblemPictureName(String problemPictureName) {
        this.problemPictureName =cosUri+problemPictureName;
    }

    public String getAnswerPictureName() {
        return answerPictureName;
    }

    public void setAnswerPictureName(String answerPictureName) {
        this.answerPictureName = cosUri+answerPictureName;
    }

    public int getHotPoint() {
        return hotPoint;
    }

    public void setHotPoint(int hotPoint) {
        this.hotPoint = hotPoint;
    }
}
