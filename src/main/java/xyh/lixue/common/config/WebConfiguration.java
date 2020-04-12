package xyh.lixue.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import xyh.lixue.common.web.LixueInterceptor;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final LixueInterceptor lixueInterceptor;

    public WebConfiguration(LixueInterceptor lixueInterceptor) {
        this.lixueInterceptor = lixueInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(lixueInterceptor).addPathPatterns("/**");
    }
}
