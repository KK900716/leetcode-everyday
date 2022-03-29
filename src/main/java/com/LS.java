package com;

import java.io.*;

public class LS {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        fun2();
    }

    private static void fun2() throws IOException, ClassNotFoundException {
        Test2 test2=null;
        FileInputStream fileInputStream=new FileInputStream(new File("abc.ser"));
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        test2 = (Test2) objectInputStream.readObject();
        test2.test();
    }

    private static void fun1() throws IOException {
        Test2 test2=new Test2();
        File file=new File("abc.ser");
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        ObjectOutputStream objectOutput=new ObjectOutputStream(fileOutputStream);
        objectOutput.writeObject(test2);
        objectOutput.close();
        fileOutputStream.close();
    }
}
