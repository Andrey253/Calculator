package com.boyko.calculator.Operation;

import java.util.Stack;

public class Multiply extends Operation {
    public Multiply(int priority) {
        super(priority);
    }

    @Override
    public void exec(Stack stDoub, Stack stOp) {

        Double double_up   = (Double) stDoub.pop();
        Double double_down = (Double) stDoub.pop();

        Character  op1 = (Character) stOp.pop();
        Character  op2 = (Character) stOp.pop();
        stOp.push(op1);

        stDoub.push(double_down * double_up);
    }

    @Override
    public int getPriority() {
        return super.getPriority();
    }
}
