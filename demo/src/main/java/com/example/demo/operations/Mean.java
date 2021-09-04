package com.example.demo.operations;

import com.example.demo.Strategy;
import com.example.demo.entities.Number;
import com.example.demo.repos.NumberRepository;

import java.util.ArrayList;
import java.util.Optional;

public class Mean implements Strategy {
    private NumberRepository numberRepository;

    public Mean(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    @Override
    public Double execute(ArrayList<Long> ids) {
        Double sumOfAll = 0d;
        Double meanValue;
        if (ids.isEmpty())
        {
            Iterable<Number> allValues = numberRepository.findAll();
            for (Number values : allValues) {
                sumOfAll+= values.getValue();
            }
            meanValue = sumOfAll/allValues.spliterator().getExactSizeIfKnown();
        }
        else {
            for (Long id : ids) {
                Optional<Number> number = numberRepository.findById(id);
                Number a = number.get();
                sumOfAll += a.getValue();
            }
            meanValue = sumOfAll/ids.size();
        }

        return meanValue;
    }


}
