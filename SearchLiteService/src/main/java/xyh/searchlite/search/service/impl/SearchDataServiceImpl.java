package xyh.searchlite.search.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import xyh.searchlite.search.entity.SearchData;
import xyh.searchlite.search.service.SearchDataService;

import javax.annotation.Resource;

@Service
@Slf4j
public class SearchDataServiceImpl implements SearchDataService {

    private static final String SEARCH_DATA_TOPIC = "search_data";

    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;


    @Override
    public void collectSearchData(SearchData searchData) {
        String message = searchData.toString();
        kafkaTemplate.send(SEARCH_DATA_TOPIC,message);
        log.debug("===========> send to kafka : "+message);
    }
}
