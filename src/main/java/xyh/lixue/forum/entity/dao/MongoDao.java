package xyh.lixue.forum.entity.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoDao {

    @Autowired
    private MongoTemplate mongoTemplate;
}
