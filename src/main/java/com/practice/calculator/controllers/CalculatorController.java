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

    @GetMapping("/operation")
    public ResponseEntity<Double> subtract(Double num1, Double num2, String operation) {
        // If you want to try this method, you should send the operation method encode otherwise the method will get am empty string
        // + -> %2A
        // - -> - (It is the same)
        // * -> %2B
        // / -> %2F

        try {
            return ResponseEntity.ok().body(calculatorMethods.operation(num1, num2, operation));
        }catch (ArithmeticException ex) {
            System.out.println("The Arithmetic exception was captured");
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/operation")
    public ResponseEntity<Double> operation(@RequestBody OperationParams params) {
        try {
            return ResponseEntity.ok().body(calculatorMethods.operation(params.getNum1(), params.getNum2(), params.getOperation()));
        }catch (ArithmeticException ex) {
            System.out.println("The Arithmetic exception was captured");
            return ResponseEntity.badRequest().body(null);
        }
    }


}
