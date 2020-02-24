package com.boyko.calculator.Operation;

import java.util.Stack;

public class Div extends Operation {
    public Div(int priority) {
        super(priority);
    }

    public void exec(Stack stDoub, Stack stOp) {

        Double double_up = (Double) stDoub.pop();
        Double double_down = (Double) stDoub.pop();

        Character  op1 = (Character) stOp.pop();
        Character  op2 = (Character) stOp.pop();
        stOp.push(op1);

        try {
            stDoub.push(double_down / double_up);
        } catch (Exception e) {
            e.printStackTrace();
            // деление на ноль
        }
    }

    @Override
    public int getPriority() {
        return super.getPriority();
    }
}
