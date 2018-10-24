package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoController {
    private static final String VERSION = "1.0";

    private final UserService userService;

    @Autowired
    public DemoController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/version")
    public Map getVersion() {
        return new HashMap<String, String>() {{
            put("version", VERSION);
        }};
    }

    @RequestMapping("/user/{id}")
    public User getUserInfo(@PathVariable(value = "id") Integer id) {
        return userService.getUserById(id);
    }
}
