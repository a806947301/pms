package com.dayi.demo.student.service.impl;

import com.dayi.demo.student.dao.StudentDao;
import com.dayi.demo.student.model.Student;
import com.dayi.demo.student.service.StudentService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
 * @author chenzhaoju
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Student getStudent(int id) {
        return studentDao.get(id);
    }

    @Override
    public void addStudent(Student student) {
        studentDao.add(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    @Override
    public Page<Student> findStudent(Page<Student> page) {
        studentDao.findAll();
        return page;
    }
}
