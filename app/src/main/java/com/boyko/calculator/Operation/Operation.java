package com.boyko.calculator.Operation;

public class Operation implements IOperation {

    public int priority;

    public Operation(int priority) {
        this.priority = priority;
    }

    @Override
    public Double exec(String s1, String s2) {
        return null;
    }

    @Override
    public int getPriority() {
        return priority;
    }
}
