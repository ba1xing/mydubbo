package cn.wellcare.web.controller;

import cn.wellcare.api.HelloService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference
    private HelloService helloService;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name){

        return helloService.sayHello(name);
    }
}
