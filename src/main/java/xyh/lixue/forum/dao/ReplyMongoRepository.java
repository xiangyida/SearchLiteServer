package xyh.lixue.forum.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyh.lixue.forum.entity.Reply;

public interface ReplyMongoRepository extends MongoRepository<Reply,String> {
}
