package xyh.searchlite.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import xyh.searchlite.common.web.SearchLiteInterceptor;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final SearchLiteInterceptor searchLiteInterceptor;

    public WebConfiguration(SearchLiteInterceptor searchLiteInterceptor) {
        this.searchLiteInterceptor = searchLiteInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(searchLiteInterceptor).addPathPatterns("/**");
    }
}
