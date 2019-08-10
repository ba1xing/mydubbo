package cn.wellcare.web;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableDubboConfiguration
public class ServerWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerWebApplication.class, args);
    }

}
