package com.pipikai.imooc.design.principle.dependenceinversion;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by wanzhangkai
 * 2018/11/20 9:54
 * Email: zhangkaiwan@qq.com
 */
@Slf4j
public class Student {

    private Course course;

    public Student() {

    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student(Course course) {
        this.course = course;
    }

    public void studyCourse() {
        this.course.studyCourse();
    }

    public void studyCourse(Course course) {
        course.studyCourse();
    }

    public void studyJavaCourse(){
        log.info("study JavaCourse...");
    }

    public void studyPythonCourse(){
        log.info("study PythonCourse...");
    }

}
