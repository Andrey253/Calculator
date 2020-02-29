package com.boyko.calculator.Operation.Calc;

import com.boyko.calculator.Operation.Operation;

import java.util.Stack;

public class Minus extends Operation {

    public int priority;

    public Minus(int priority) {
        super(priority);
    }

    @Override
    public void exec(Stack stDouble) {

        Double double_up;
        Double double_down;

        double_up   = (Double) stDouble.pop();
        double_down = (stDouble.size() > 0) ? (Double) stDouble.pop() : 0.0;
        stDouble.push(double_down - double_up);
    }
}
