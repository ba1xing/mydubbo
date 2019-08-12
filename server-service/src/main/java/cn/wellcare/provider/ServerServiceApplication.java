package cn.wellcare.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@SpringBootApplication
@EnableDubboConfiguration
@MapperScan("cn.wellcare.provider.mapper")
@EnableHystrix
public class ServerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerServiceApplication.class, args);
    }

}

