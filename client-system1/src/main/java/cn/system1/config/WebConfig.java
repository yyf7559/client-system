package cn.system1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String ssoCookies="";
                Cookie[] cookies=request.getCookies();
                for (Cookie cookie:cookies){
                    ssoCookies+=cookie.getName()+"="+cookie.getValue()+";";
                }
                request.setAttribute("ssoCookies",ssoCookies);
                return true;
            }
        }).addPathPatterns("/call/**");
    }
}
