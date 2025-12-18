package com.example.Student.management.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;


    @GetMapping("/get-student")
    public ResponseEntity<Student> getStudent(@RequestParam("id") int admNo){
        Student student =  studentService.getStudent(admNo);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @GetMapping("/get-student-by-path/{id}")
    public ResponseEntity<Student> getStudentByPathVariable(@PathVariable("id") int admNo){
        Student student = studentService.getStudentByPathVariable(admNo);
        return new ResponseEntity(student,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        String message =  studentService.addStudent(student);
        return new ResponseEntity(message, HttpStatus.CREATED);

    }
    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher (@RequestBody Teacher teacher){
        String message = studentService.addTeacher(teacher);
        return new ResponseEntity(message,HttpStatus.CREATED);
    }
    @GetMapping("/get-teacher-by-name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable ("name")  String name){
        Teacher teacher = studentService.getTeacherByName(name);
        return new ResponseEntity(teacher,HttpStatus.FOUND);
    }
    @GetMapping("/get-all-students")
    public ResponseEntity<List<String>> getAllStudents(){
        List<String> students = studentService.getAllStudents();
        return new ResponseEntity<>(students,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam ("name") String teachername){
        studentService.deleteTeacherByName(teachername);
        return new ResponseEntity<>("Teacher deleted successfully",HttpStatus.ACCEPTED);
    }
    @PutMapping("/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam Integer studentid,
                                                        @RequestParam Integer teacherid){
        studentService.addStudentTeacherPair(studentid,teacherid);
        return new ResponseEntity<>("student teacher pair added", HttpStatus.ACCEPTED);

    }
    @GetMapping("/get-students-by-teacher-id/{teacherId}")
    public ResponseEntity<List<String>> getStudentByTeacherId(@PathVariable Integer teacherId){
     List<String> students =  studentService.getStudentByTeacherId(teacherId);
     return new ResponseEntity<>(students,HttpStatus.FOUND);
    }
}
