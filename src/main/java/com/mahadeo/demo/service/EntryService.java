package com.mahadeo.demo.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahadeo.demo.Entity.User;
import com.mahadeo.demo.repository.UserRepository;

@Service
public class EntryService {

    @Autowired
    UserRepository userRepository;
    
    public EntryService() {
        System.out.println("EntryService created");
    }

    public void addEntry(User user) {
        this.userRepository.save(user);
    }

    public void updateEntry(User user) {
        this.userRepository.save(user);
    }

    public Optional<User> getEntry(ObjectId id) {
        return this.userRepository.findById(id);
    }

    public List<User> getEntries() {
        return this.userRepository.findAll();
    }

    public void deleteEntry(ObjectId id) {
        this.userRepository.deleteById(id);
    }

}
