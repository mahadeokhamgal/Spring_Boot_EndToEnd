package com.mahadeo.demo.Contoller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahadeo.demo.Entity.User;
import com.mahadeo.demo.service.EntryService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@RestController
@RequestMapping("/api/users")
public class EntryController {

    private EntryService entryService;

    public EntryController(EntryService entryService) {
        System.out.println("EntryController created");
        this.entryService = entryService;
    }

    @GetMapping
    public List<User> getUsers() {
        List<User> entries = this.entryService.getEntries();
        System.out.println(entries);

        return entries;
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable ObjectId id) {
        return this.entryService.getEntry(id);
    }

    @PostMapping
    public boolean addUser(@RequestBody User user) {
        user.setDate(LocalDate.now());
        this.entryService.addEntry(user);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable ObjectId id) {
        this.entryService.deleteEntry(id);
        return true;
    }

    @PutMapping("/{id}")
    public boolean updateUser(@PathVariable int id, @RequestBody User user) {
        this.entryService.updateEntry(user);
        return true;
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean Initialized for EntryController!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean Destroyed for EntryController!");
    }
}
