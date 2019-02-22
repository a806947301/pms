package com.dayi.demo.student.dao;

import com.dayi.demo.student.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenzhaoju
 */
@Repository
public interface StudentDao {

    int add(Student student);

    int update(Student student);

    Student get(int id);

    List<Student> findAll();
}
