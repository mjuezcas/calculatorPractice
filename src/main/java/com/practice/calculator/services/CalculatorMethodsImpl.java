package com.practice.calculator.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorMethodsImpl implements ICalculatorMethods {

    @Override
    public int sum(int num1, int num2) {
        System.out.println("Trying to sum "+num1 + " and "+ num2);
        return num1 + num2;
    }

    @Override
    public int subtract(int num1, int num2) {
        return num1 - num2;
    }
}
