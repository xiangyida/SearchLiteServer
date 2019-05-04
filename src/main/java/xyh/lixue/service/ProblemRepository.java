package xyh.lixue.service;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import xyh.lixue.entity.Problem;

import java.util.List;

@Component
public interface ProblemRepository extends ElasticsearchRepository<Problem,String> {
    List<Problem> findProblemsByTitleOrKnowledgePointOrPublish(String title,String c,String b);
    List<Problem> findProblemByTitle(String title);
}
