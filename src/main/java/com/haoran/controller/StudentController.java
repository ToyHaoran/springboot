package com.haoran.controller;

import com.haoran.mapper.StudentMapper;
import com.haoran.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Student 控制器
 */
/*
@Controller和@RestController的用法小结
@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。

1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，
配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
例如：本来应该到index.jsp页面的，则其显示index.
2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。

而在@RestController中，返回的应该是一个对象，即return一个Student对象，这时，在没有页面的情况下，
也能看到返回的是一个Student对象对应的json字符串，而前端的作用是利用返回的json进行解析渲染页面，java后端的代码比较自由。
见com.haoran.HelloController
 */
@Controller
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    /*
    在@Controller注解中，返回的是字符串（如果想返回string或者json，在方法名前加上ResponseBody），
        或者是字符串匹配的模板名称，与html页面配合使用的，
    在这种情况下，前后端的配合要求比较高，java后端的代码要结合html的情况进行渲染,
    使用model对象（或者modelandview）的数据将填充list视图中的相关属性，然后展示到浏览器。
     */
    @RequestMapping("/listStudent")
    public String listStudent(Model model) {
        List<Student> students = studentMapper.findAll();
        model.addAttribute("students", students);
        //返回到前端界面
        return "student/list";
    }

    @RequestMapping("/saveStudent")
    public void save() {
        studentMapper.save("345", "lihaoran", 77);
    }

    @RequestMapping("/findByName")
    public Student findByName(String name) {
        //如果不注释mvc，会转到/WEB-INF/views/findByName.jsp
        return studentMapper.findByName(name);
    }
}