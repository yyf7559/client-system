package cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableOAuth2Sso
@EnableCaching
public class MedicineTo {
    public static void main(String[] args) {
        SpringApplication.run(MedicineTo.class,args);
    }
}
