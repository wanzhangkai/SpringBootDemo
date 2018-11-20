package com.pipikai.design.principle.dependenceinversion;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by wanzhangkai
 * 2018/11/20 9:57
 * Email: zhangkaiwan@qq.com
 */
@Slf4j
public class JavaCourse implements Course {

    @Override
    public void studyCourse() {
        log.info("study JavaCourse...");
    }
}
