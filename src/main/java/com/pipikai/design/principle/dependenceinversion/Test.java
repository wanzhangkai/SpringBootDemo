package com.pipikai.design.principle.dependenceinversion;

import lombok.extern.slf4j.Slf4j;

/**
 * 依赖倒置原则
 * <p>
 * Created by wanzhangkai
 * 2018/11/20 9:53
 * Email: zhangkaiwan@qq.com
 */
@Slf4j
public class Test {

    //v0 不好的做法，扩展差
    private static void testV0() {
        Student student = new Student();
        student.studyJavaCourse();
        student.studyPythonCourse();
    }

    //v1
    private static void testV1() {
        Student student = new Student();
        student.studyCourse(new JavaCourse());
        student.studyCourse(new PythonCourse());
    }

    //v2
    private static void testV2() {
        Student student = new Student(new JavaCourse());
        student.studyCourse();
        Student student2 = new Student(new PythonCourse());
        student2.studyCourse();
    }

    //v3
    private static void testV3() {
        Student student = new Student();
        student.setCourse(new JavaCourse());
        student.studyCourse();
        student.setCourse(new PythonCourse());
        student.studyCourse();
    }

    public static void main(String[] args) {
//        testV0();
//        testV1();
//        testV2();
        testV3();
    }

}
