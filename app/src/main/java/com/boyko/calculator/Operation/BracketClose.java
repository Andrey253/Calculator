package com.boyko.calculator.Operation;

import com.boyko.calculator.CrStacks;
import com.boyko.calculator.OperationsInit;

import java.util.Stack;

public class BracketClose extends Operation {

    public BracketClose(int priority) {
        super(priority);
    }

    @Override
    public void exec(Stack stDoub, Stack stOp) {

        Character  op1 = (Character) stOp.pop();
        Character  op2 = (Character) stOp.pop();

        if (!(op1 == ')' && op2 == '('))
        {
            stOp.push(op1); //вернули закрытую скобку

        } else {
            // Считаем то что в скобке
        }
    }

    @Override
    public int getPriority() {
        return super.getPriority();
    }
}