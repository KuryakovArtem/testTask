package com.example.demo.controllers;

import com.example.demo.Strategy;
import com.example.demo.StrategyFactory;
import com.example.demo.parser.StringParser;
import com.example.demo.repos.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Controller
public class OperationsController {

    @Autowired
    private NumberRepository numberRepository;

    @GetMapping(path = "/operations")
    public String getData(String result, Model model)
    {
        if (result!=null)
        {
            model.addAttribute("result", result);
        }
        return "operations";
    }

    @PostMapping(path = "/operations")
    public String someMethodName(@RequestParam String responseString, Model model)
    {
        StringParser parser = new StringParser();
        ArrayList<String> parsedString = parser.parseString(responseString);
        StrategyFactory factory = new StrategyFactory();
        Strategy strategy = factory.createStrategy(parsedString.get(0), numberRepository);
        String resultString = strategy.execute(new ArrayList<>(parsedString.stream().skip(1).map(Long::parseLong).collect(Collectors.toList()))).toString();
        return getData(resultString, model);
    }

}
