package com.mahadeo.demo.repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mahadeo.demo.Entity.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    
}
