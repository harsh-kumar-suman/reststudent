package com.api.student.reststudent.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "StudentDetail")
public class Student {

    private Integer rollno;
    private String name;
    private Integer classno;
    private String section;


    public Student(Integer rollno, String name, Integer classno, String section) {
        this.rollno = rollno;
        this.name = name;
        this.classno = classno;
        this.section = section;
    }

    public Integer getRollno() {
        return this.rollno;
    }

    public void setRollno(Integer rollno) {
        this.rollno = rollno;
    }

    @Override
    public String toString() {
        return "{" +
            " rollno='" + getRollno() + "'" +
            ", name='" + getName() + "'" +
            ", classno='" + getClassno() + "'" +
            ", section='" + getSection() + "'" +
            "}";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClassno() {
        return this.classno;
    }

    public void setClassno(Integer classno) {
        this.classno = classno;
    }

    public String getSection() {
        return this.section;
    }

    public void setSection(String section) {
        this.section = section;
    }
    
    
}