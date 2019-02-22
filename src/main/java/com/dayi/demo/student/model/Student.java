package com.dayi.demo.student.model;

import java.util.Date;

/**
 *
 * 学生
 * @author chenzhaoju
 */
public class Student {
    /** id */
    private int id;
    /** 名字 */
    private String name;
    /** 年龄 */
    private int age;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

    protected Student() {}

    public Student(String name) {
        this.name = name;
        Date date = new Date();
        this.createTime = date;
        this.updateTime = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Student setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public Student setId(int id) {
        this.id = id;
        return this;
    }
}
