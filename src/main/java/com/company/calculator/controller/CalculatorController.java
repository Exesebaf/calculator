package com.company.calculator.controller;

import com.company.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String hello() {
        return "<b>Привет! Ты в калькуляторе!</b>";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(name = "num1", required = false) Integer a,
                       @RequestParam(name = "num2",required = false) Integer b) {
        if (a == null || b ==null) return "Один из параметров не введен!!";
        int plus = calculatorService.plus(a, b);
        return a + "+" + b + "=" + plus;

    }
    @GetMapping("/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer a,
                        @RequestParam(name = "num2",required = false) Integer b) {
        if (a == null || b ==null) return "Один из параметров не введен!!";
        int minus = calculatorService.minus(a, b);
        return a + "-" + b + "=" + minus;

    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "num1", required = false) Integer a,
                           @RequestParam(name = "num2",required = false) Integer b) {
        if (a == null || b ==null) return "Один из параметров не введен!!";
        int multiply = calculatorService.multiply(a, b);
        return a + "*" + b + "=" + multiply;
    }
    @GetMapping("/divide")
    public String divide(@RequestParam(name = "num1", required = false) Integer a,
                         @RequestParam(name = "num2",required = false) Integer b) {
        if (a == null || b ==null) return "Один из параметров не введен!!";
        double divide = calculatorService.divide(a, b);
        return a + "/" + b + "=" + divide;
    }

}
