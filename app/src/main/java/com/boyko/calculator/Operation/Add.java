package com.boyko.calculator.Operation;

import java.util.Stack;

public class Add extends Operation{


    public Add(int priority) {
        super(priority);
    }

    @Override
    public void exec(Stack stDoub, Stack stOp) {

        Double double_up;
        Double double_down;

        double_up   = (Double) stDoub.pop();
        double_down = (Double) stDoub.pop();
        stOp.pop();
        stDoub.push(double_down + double_up);


    }
}
