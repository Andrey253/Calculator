package com.boyko.calculator.Operation;

import java.util.Stack;

public class Operation implements IOperation {

    public int priority;

    public Operation(int priority) {
        this.priority = priority;
    }

    @Override
    public void exec(Stack d1) {    }

    @Override
    public int getPriority() {
        return priority;
    }
}
