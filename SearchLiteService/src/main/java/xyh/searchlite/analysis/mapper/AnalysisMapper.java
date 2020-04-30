package xyh.searchlite.analysis.mapper;

import org.springframework.stereotype.Component;
import xyh.searchlite.analysis.entity.SearchFrequency;

import java.util.List;

@Component
public interface AnalysisMapper {
    //得到当天的搜索频率数据
   List<SearchFrequency> getSearchFrequency();
}
