package com.api.student.reststudent.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.student.reststudent.Model.Student;
import com.api.student.reststudent.Model.StudentRepo;

@Component
public class StudentService {

    @Autowired
    StudentRepo studentrepo;

    private static List<Student> list = new ArrayList<>();
    static{

        list.add(new Student(2,"Shreeya Suman", 12, "C"));
        list.add(new Student(3,"Raj Singh", 12, "A"));
        list.add(new Student(4,"Rishabh Jain", 12, "B"));

    }

    public List<Student> getAllStudents()
    {
        // return list;
        return studentrepo.findAll();

    }

    public Student getStudentbyrollno( Integer rollno)
    {
        Student stu = null;
        try {
            stu = list.stream().filter(item -> item.getRollno().equals(rollno)).collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return stu;
    }

    public void addStudent( Student stu)
    {
        studentrepo.save(stu);
        // list.add(stu);
    }

    public void deleteStudent(Integer rollno)
    {
        list = list.stream().filter(stu -> stu.getRollno()!=rollno).collect(Collectors.toList());
    }

    public void updateStudent(Integer rollno, Student changestu)
    {
        list = list.stream().map(stu ->{
            if(stu.getRollno()==rollno)
            {
                stu.setClassno(changestu.getClassno());
                stu.setName(changestu.getName());
                stu.setSection(changestu.getSection());
            }
            return stu;
        }).collect(Collectors.toList());
    }


    
}