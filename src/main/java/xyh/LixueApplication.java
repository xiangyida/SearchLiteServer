package xyh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xyh.lixue.mapper")
public class LixueApplication {

    public static void main(String[] args) {
        SpringApplication.run(LixueApplication.class, args);
    }

}
