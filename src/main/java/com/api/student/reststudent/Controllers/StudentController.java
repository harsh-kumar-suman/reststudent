package com.api.student.reststudent.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.student.reststudent.Model.Student;
import com.api.student.reststudent.Services.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    @ResponseBody
    public ResponseEntity<List<Student>> getStudents()
    {
        List<Student>list = this.studentService.getAllStudents();
        
        // if(list.size() <= 0)
        //     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        return ResponseEntity.of(Optional.of(list));

    } 

    @GetMapping("/students/{rollno}")
    @ResponseBody
    public ResponseEntity<Student> getStudent(@PathVariable("rollno") Integer rollno)
    {
        Student stu = this.studentService.getStudentbyrollno(rollno);
        
        
        if(stu == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.of(Optional.of(stu));
    }
// hh
    @PostMapping("/students")
    @ResponseBody
    public ResponseEntity<Void> addStudent(@RequestBody Student stu)
    {
        try {
            this.studentService.addStudent(stu);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    @DeleteMapping("students/{rollno}")
    @ResponseBody
    public void deleteStudent(@PathVariable("rollno") Integer rollno)
    {
        this.studentService.deleteStudent((rollno));
    }

    @PutMapping("students/{rollno}")
    @ResponseBody
    public void updateStudent(@PathVariable("rollno") Integer rollno, @RequestBody Student stu)
    {
        this.studentService.updateStudent(rollno, stu);
    }
    
}