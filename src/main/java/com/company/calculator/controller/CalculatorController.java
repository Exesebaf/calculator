package com.company.calculator.controller;

import com.company.calculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String hello() {
        return "<b>Привет! Ты в калькуляторе!</b>";
    }

    @GetMapping("/calculator/plus")
    public String plus(@RequestParam(name = "num1", required = false) Integer a,
                       @RequestParam(name = "num2",required = false) Integer b) {
        if (a == null || b ==null) return "Один из параметров не введен!!";
        int plus = calculatorService.plus(a, b);
        return a + "+" + b + "=" + plus;

    }
    @GetMapping("/calculator/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer a,
                        @RequestParam(name = "num2",required = false) Integer b) {
        if (a == null || b ==null) return "Один из параметров не введен!!";
        int minus = calculatorService.minus(a, b);
        return a + "-" + b + "=" + minus;

    }
    @GetMapping("/calculator/multiply")
    public String multiply(@RequestParam(name = "num1", required = false) Integer a,
                           @RequestParam(name = "num2",required = false) Integer b) {
        if (a == null || b ==null) return "Один из параметров не введен!!";
        int multiply = calculatorService.multiply(a, b);
        return a + "*" + b + "=" + multiply;
    }
    @GetMapping("/calculator/divide")
    public String divide(@RequestParam(name = "num1", required = false) Integer a,
                         @RequestParam(name = "num2",required = false) Integer b) {
        if (a == null || b ==null) return "Один из параметров не введен!!";
        if (b==0) return "На ноль делить нельзя!";
        double divide = calculatorService.divide(a, b);
        return a + "/" + b + "=" + divide;

    }

}
