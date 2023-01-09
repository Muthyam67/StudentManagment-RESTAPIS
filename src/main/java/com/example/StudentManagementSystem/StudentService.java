package com.example.StudentManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student){
        return studentRepository.addStudentToDb(student);

    }

    public Student getStudentById(int id) {
        return studentRepository.getStudentFromDb(id);
    }

    public Student getStudentByPathId(int id) {
        return studentRepository.getStudentFromDb(id);
    }

    public Student getStudentByName(String name) {
        return studentRepository.getSTudentByNameFromDb(name);
    }

    public boolean update(Student student) {
        return studentRepository.updateStudentInDb(student);

    }

    public String deleteStudent(int id) {
        return studentRepository.deleteStudentFromDb(id);
    }


}
