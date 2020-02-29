package com.boyko.calculator.Operation;

import com.boyko.calculator.MainActivity;

import java.util.Stack;

public class Div extends Operation {
    public Div(int priority) {
        super(priority);
    }

    public void exec(Stack stDoub, Stack stOp) {

        Double double_up = (Double) stDoub.pop();
        Double double_down = (Double) stDoub.pop();

        try {
            stDoub.push(double_down / double_up);
        } catch (Exception e) {
            e.printStackTrace();
            MainActivity.tvError.setText("Деление на ноль");
        }
    }

    @Override
    public int getPriority() {
        return super.getPriority();
    }
}
