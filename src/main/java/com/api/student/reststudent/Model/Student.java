package com.api.student.reststudent.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "StudentDetail")
public class Student {

    @Id
    private String id;
    private String name;
    private String branch;
    private Float cgpa;

    
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", branch=" + branch + ", cgpa=" + cgpa + "]";
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public Float getCgpa() {
        return cgpa;
    }
    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    

}