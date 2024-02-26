package com.example.Student_Application2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// @AllArgsConstructor

public class StudentDataModel {
    public String id;
    public String name;
    public String university;
    public String aadhaar;
    public Integer age;

    public StudentDataModel(String id, String name, String university, String aadhaar, Integer age) {
        this.id = id;
        this.name = name;
        this.university = university;
        this.aadhaar = aadhaar;
        this.age = age;
    }
}
