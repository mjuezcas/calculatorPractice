package com.practice.calculator.controllers;

import com.practice.calculator.services.ICalculatorMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private ICalculatorMethods calculatorMethods;

    @Autowired
    public CalculatorController(ICalculatorMethods calculatorMethods){
        this.calculatorMethods = calculatorMethods;
    }

    @GetMapping("/sum")
    public int sum(int num1, int num2) {
        return calculatorMethods.sum(num1, num2);
    }

    @GetMapping("/subtract")
    public int subtract(int num1, int num2) {
        return calculatorMethods.subtract(num1, num2);
    }

}
