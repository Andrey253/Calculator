package com.boyko.calculator.Operation;

import java.util.Stack;

public class Add extends Operation{


    public Add(int priority) {
        super(priority);
    }

    @Override
    public void exec(Stack stDoub, Stack stOp) {


        Double double_up   = (Double) stDoub.pop();
        Double double_down;
        try {
            double_down = (Double) stDoub.pop();
        } catch (Exception e) {
            e.printStackTrace();
            double_down = 0.0;
        }

        stDoub.push(double_down + double_up);
    }
}
