package com.example.Student.management.app;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {

    StudentRepository studentRepository = new StudentRepository();

    public Student getStudent(int admNo){
        return studentRepository.getStudent(admNo);
    }


    public Student getStudentByPathVariable(int admNo) {
        return studentRepository.getStudentByPathVariable(admNo);
    }

    public String addStudent(Student student) {
        studentRepository.addStudent(student);
        return  "Student added Successfully";
    }

    public String addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
        return "Teacher added Successfully";
    }

    public Teacher getTeacherByName(String name) {
        return studentRepository.getTeacherByName(name);
    }

    public List<String> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teachername) {
        studentRepository.deleteByTeacherName(teachername);
    }

    public void addStudentTeacherPair(Integer studentId, Integer teacherId) {
        studentRepository.addStudentTeacherPair(studentId, teacherId);
    }

    public List<String> getStudentByTeacherId(Integer teacherId) {
       return studentRepository.getStudentByTeacherId(teacherId);
    }
}

