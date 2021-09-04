package com.example.demo.operations;

import com.example.demo.Strategy;
import com.example.demo.entities.Number;
import com.example.demo.repos.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Optional;

public class Sum implements Strategy {

    private NumberRepository numberRepository;

    @Override
    public Double execute(ArrayList<Long> ids) {
        Double sumOfAll = 0d;
        if (ids.isEmpty())
        {
            Iterable<Number> allValues = numberRepository.findAll();
            for (Number values : allValues) {
                sumOfAll+= values.getValue();
            }
        }
        else {
            for (Long id : ids) {
                Optional<Number> number = numberRepository.findById(id);
                Number a = number.get();
                sumOfAll += a.getValue();
            }
        }
        return sumOfAll;
    }
    public Sum(NumberRepository repository) {
        this.numberRepository = repository;
    }

}
