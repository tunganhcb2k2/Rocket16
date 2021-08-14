package com.backend;

import com.entity.EX4.Car;

import java.io.*;

public class Exercise4 {
    public void readFile(String filePath) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        File pathFile = new File(filePath);
        if (!pathFile.exists()) {
            throw new Exception("Error!");
        } else {
            byte[] b = new byte[1024];
            int length = fileInputStream.read(b);
            System.out.println("Do dai: " + length);
            while (length > -1) {
                String content = new String(b, 0, length);
                System.out.println(content);
                System.out.println("----------------------");
                length = fileInputStream.read(b);
            }
            fileInputStream.close();
        }
    }

    public void writeFile(String filePath, boolean isContinuing, String content) throws Exception {
        File pathFile = new File(filePath);
        if (!pathFile.exists()) {
            throw new Exception("Error!");
        } else {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath, isContinuing);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();

        }
    }

    public void writeObj(Object object, String diaChi) throws Exception {
        File pathFile = new File(diaChi);
        if (object == null) {
            throw new Exception("Error!");
        }
        FileOutputStream out = new FileOutputStream(diaChi);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject(object);
        out.close();
        objectOutputStream.close();
        System.out.println("Write success!");
    }

    public void readObj(String diaChi) throws Exception {
        File pathFile = new File(diaChi);
        if(!pathFile.exists()){
            throw new Exception("Error!");
        }
        FileInputStream fileInputStream = new FileInputStream(diaChi);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object obj = objectInputStream.readObject();

        objectInputStream.close();

        Car lamboghini = (Car) obj;
        System.out.println(lamboghini.getName());
        System.out.println(lamboghini.getColor());
        System.out.println(lamboghini.getBrand());
    }
}