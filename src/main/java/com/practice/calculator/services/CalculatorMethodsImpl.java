package com.practice.calculator.services;

import com.practice.calculator.models.OperationParams;
import org.springframework.stereotype.Service;

@Service
public class CalculatorMethodsImpl implements ICalculatorMethods {

    @Override
    public Double sum(Double num1, Double num2) {
        System.out.println("Trying to sum "+ num1 + " and "+ num2);
        return num1 + num2;
    }

    @Override
    public Double subtract(Double num1, Double num2) {
        System.out.println("Trying to subtract "+ num1 + " and "+ num2);
        return num1 - num2;
    }

    @Override
    public Double operation(OperationParams params) throws ArithmeticException {
        switch(params.getOperation()){
            case "+":
                return params.getNum1() + params.getNum2();
            case "-":
                return params.getNum1() - params.getNum2();
            case "*":
                return params.getNum1() * params.getNum2();
            case "/":
                return params.getNum1() / params.getNum2();
            default:
                System.out.println("You send a operation not allowed");
                throw new ArithmeticException();
        }
    }
}
