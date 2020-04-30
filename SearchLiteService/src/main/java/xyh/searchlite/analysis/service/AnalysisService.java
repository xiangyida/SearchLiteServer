package xyh.searchlite.analysis.service;

import xyh.searchlite.analysis.entity.SearchFrequency;

import java.util.List;

public interface AnalysisService {
    /**
     * 得到当天搜题频率
     * @return
     */
     List<SearchFrequency> getSearchFrequency();
}
