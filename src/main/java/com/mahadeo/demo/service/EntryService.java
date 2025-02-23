package com.mahadeo.demo.service;

import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
    HashMap<Integer, User> entries;
    
    public EntryService() {
        System.out.println("EntryService created");
        this.entries = new HashMap<>();
        this.entries.put(1, new User(1, "John", "john.mendes@email.com"));
    }

    public void addEntry(User user) {
        this.entries.put(user.getId(), user);
    }

    public User getEntry(int id) {
        return this.entries.get(id);
    }

    public HashMap<Integer, User> getEntries() {
        return this.entries;
    }

    public void deleteEntry(int id) {
        this.entries.remove(id);
    }

}
