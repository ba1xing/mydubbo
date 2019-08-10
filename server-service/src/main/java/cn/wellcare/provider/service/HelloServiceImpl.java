package cn.wellcare.provider.service;

import cn.wellcare.api.HelloService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service(interfaceClass = HelloService.class)
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "hello," + name;
    }
}
