package com.example.demo;

import com.example.demo.operations.Max;
import com.example.demo.operations.Mean;
import com.example.demo.operations.Min;
import com.example.demo.operations.Sum;
import com.example.demo.repos.NumberRepository;

public class StrategyFactory {
    public Strategy createStrategy(String operation, NumberRepository repository)
    {
        switch (operation)
        {
            case ("sum"):
                return new Sum(repository);
            case ("min"):
                return new Min(repository);
            case ("max"):
                return new Max(repository);
            case("mean"):
                return new Mean(repository);
            default:return null;
        }

    }
}
