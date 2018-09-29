package com.pipikai;

import com.pipikai.domain.TestObject;
import com.pipikai.service.TestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试service
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTest {

    @Autowired
    private TestService testService;

    @Test
    public void findOneTest() throws Exception {
        TestObject testObject = testService.findOne(5);
        Assert.assertEquals(new Integer(30), testObject.getAge());
    }

}
