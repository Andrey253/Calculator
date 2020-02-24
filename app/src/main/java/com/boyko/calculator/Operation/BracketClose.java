package com.boyko.calculator.Operation;

import com.boyko.calculator.CrStacks;

import java.util.Stack;

public class BracketClose extends Operation {

    public BracketClose(int priority) {
        super(priority);
    }

    @Override
    public void exec(Stack stDoub, Stack stOp) {

        Double double_up;
        Double double_down;
        StringBuilder s = new StringBuilder();
        CrStacks newcalc;

        Character  op1 = (Character) stOp.pop();
        Character  op2 = (Character) stOp.pop();
        stOp.push(op2);
        stOp.push(op1);

        if (op1 == ')' && op2 == '('){
            stOp.pop();
            stOp.pop();
        } else {
            stOp.pop();
            while ((Character)stOp.peek() != '('){
                s.insert(0,stDoub.pop().toString());
                s.insert(0,stOp.pop().toString());
            }
            s.insert(0,stDoub.pop().toString());

            newcalc = new CrStacks(s.toString());

            stDoub.push(newcalc.calculator.getResult());

            System.out.println("my newcalc.calculator.getResult() " + newcalc.calculator.getResult());
        }

        if ((Character) stOp.peek() == '('){

        }



    }

    @Override
    public int getPriority() {
        return super.getPriority();
    }
}