package com.boyko.calculator.Operation.Calc;

import com.boyko.calculator.Operation.Operation;

import java.util.Stack;

public class Add extends Operation {

    public Add(int priority) {
        super(priority);
    }

    @Override
    public void exec(Stack stDouble) {

        Double double_up   = (Double) stDouble.pop();
        Double double_down;
        try {
            double_down = (Double) stDouble.pop();
        } catch (Exception e) {
            e.printStackTrace();
            double_down = 0.0;
        }
        stDouble.push(double_down + double_up);
    }
}
