package com.bootcamp.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
    private static final long serialVersionUID = -7016650414253661656L;
    private String firstName;
    private String lastName;
    private transient String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
}

public class SerializeDemo {

    public static void main(String[] args) {
        String message = "Hello";

        try {
            Person p = new Person();
            p.setFirstName("John");
            p.setLastName("Doe");
            p.setPassword("pass123");
            
            //FileWriter fw = new FileWriter(new File("message.txt"));
            //BufferedWriter bw = new BufferedWriter(fw);
            // bw.write(message);
            // bw.flush();
            // bw.close();

//            FileOutputStream fos = new FileOutputStream(new File("object.dat"));
//            ObjectOutputStream oos = new  ObjectOutputStream(fos);
//            oos.writeObject(p);
//            oos.flush();
//            oos.close();
            
            FileInputStream fis = new FileInputStream(new File("object.dat"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person newPerson = (Person) ois.readObject();
            System.out.println(newPerson.getFirstName());
            System.out.println(newPerson.getLastName());
            System.out.println(newPerson.getPassword());
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
