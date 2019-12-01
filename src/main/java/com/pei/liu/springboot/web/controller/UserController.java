package com.pei.liu.springboot.web.controller;

import com.pei.liu.springboot.annotation.LogAnnotation;
import com.pei.liu.springboot.model.User;
import com.pei.liu.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/user/getuser")
    public User getUser(){
      return   userService.getUserById(2);
    }


    @RequestMapping("/user/getAll")
    @LogAnnotation(operate = "查询所有")
    public Object geAlltUser(@RequestParam(name = "pageNo",required = false,defaultValue= "1")int pageNo,
                               @RequestParam(name = "pageSzie",required = false,defaultValue= "2")int pageSzie){
        return  userService.getAll(pageNo,pageSzie);
    }

    @RequestMapping("/user/save")
    public void saveUser()   {
        User user=new User();
        user.setName("大傻逼鄧强");
        user.setAge(12);
        userService.saveUser(user);
    }
}
