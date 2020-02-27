package com.boyko.calculator.Operation;

import com.boyko.calculator.Enum.OperationsInit;

import java.util.Stack;

public class BracketClose extends Operation {

    public BracketClose(int priority) {
        super(priority);
    }

    @Override
    public void exec(Stack stDoub, Stack stOp) {

        Character oper = (Character) stOp.pop();
        OperationsInit operationsInit = new OperationsInit();
        operationsInit.operation.get(oper).exec(stDoub, stOp);
    }

    @Override
    public int getPriority() {
        return super.getPriority();
    }
}