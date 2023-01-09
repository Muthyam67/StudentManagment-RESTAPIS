package com.example.StudentManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class StudentController {


   @Autowired
   StudentService studentService;
    //add student
    @PostMapping("/add_student")

    public ResponseEntity<String> addStudent(@RequestBody() Student student){
       String response=studentService.addStudent(student);
       return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    //get student data by id
    @GetMapping("/get_student_by_id")
    public ResponseEntity<Student> getStudentById(@RequestParam("id") int id){
        Student result=studentService.getStudentById(id);
        if(result==null)
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        else
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //get By path
    @GetMapping("/get_by_path/{id}")
    public ResponseEntity<Student> getStudentByPath(@PathVariable("id") int id){
        Student result=studentService.getStudentByPathId(id);
        if(result==null)
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //get student data by name

    @GetMapping("/get_student_by_name")
    public ResponseEntity<Student> getStudentByName(@RequestParam("name") String name){
        Student result=studentService.getStudentByName(name);
        if(result==null)
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(result, HttpStatus.OK);

    }

    //updating the data
    @PutMapping("/update_student_data")
    public ResponseEntity<String> updateStudent(@RequestBody() Student student){
        boolean result=studentService.update(student);
        if(result==false) {
            return new ResponseEntity<>("student Details Not Present",HttpStatus.BAD_REQUEST);
        }
        else
        return new ResponseEntity<>("student details Updated Successfully",HttpStatus.OK);
    }

    //delete student
    @DeleteMapping("/delete_student")
    public ResponseEntity<String> deleteStudent(@RequestParam("id") int id){
        String result=studentService.deleteStudent(id);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
