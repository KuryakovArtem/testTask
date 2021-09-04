package com.example.demo.operations;

import com.example.demo.Strategy;
import com.example.demo.entities.Number;
import com.example.demo.repos.NumberRepository;

import java.security.Key;
import java.util.*;

public class Min implements Strategy {
    private NumberRepository numberRepository;

    @Override
    public Double execute(ArrayList<Long> idList) {

        Iterable<Number> allValues;
        if (idList.isEmpty()) {
            allValues = numberRepository.findAll();
        }
        else {
            allValues = numberRepository.findAllById(idList);
        }
        return findMin(allValues);
    }

    public Min(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    private Double findMin(Iterable<Number> allValues)
    {
        Map<Long, Integer> aa = new HashMap<>();
        for (Number value : allValues) {
            aa.put(value.getId(), value.getValue());
        }
        Double min = Collections.min(aa.entrySet(), Map.Entry.comparingByValue()).getValue().doubleValue();
        return min;
    }

}
