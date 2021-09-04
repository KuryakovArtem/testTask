package com.example.demo.operations;

import com.example.demo.Strategy;
import com.example.demo.entities.Number;
import com.example.demo.repos.NumberRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Max implements Strategy {
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
        return findMax(allValues);
    }

    public Max(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    private Double findMax(Iterable<Number> allValues)
    {
        Map<Long, Integer> aa = new HashMap<>();
        for (Number value : allValues) {
            aa.put(value.getId(), value.getValue());
        }
        Double min = Collections.max(aa.entrySet(), Map.Entry.comparingByValue()).getValue().doubleValue();
        return min;
    }
}
