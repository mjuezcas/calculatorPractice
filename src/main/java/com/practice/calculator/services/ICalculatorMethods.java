package com.practice.calculator.services;

import com.practice.calculator.models.OperationParams;

public interface ICalculatorMethods {

    Double sum(Double num1, Double num2);

    Double subtract(Double num1, Double num2);

    Double operation(OperationParams params) throws ArithmeticException;
}
