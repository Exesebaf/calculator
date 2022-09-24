package com.company.calculator.service;


import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public int plus(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public int minus(Integer a, Integer b) {
        return a - b;
    }

    @Override
    public int multiply(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public double divide(Integer a, Integer b) {
            return (double) a / b;
    }
}
