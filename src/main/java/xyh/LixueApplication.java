package xyh;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.redis.core.RedisTemplate;
import xyh.lixue.user.service.UserService;

@SpringBootApplication
@MapperScan("xyh.lixue.*.mapper")
@Slf4j
public class LixueApplication extends SpringBootServletInitializer{



    public static void main(String[] args) {
        SpringApplication.run(LixueApplication.class, args);

    }

}
