package cn.wellcare.web.controller;

import cn.wellcare.api.UserService;
import cn.wellcare.model.User;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Reference
    private UserService userService;

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable String id){

        return userService.getUser(id);
    }


}
