package com.boyko.calculator.Operation.Calc;

import com.boyko.calculator.Operation.Operation;

import java.util.Stack;

public class Multiply extends Operation {
    public Multiply(int priority) {
        super(priority);
    }

    @Override
    public void exec(Stack stDouble) {

        Double double_up   = (Double) stDouble.pop();
        Double double_down = (Double) stDouble.pop();

        stDouble.push(double_down * double_up);
    }

    @Override
    public int getPriority() {
        return super.getPriority();
    }
}
