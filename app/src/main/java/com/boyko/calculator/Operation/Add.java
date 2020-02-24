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
        Character  op1 = (Character) stOp.pop();
        try {
            Character  op2 = (Character) stOp.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        stOp.push(op1);

        double_up   = (Double) stDoub.pop();
        double_down = (Double) stDoub.pop();

        stDoub.push(double_down + double_up);
    }
}
