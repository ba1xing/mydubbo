package cn.wellcare.provider.service;

import cn.wellcare.api.HelloService;
import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

@Service(interfaceClass = HelloService.class)
@Component
public class HelloServiceImpl implements HelloService {

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") })
    @Override
    public String sayHello(String name) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello," + name;
        //throw new RuntimeException("Exception to show hystrix enabled.");
    }
}
