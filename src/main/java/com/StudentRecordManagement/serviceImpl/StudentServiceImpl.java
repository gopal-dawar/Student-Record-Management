package com.StudentRecordManagement.serviceImpl;

import com.StudentRecordManagement.entity.Student;
import com.StudentRecordManagement.repository.StudentRepository;
import com.StudentRecordManagement.service.StudentSercvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentSercvice {



    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> veiwAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateById(int id, Student student) {
        Student s = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Wrong Input id"));
        s.setName(student.getName());
        s.setEmail(student.getEmail());
        s.setCourse(student.getCourse());
        s.setMarks(student.getMarks());
        return studentRepository.save(s);
    }

    @Override
    public Student deleteById(int id) {
        Student s = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Wrong Input id"));
        studentRepository.delete(s);
        return s;
    }

}
