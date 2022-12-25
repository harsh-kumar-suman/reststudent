package com.api.student.reststudent.Model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, String>
{
    
}

