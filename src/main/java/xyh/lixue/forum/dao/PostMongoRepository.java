package xyh.lixue.forum.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import xyh.lixue.forum.entity.Post;

@Component
public interface PostMongoRepository extends MongoRepository<Post,String> {

}
