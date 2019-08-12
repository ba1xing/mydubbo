package cn.wellcare.provider.service;

import cn.wellcare.api.UserService;
import cn.wellcare.model.User;
import cn.wellcare.provider.mapper.UserDao;
import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") })
    @Override
    public User getUser(String id) {
        return (User) userDao.get(Integer.parseInt(id));
    }

}
