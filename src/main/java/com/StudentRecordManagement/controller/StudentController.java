package com.StudentRecordManagement.controller;


import com.StudentRecordManagement.entity.Student;
import com.StudentRecordManagement.service.StudentSercvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentSercvice studentSercvice;


    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentSercvice.addNewStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/view")
    public ResponseEntity<List<Student>> viewStudents() {
        return new ResponseEntity<>(studentSercvice.veiwAllStudent(), HttpStatus.FOUND);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudentData(@PathVariable int id, @RequestBody Student student) {
        return new ResponseEntity<>(studentSercvice.updateById(id, student), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteData(@PathVariable int id) {
        return new ResponseEntity<>(studentSercvice.deleteById(id), HttpStatus.FOUND);
    }


}
