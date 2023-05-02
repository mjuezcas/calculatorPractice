package com.practice.calculator.services;

import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

@Service
public class CalculatorMethodsImpl implements ICalculatorMethods {

    private TracerImpl tracer = new TracerImpl();

    @Override
    public Double sum(Double num1, Double num2) {
        System.out.println("Trying to sum "+ num1 + " and "+ num2);
        Double result = num1 + num2;
        tracer.trace(result);
        return result;
    }

    @Override
    public Double subtract(Double num1, Double num2) {
        System.out.println("Trying to subtract "+ num1 + " and "+ num2);
        Double result = num1 - num2;
        tracer.trace(result);
        return result;
    }

    @Override
    public Double operation(Double num1, Double num2, String operation) throws ArithmeticException {
        Double result;
        switch(operation){
            case "+":
                System.out.println("Trying to sum "+ num1 + " and "+ num2);
                result = num1 + num2;
                break;
            case "-":
                System.out.println("Trying to subtract "+ num1 + " and "+ num2);
                result = num1 - num2;
                break;
            case "*":
                System.out.println("Trying to multiply "+ num1 + " and "+ num2);
                result = num1 * num2;
                break;
            case "/":
                System.out.println("Trying to divide "+ num1 + " and "+ num2);
                result = num1 / num2;
                break;
            default:
                System.out.println("You send a operation not allowed");
                throw new ArithmeticException();
        }
        tracer.trace(result);
        return result;
    }
}
