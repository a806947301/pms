package com.dayi.demo.controller;

import com.dayi.demo.student.model.Student;
import com.dayi.demo.student.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 *
 * 学生模块控制器
 * @author chenzhaoju
 */
@Controller
@RequestMapping("/student")
public class StudentControler {

    @Resource
    private StudentService studentService;

    /**
     *
     * @param request
     * @param id
     * @return
     *
     * .
     */
    @RequestMapping("/getstudent/{id}")
    @ResponseBody
    public Student getStudent(HttpServletRequest request ,@PathVariable int id){
        return studentService.getStudent(id);
    }

    /**
     * 添加学生信息
     * @param request
     * @return
     */
    @RequestMapping("/addstudent")
    @ResponseBody
    public Student addStudent(HttpServletRequest request){
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        Student student = new Student(name).setAge(age);
        studentService.addStudent(student);
        return student;
    }

    /**
     * 更新学生信息
     * @param request
     * @return
     */
    @RequestMapping("/updatestudent/{id}")
    @ResponseBody
    public Student updateStudent(HttpServletRequest request,@PathVariable int id){
        Student student = studentService.getStudent(id);
        if(null != student){
            int age = Integer.parseInt(request.getParameter("age"));
            student.setAge(age).setUpdateTime(new Date());
            studentService.updateStudent(student);
        }
        return student;
    }

    /**
     * 分页查找学生数据
     * @param request
     * @return
     */
    @RequestMapping("/findstudent")
    @ResponseBody
    public Page<Student> findStudent(HttpServletRequest request){
        Page<Student> page = PageHelper.startPage(1, 10);
        page = studentService.findStudent(page);
        return page;
    }

    @RequestMapping("/index")
    public String getIndex(HttpServletRequest request)
    {
        return "index";
    }

    @RequestMapping("/demo")
    public String demo() {return "demo";};
}
