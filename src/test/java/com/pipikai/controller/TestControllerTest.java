package com.pipikai.controller;//package com.pipikai.controller;
//
//import com.pipikai.domain.TestObject;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class TestControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//
//    @Test
//    public void getTestList() throws Exception {
//        TestObject testObject = new TestObject() {{
//            setAge(30);
//            setCupSize("D");
//            setName("wanz");
//            setMoney(12.2);
//        }};
//        Map a = new HashMap();
//        a.put("name","wan");
//        // TODO: 2018/9/29 0029 post
//        mvc.perform(MockMvcRequestBuilders.post("http://localhost:8082/test/setTest",a))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void getTest() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("http://localhost:8082/test/findOne/1"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//}