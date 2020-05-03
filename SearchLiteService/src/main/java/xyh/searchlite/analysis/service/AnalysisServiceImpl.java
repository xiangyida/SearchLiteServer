package xyh.searchlite.analysis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import xyh.searchlite.analysis.entity.SearchFrequency;
import xyh.searchlite.analysis.mapper.AnalysisMapper;
import java.util.*;

@Service
public class AnalysisServiceImpl implements AnalysisService {
    private static final String REDIS_HASH_KEY = "word_count";
    private final AnalysisMapper analysisMapper;

    private final RedisTemplate<String,String> redisTemplate;

    public AnalysisServiceImpl(AnalysisMapper analysisMapper, RedisTemplate<String, String> redisTemplate) {
        this.analysisMapper = analysisMapper;
        this.redisTemplate = redisTemplate;
    }


    @Override
    public List<SearchFrequency> getSearchFrequency() {
        return analysisMapper.getSearchFrequency();
    }

    @Override
    public LinkedHashMap<String,Integer> getWordCount() {
        HashOperations<String,String,String> hashOperations=redisTemplate.opsForHash();
        LinkedHashMap<String,Integer> result = new LinkedHashMap<>();
        hashOperations
                .entries(REDIS_HASH_KEY)
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(e -> -Integer.parseInt(e.getValue())))
                .forEachOrdered(e ->result.put(e.getKey(),Integer.valueOf(e.getValue())));
        return result;
    }
}   
