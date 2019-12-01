package com.pei.liu.springboot.service;

import com.github.pagehelper.PageHelper;
import com.pei.liu.springboot.annotation.AnnotationTest;
import com.pei.liu.springboot.mapper.UserMapper;
import com.pei.liu.springboot.model.User;
import com.pei.liu.springboot.utils.PagedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    @AnnotationTest
    public PagedResponse getAll(Integer pageNo, Integer pageSzie) {
        PageHelper.startPage(pageNo,pageSzie);
        List<User> users= userMapper.getAll();
        PagedResponse pagedResponse=new PagedResponse(users);
        return pagedResponse;
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveUser(User user) {
        userMapper.insert(user);
        user.setAge(null);
        userMapper.insert(user);

    }

}
