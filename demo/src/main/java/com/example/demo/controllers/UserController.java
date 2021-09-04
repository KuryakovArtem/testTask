package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-server")
public class UserController {
    @GetMapping("/")
    public ResponseEntity getUsers()
    {
        try {
            return ResponseEntity.ok("Server is online");
        } catch (Exception e)
        {
            return ResponseEntity.badRequest().body("Teapot");
        }
    }
}
