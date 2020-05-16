package cn.system1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableOAuth2Sso
@EnableSwagger2
public class Start1 {
    public static void main(String[] args) {
        SpringApplication.run(Start1.class,args);
    }
}
