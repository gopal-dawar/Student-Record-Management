package com.StudentRecordManagement.service;

import com.StudentRecordManagement.entity.Student;

import java.util.List;

public interface StudentSercvice {
    Student addNewStudent(Student student);


    List<Student> veiwAllStudent();

    Student updateById(int id, Student student);


    Student deleteById(int id);

}
