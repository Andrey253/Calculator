package com.boyko.calculator.Operation;

public interface IOperation {

    Double exec(String s1, String s2);

    int getPriority();
}
