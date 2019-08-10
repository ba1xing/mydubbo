package cn.wellcare.provider.service;

import cn.wellcare.api.UserService;
import cn.wellcare.model.User;
import cn.wellcare.provider.mapper.UserDao;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUser(String id) {
        return (User) userDao.get(Integer.parseInt(id));
    }
}
