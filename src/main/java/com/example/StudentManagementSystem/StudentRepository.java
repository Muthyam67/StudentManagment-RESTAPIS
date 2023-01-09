package com.example.StudentManagementSystem;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class StudentRepository {
    HashMap<Integer,Student> studentDb=new HashMap<>();
    public String addStudentToDb(Student student){
        int key=student.id;
        studentDb.put(key,student);
        return "student successfully added";
    }

    public Student getStudentFromDb(int id) {
        if(studentDb.containsKey(id))
            return studentDb.get(id);
        else
            return null;
    }

    public Student getSTudentByNameFromDb(String name) {
        for(Student s :studentDb.values()){
            if(s.name.equals(name))
                return s;
        }
        return null;
    }

    public boolean updateStudentInDb(Student student) {
        int key=student.id;
        if(!studentDb.containsKey(key))
            return false;
        else{
            studentDb.put(key,student);
            return true;
        }

    }

    public String deleteStudentFromDb(int id) {
        int key=id;
        if(!studentDb.containsKey(key))
            return "not a student";
        else{
            studentDb.remove(key);
            return "deleted student details";
        }
    }
}
