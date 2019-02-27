package com.haoran.mapper;

import com.haoran.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM student")
    List<Student> findAll();
}