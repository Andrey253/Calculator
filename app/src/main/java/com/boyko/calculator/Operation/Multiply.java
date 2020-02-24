package com.boyko.calculator.Operation;

import java.util.Stack;

public class Multiply extends Operation {
    public Multiply(int priority) {
        super(priority);
    }

    @Override
    public void exec(Stack stDoub, Stack stOp) {

        Double double_up;
        Double double_down;
        Character oper_up;

        double_up   = (Double) stDoub.pop();
        double_down = (Double) stDoub.pop();
        oper_up     = (Character) stOp.pop();
        stDoub.push(double_down * double_up);
    }

    @Override
    public int getPriority() {
        return super.getPriority();
    }
}
