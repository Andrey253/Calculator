package com.boyko.calculator.Operation;

import com.boyko.calculator.Enum.OperationsInit;

import java.util.Stack;

public class BracketClose extends Operation {

    public BracketClose(int priority) {
        super(priority);
    }

    @Override
    public void exec(Stack stDoub, Stack stOp) {

    }

    @Override
    public int getPriority() {
        return super.getPriority();
    }
}