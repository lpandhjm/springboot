package com.pei.liu.springboot.mapper;

import com.pei.liu.springboot.entity.ClassInfo;

public interface ClassInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    ClassInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);



    ClassInfo getClassInfoMap(Integer id);
    ClassInfo getClassInfoMap2(Integer id);
}