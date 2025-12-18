package com.example.Student.management.app;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer, Student> studentDB = new HashMap<>();
    Map<Integer, Teacher> teacherDB = new HashMap<>();
    Map<Integer, List<Integer>> teacherStudentsDB = new HashMap<>();


    public Student getStudent(int admNo){
        return studentDB.get(admNo);
    }

    public Student getStudentByPathVariable(int admNo) {
        return  studentDB.get(admNo);
    }

    public void addStudent(Student student) {
                studentDB.put(student.getAdmNo(), student);
    }

    public void addTeacher(Teacher teacher) {
        teacherDB.put(teacher.getId(),teacher);
    }

    public Teacher getTeacherByName(String name) {
        for(Integer teacherId: teacherDB.keySet()){
            if(teacherDB.get(teacherId).getName().equals(name)){
                return teacherDB.get(teacherId);
            }
        }
        return null;
    }

    public List<String> getAllStudents() {
        List<String> students = new ArrayList<>();
        for(Integer id : studentDB.keySet()){
            students.add(studentDB.get(id).getName());
        }
        return  students;
    }

    public void deleteByTeacherName(String teachername) {

        int teacherId = -1;
        for(Integer id : teacherDB.keySet()){
            if(teacherDB.get(id).getName().equals(teachername)){
                teacherId = id;
                break;
            }
        }
        if(teacherId != -1){
            teacherDB.remove(teacherId);
            teacherStudentsDB.remove(teacherId);
        }
    }

    public void addStudentTeacherPair(Integer studentid, Integer teacherid) {

        if(studentDB.containsKey(studentid) && teacherDB.containsKey(teacherid)){
            if(!teacherStudentsDB.containsKey(teacherid)){
                teacherStudentsDB.put(teacherid, new ArrayList<>());
            }
            teacherStudentsDB.get(teacherid).add(studentid);

        }
    }

    public List<String> getStudentByTeacherId(Integer teacherId) {
        List<Integer> studentsIds = teacherStudentsDB.get(teacherId);
        List<String > students = new ArrayList<>();
        if(studentsIds!=null) {
            for (int studentId : studentsIds) {
                students.add(studentDB.get(studentId).getName());
            }
        }
        return students;
    }
}
