package com.pei.liu.springboot.controller;

import com.pei.liu.springboot.entity.ClassInfo;
import com.pei.liu.springboot.service.ClassInfoServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-17 13:49
 * @version: 1.0$
 */
@RestController
public class ClassInfoController {

    @Autowired
    private ClassInfoServcie classInfoServcie;

    @RequestMapping("getClassInfo")
    public ClassInfo getClassInfo(Integer id) {
        return  classInfoServcie.getClassInfoByid(id);
    }
    @RequestMapping("getClassInfo2")
    public ClassInfo getClassInfo2(Integer id) {
        return  classInfoServcie.getClassInfoByid2(id);
    }

}
