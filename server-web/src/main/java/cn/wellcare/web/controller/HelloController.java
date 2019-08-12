package cn.wellcare.web.controller;

import cn.wellcare.api.HelloService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private Logger log = Logger.getLogger(this.getClass());

    @Reference
    private HelloService helloService;

    @GetMapping("/hello/{name}")
    @HystrixCommand(fallbackMethod = "doSayHello")
    public String sayHello(@PathVariable String name){

        return helloService.sayHello(name);
    }

    public String doSayHello(String name){
        log.debug("doSayHello --> hystrix fallback value");
        return "hystrix fallback value";
    }
}
