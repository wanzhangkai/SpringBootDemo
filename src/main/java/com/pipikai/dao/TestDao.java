package com.pipikai.dao;

import com.pipikai.domain.TestObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestDao {

    @Select("select * from test where id=#{id}")
    TestObject getTestObject(Integer id);

}
