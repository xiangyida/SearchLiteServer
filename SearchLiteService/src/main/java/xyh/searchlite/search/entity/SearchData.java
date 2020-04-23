package xyh.searchlite.search.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * kafka消息实体
 */
@Data
public class SearchData implements Serializable {
    //搜题数据
    private String data;
    //时间
    private Date ts;

    public SearchData(String data,Date ts){
        this.data=data;
        this.ts=ts;
    }
}
