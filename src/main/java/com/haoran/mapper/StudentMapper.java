package com.haoran.mapper;

import com.haoran.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM student")
    List<Student> findAll();

    @Select("SELECT * FROM student WHERE NAME = #{name}")
    Student findByName(@Param("name") String name);

    @Insert("INSERT INTO student(id,name,grade) VALUES(#{id},#{name},#{grade})")
    int save(@Param("id") String id, @Param("name") String name, @Param("grade") int grade);
}