package xyh;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import xyh.lixue.user.service.UserService;

@SpringBootApplication
@MapperScan("xyh.lixue.*.mapper")
@Slf4j
public class LixueApplication implements CommandLineRunner {

    UserService userService;
    @Autowired
    public LixueApplication(UserService userService){
        this.userService=userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LixueApplication.class, args);

    }

    /**
     * 在启动完成后将mysql的user表中的数据导入redis中
     * @param args none
     * @throws Exception none
     */
    @Override
    public void run(String... args) throws Exception {
        userService.importUserToRedis();
        log.info("------> has imported users from mysql to redis");
    }
}
