package xyh.lixue.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import xyh.lixue.forum.entity.Post;
import xyh.lixue.forum.entity.Reply;
import xyh.lixue.forum.service.ForumService;

import java.util.List;

/**
 * @author XiangYida
 * @version 2019/5/9 20:12
 */
@Service
public class ForumServiceImpl implements ForumService {

    private MongoTemplate mongoTemplate;

    @Autowired
    public ForumServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Post> getAllPost() {
        return mongoTemplate.findAll(Post.class);
    }

    @Override
    public List<Reply> getReplyByPostId(String postId) {
        Criteria criteria = Criteria.where("post_id").is(postId);
        Query query = Query.query(criteria);
        return mongoTemplate.find(query, Reply.class);
    }

    @Override
    public void posting(Post post) {
        mongoTemplate.save(post);
    }

    @Override
    public void reply(Reply reply) {
        mongoTemplate.save(reply);
    }


    @Override
    public void deletePost(String postId) {
        Criteria criteria = Criteria.where("id").is(postId);
        Query query = Query.query(criteria);
        mongoTemplate.remove(query, Post.class);

    }

    @Override
    public void deleteReply(String replyId) {
        Criteria criteria = Criteria.where("id").is(replyId);
        Query query = Query.query(criteria);
        mongoTemplate.remove(query, Reply.class);
    }

    @Override
    public List<Post> getPostByUserId(String userId) {
        Criteria criteria = Criteria.where("user_id").is(userId);
        Query query = Query.query(criteria);
        return mongoTemplate.find(query, Post.class);
    }
}
