package com.api.student.reststudent.Services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.student.reststudent.Model.Student;
import com.api.student.reststudent.Model.StudentRepo;

@Component
public class StudentService {

    @Autowired
    StudentRepo studentrepo;

    public List<Student> getAllStudents()
    {
        return studentrepo.findAll();
    }

    public Student getStudentbyId( String id)
    {
        Student stu = null;
        try {
            stu = studentrepo.findAll().stream().filter(item -> item.getId().equals(id)).collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stu;
    }

    public void addStudent( Student stu)
    {
        studentrepo.save(stu);
        System.out.println("new student added with following deatils : \n"+stu.toString());
    }

    public void deleteStudentbyId(String id)
    {
        studentrepo.deleteById(id);
        System.out.println("student with id :"+id+" is deleated");
    }

    public void updateStudent(String id , Student changestu)
    {
        List<Student> list = studentrepo.findAll().stream().map(stu ->{
            if(Objects.equals(stu.getId(), id))
            {
                stu.setBranch(changestu.getBranch());
                stu.setName(changestu.getName());
                stu.setCgpa(changestu.getCgpa());
            }
            return stu;
        }).collect(Collectors.toList());
        studentrepo.saveAll(list);
        System.out.println("student with id :"+id+" is updated");

    }


    
}



