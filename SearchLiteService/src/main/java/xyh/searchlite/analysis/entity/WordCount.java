package xyh.searchlite.analysis.entity;

import lombok.Data;

@Data
public class WordCount{
    //词
    private String word;
    //出现次数
    private Integer cnt;

    public WordCount(String word, Integer cnt) {
        this.word = word;
        this.cnt = cnt;
    }

    public WordCount() {
    }
}
