package com.pipikai.simplydemo;

import com.pipikai.pojo.TestObject;

import java.io.*;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/10/7 11:03
 */
public class ObjectStreamDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String file = "demo/obj.dat";  //项目内路径
        String file1 = "D://demo/obj.dat";  //本地绝对路径
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file)
        );
        TestObject testObject = new TestObject();
        testObject.setAge(20);
        testObject.setCupSize("C");
        testObject.setMoney(20.0);
        testObject.setName("wan");
        testObject.setId(1);
        oos.writeObject(testObject);
        oos.flush();
        oos.close();
        
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file)
        );
        TestObject to = (TestObject) ois.readObject();
        System.out.println(to);
    }

}