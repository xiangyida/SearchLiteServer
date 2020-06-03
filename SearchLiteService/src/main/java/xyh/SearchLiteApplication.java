package xyh;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyh.searchlite.user.service.UserService;

@SpringBootApplication
@MapperScan("xyh.searchlite.*.mapper")
@Slf4j
public class SearchLiteApplication implements CommandLineRunner {

    private UserService userService;

    @Autowired
    public SearchLiteApplication(UserService userService){
        this.userService=userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SearchLiteApplication.class, args);

    }
    /**
     * 在启动完成后将mysql的user表中的数据导入redis中
     * @param args none
     * @throws Exception none
     */
    @Override
    public void run(String... args) throws Exception {
        userService.importUserToRedis();
    }
}
