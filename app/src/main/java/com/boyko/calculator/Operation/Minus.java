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

        double_up   = (Double) stDoub.pop();
        System.out.println("my stack zise  " + stDoub.size());
        if (stDoub.size() > 0){

            double_down = (Double) stDoub.pop();

            stDoub.push(double_down - double_up);

        } else {

            double_down = 0.0;
             System.out.println("my выполняем вычитание " + double_down+" - "+double_up);

            stDoub.push(double_down - double_up);
        }



    }
}
