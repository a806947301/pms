package com.dayi.demo.student.service;

import com.dayi.demo.student.model.Student;
import com.github.pagehelper.Page;

/**
 *
 * 学生模块业务接口
 *
 * @author chenzhaoju
 */
public interface StudentService {

    /**
     * 根据id 获取学生对象
     * @param id
     * @return
     */
    public Student getStudent(int id);

    /**
     * 添加一个新的用户
     * @param student
     */
    public void addStudent(Student student);

    /**
     * 更新学生信息
     * @param student
     */
    public void updateStudent(Student student);

    /**
     * 分页查找学生数据
     * @param page
     */
    public Page<Student> findStudent(Page<Student> page);
}
