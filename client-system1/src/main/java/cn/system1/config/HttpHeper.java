package cn.system1.config;

import cn.common.http.HttpClientHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class HttpHeper {
    @Bean
    HttpClientHelper httpClientHelper(HttpServletRequest request){
        return new HttpClientHelper(request);
    }
}
