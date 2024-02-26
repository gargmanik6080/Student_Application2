package com.example.Student_Application2.resource;

import com.example.Student_Application2.model.StudentDataModel;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")

public class Student {

    final public Map<String, StudentDataModel> idToStudent = new HashMap<>();
    final public Map<String, List<StudentDataModel>> universityToStudents = new HashMap<>();

    @GetMapping
    public List<StudentDataModel> getAllStudents(){
        List<StudentDataModel> studentsList = new ArrayList<>();
        for (StudentDataModel student : idToStudent.values()) {
            studentsList.add(student);
        }
        if (studentsList.isEmpty()) {
            throw new RuntimeException("No students found");
        }
        return studentsList;
    }
    
    @PostMapping("/addStudent")
    // public String addStudent(@RequestBody String name,
    //                          @RequestBody String university,
    //                          @RequestBody String aadhaar,
    //                          @RequestBody Integer age){

    public String addStudent(@RequestBody com.example.Student_Application2.model.StudentDataModel student){
        String id = UUID.randomUUID().toString();
        // StudentDataModel student = new StudentDataModel(id, name, university, aadhaar, age);
        student.id = id;
        idToStudent.put(id, student);

        List<StudentDataModel> students = universityToStudents.getOrDefault(student.university, new ArrayList<>());
        students.add(student);
        universityToStudents.put(student.university, students);

        return id;
    }

    @GetMapping("/getStudentsByUniversity/{university}")
    public List<StudentDataModel> getStudentsByUniversity(@PathVariable String university){
        return universityToStudents.getOrDefault(university, null);
    }

    @GetMapping("/getStudentByID/{id}")
    public StudentDataModel getStudentByID(@PathVariable String id){
        return idToStudent.getOrDefault(id, null);
    }
}
