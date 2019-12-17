package com.pei.liu.springboot.service;

import com.pei.liu.springboot.entity.ClassInfo;
import com.pei.liu.springboot.mapper.ClassInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-17 13:46
 * @version: 1.0$
 */
@Service
public class ClassInfoServcie {

    @Autowired
    private ClassInfoMapper classInfoMapper;

    public ClassInfo getClassInfoByid(Integer id) {
        return  classInfoMapper.getClassInfoMap(id);
    }

    public ClassInfo getClassInfoByid2(Integer id) {
        return  classInfoMapper.getClassInfoMap2(id);
    }



}
