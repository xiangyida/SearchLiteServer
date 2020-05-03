package xyh.searchlite.analysis.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyh.searchlite.analysis.entity.SearchFrequency;
import xyh.searchlite.analysis.entity.WordCount;
import xyh.searchlite.analysis.service.AnalysisService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    private final AnalysisService analysisService;

    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @GetMapping("/searchFrequency")
    public List<SearchFrequency> getSearchFrequency(){
        return analysisService.getSearchFrequency();
    }

    @GetMapping("/wordCount")
    public LinkedHashMap<String,Integer> getWordCount(){
        return analysisService.getWordCount();
    }
}
