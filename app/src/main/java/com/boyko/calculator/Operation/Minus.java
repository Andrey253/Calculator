package com.boyko.calculator.Operation;

import java.util.Stack;

public class Minus extends Operation{

    public int priority;

    public Minus(int priority) {
        super(priority);
    }

    @Override
    public void exec(Stack stDoub, Stack stOp) {

        Double double_up;
        Double double_down;

        if (stDoub.size() > 1){
            double_up   = (Double) stDoub.pop();
            double_down = (Double) stDoub.pop();

            Character  op1 = (Character) stOp.pop();
            Character  op2 = (Character) stOp.pop();
            stOp.push(op1);

            stDoub.push(double_down - double_up);
        } else if (stDoub.size() == 1){
            double_up   = (Double) stDoub.pop();
            double_down = 0.0;
            stOp.pop();
            stDoub.push(double_down - double_up);
        }



    }
}
