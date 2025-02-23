package com.mahadeo.demo.Contoller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahadeo.demo.service.EntryService;
import com.mahadeo.demo.service.User;

@RestController
@RequestMapping("/api")
public class EntryController {

    private EntryService entryService;

    public EntryController(EntryService entryService) {
        System.out.println("EntryController created");
        this.entryService = entryService;
    }

    @GetMapping("/Users")
    public String getUsers() {
        Map<Integer, User> entries = this.entryService.getEntries();
        for (Map.Entry<Integer, User> entry : entries.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue().getId() + " " + entry.getValue().getName() + " " + entry.getValue().getEmail());
        }



        return "This is a list of users";
    }
}
