package xyh.searchlite.search.service;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import org.springframework.stereotype.Component;
import xyh.searchlite.search.entity.Problem;


@Component
public interface ProblemRepository extends ElasticsearchRepository<Problem,String> {
}
