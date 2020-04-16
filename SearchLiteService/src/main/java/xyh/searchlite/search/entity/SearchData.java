package xyh.searchlite.search.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * kafka消息实体
 */
@Data
public class SearchData implements Serializable {
    //搜题数据
    private String data;
    //时间
    private Long timestamp;

    public SearchData(String data,Long timestamp){
        this.data=data;
        this.timestamp=timestamp;
    }
}
