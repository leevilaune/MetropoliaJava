package com.leevilaune.streams.enrollment;

import java.io.*;

public class Main {
    private final static String FILENAME = "enrollment.ser";
    public static void main(String[] args){

        File f = new File(FILENAME);

        if(f.exists() && f.isFile()){
            try(
                FileInputStream inputstream = new FileInputStream(FILENAME);
                ObjectInputStream objects = new ObjectInputStream(inputstream);
            ){
                Enrollment e = (Enrollment) objects.readObject();
                System.out.println(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{
            try(
                FileOutputStream outputstream = new FileOutputStream(FILENAME);
                ObjectOutputStream objects = new ObjectOutputStream(outputstream);
            ){
                Student student = new Student(1, "Alice Johnson", 20);
                Course course = new Course("CS101", "Introduction to Computer Science", "Dr. Smith");
                Enrollment enrollment = new Enrollment(student, course, "2025-08-25");
                objects.writeObject(enrollment);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
