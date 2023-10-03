package com.milotnt.config;

import com.milotnt.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

//Interceptor register
//@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
//         Interceptor setup
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        Interceptor object set up
        HandlerInterceptor interceptor = new LoginInterceptor();
//        create roster
        List<String> patterns = new ArrayList<>();
        patterns.add("/assets/**");
        patterns.add("/css/**");
        patterns.add("/img/**");
        patterns.add("/js/**");
        patterns.add("templates/adminLogin.html");
        patterns.add("/adminLogin");
//        Interceptor register
        registry.addInterceptor(interceptor).addPathPatterns("/**")
                .excludePathPatterns(patterns);
        registry.addInterceptor(interceptor).excludePathPatterns("/adminLogin/**");
    }
}