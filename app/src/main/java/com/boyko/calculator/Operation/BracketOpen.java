package com.boyko.calculator.Operation;

import java.util.Stack;

public class BracketOpen extends Operation {
    @Override
    public void exec(Stack d1, Stack d2) {
        super.exec(d1, d2);
    }

    @Override
    public int getPriority() {
        return super.getPriority();
    }

    public BracketOpen(int priority) {
        super(priority);
    }
}
