package xyh.searchlite.search.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import xyh.searchlite.search.entity.SearchData;
import xyh.searchlite.search.service.SearchDataService;

import javax.annotation.Resource;

@Service
public class SearchDataServiceImpl implements SearchDataService {

    private static final String SEARCH_DATA_TOPIC = "search_data";

    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;


    @Override
    public void collectSearchData(SearchData searchData) {
        String message = JSONObject.toJSONString(searchData);
        kafkaTemplate.send(SEARCH_DATA_TOPIC,message);
    }
}
