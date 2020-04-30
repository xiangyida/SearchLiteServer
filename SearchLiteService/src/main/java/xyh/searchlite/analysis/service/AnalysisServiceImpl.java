package xyh.searchlite.analysis.service;

import org.springframework.stereotype.Service;
import xyh.searchlite.analysis.entity.SearchFrequency;
import xyh.searchlite.analysis.mapper.AnalysisMapper;

import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    private final AnalysisMapper analysisMapper;

    public AnalysisServiceImpl(AnalysisMapper analysisMapper) {
        this.analysisMapper = analysisMapper;
    }

    @Override
    public List<SearchFrequency> getSearchFrequency() {
        return analysisMapper.getSearchFrequency();
    }
}
