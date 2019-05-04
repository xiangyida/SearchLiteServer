package xyh.lixue.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


import java.io.Serializable;

@Data
@Document(indexName = "lixue",type = "problem")
public class Problem implements Serializable {
    //题目id
    @Id
    private String problemId;
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String knowledgePoint;
    //题目标题
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String title;
    //出版社
    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String publish;
    //题目图片名字
    private String problemPictureName;
    //答案图片名字
    private String answerPictureName;
    //热度
    private int hotPoint;

}
