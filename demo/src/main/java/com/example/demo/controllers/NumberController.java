package com.example.demo.controllers;

import com.example.demo.entities.Number;
import com.example.demo.repos.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class NumberController {
    @Autowired
    private NumberRepository numberRepository;

    @GetMapping( path = "/integer")
    public String getInteger(Long numberId, Model model){
        if (numberId!=null) {
            model.addAttribute("numberId", numberId);
        }
        return "integer";
    }

    @PostMapping(path = "/integer")
    public String saveInteger(@RequestParam Integer value, Model model){
        Number newNumber = new Number(value);
        newNumber = numberRepository.save(newNumber);
        return getInteger(newNumber.getId(), model);
    }
}
