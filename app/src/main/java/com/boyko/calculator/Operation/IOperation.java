package com.boyko.calculator.Operation;

import java.util.Stack;

public interface IOperation {

    void exec(Stack s1);

    int getPriority();
}
