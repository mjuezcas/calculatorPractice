package com.practice.calculator.controllers;

import com.practice.calculator.models.OperationParams;
import com.practice.calculator.services.ICalculatorMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    private ICalculatorMethods calculatorMethods;

    @Autowired
    public CalculatorController(ICalculatorMethods calculatorMethods){
        this.calculatorMethods = calculatorMethods;
    }

    @GetMapping("/sum")
    public Double sum(Double num1, Double num2) {
        return calculatorMethods.sum(num1, num2);
    }

    @GetMapping("/subtract")
    public Double subtract(Double num1, Double num2) {
        return calculatorMethods.subtract(num1, num2);
    }

    @PostMapping("/operation")
    public ResponseEntity<Double> operation(@RequestBody OperationParams params) {
        try {
            return ResponseEntity.ok().body(calculatorMethods.operation(params));
        }catch (ArithmeticException ex) {
            System.out.println("The Arithmetic exception was captured");
            return ResponseEntity.badRequest().body(null);
        }
    }


}
