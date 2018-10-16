//package com.pipikai.service;
//
//import com.pipikai.dao.TestDao;
//import com.pipikai.domain.TestObject;
//import com.pipikai.enums.HttpResultEnum;
//import com.pipikai.exception.TestException;
//import com.pipikai.repository.TestRepository;
//import com.pipikai.utils.HttpResultUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class TestService {
//
//    @Autowired
//    TestRepository testRepository;
//
//    @Autowired
//    TestDao testDao;
//
//    public Object getTest(Integer id) throws Exception {
//        Optional<TestObject> test = testRepository.findById(id);
//        Integer age = test.get().getAge();
//        if (age < 10) {
//            throw new TestException(HttpResultEnum.TOO_YOUNG);
//        } else if (age >= 10 && age < 18) {
//            throw new TestException(HttpResultEnum.YOUNG);
//        } else {
//            return HttpResultUtil.success(test.get());
//        }
//    }
//
//    public TestObject findOne(Integer id) {
//        return testDao.getTestObject(id);
//    }
//
//}
//
