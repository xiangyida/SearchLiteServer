package xyh.lixue.service;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import xyh.lixue.entity.Problem;

@Component
public interface ProblemRepository extends ElasticsearchRepository<Problem,String> {

}
