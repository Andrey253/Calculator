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
        Character oper_up;

        System.out.println("my in "  + stDoub);
        System.out.println("my in "  + stOp);

        double_up   = (Double) stDoub.pop();
        double_down = (Double) stDoub.pop();
        oper_up     = (Character) stOp.pop();
        stDoub.push(double_down + double_up);

        System.out.println("my out "  + stDoub);
        System.out.println("my out "  + stOp);
    }
}
