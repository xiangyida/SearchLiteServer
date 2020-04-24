package xyh.searchlite.search.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;


/**
 * kafka消息实体
 */

@Getter
@Setter
public class SearchData implements Serializable {
    private  static  final SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    //搜题数据
    private String data;
    //时间
    private Long ts;

    public SearchData(String data,Long ts){
        this.data=data;
        this.ts=ts;
    }

    @Override
    public String toString() {
        return "{\"data\": \"" +
                data +
                "\",\"ts\": \"" +
                df.format(ts) +
                "\"}";
    }
}
