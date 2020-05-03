package xyh.searchlite.analysis.service;

import xyh.searchlite.analysis.entity.SearchFrequency;
import xyh.searchlite.analysis.entity.WordCount;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface AnalysisService {
    /**
     * 得到当天搜题频率
     * @return list
     */
     List<SearchFrequency> getSearchFrequency();

    /**
     * 得到用户搜索分词的数据
     * @return list
     */
    LinkedHashMap<String,Integer> getWordCount();

}
