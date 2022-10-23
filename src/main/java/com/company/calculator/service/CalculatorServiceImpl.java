package com.company.calculator.service;


import com.company.calculator.exception.DivideByZeroException;
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
        if (b==0) {
            throw new DivideByZeroException("num2 не может равняться 0");
        }
        return a.doubleValue()/b;
    }
}

