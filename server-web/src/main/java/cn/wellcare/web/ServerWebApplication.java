package cn.wellcare.web;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@SpringBootApplication
@EnableDubboConfiguration
@EnableHystrix
public class ServerWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerWebApplication.class, args);
    }

}
