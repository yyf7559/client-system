package cn.system1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
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
                StringBuffer ssoCookies = new StringBuffer();
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    ssoCookies
                            .append(cookie.getName())
                            .append("=")
                            .append(cookie.getValue())
                            .append(";");
                }
                ssoCookies.deleteCharAt(ssoCookies.length() - 1);
                request.setAttribute("ssoCookies", ssoCookies.toString());
                return true;
            }
        }).addPathPatterns("/call/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test1").setViewName("/test1");
    }
}
