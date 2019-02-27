package com.haoran.controller;

import com.haoran.mapper.StudentMapper;
import com.haoran.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Student 控制器
 */
//@Controller  todo 这两个有什么区别？
@RestController
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    /*@RequestMapping("/listStudent")
    public String listStudent(Model model) {
        List<Student> students = studentMapper.findAll();
        model.addAttribute("students", students);
        return "listStudent";
    }*/

    @RequestMapping("/saveStudent")
    public void save() {
        studentMapper.save("345", "lihaoran", 77);
    }

    @RequestMapping("/findByName")
    public Student findByName(String name) {
        //如果不配置页面会转到/WEB-INF/views/findByName.jsp
        return studentMapper.findByName(name);
    }
}