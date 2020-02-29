package com.boyko.calculator.Enum;

import com.boyko.calculator.Operation.Add;
import com.boyko.calculator.Operation.BracketClose;
import com.boyko.calculator.Operation.BracketOpen;
import com.boyko.calculator.Operation.Div;
import com.boyko.calculator.Operation.IOperation;
import com.boyko.calculator.Operation.Minus;
import com.boyko.calculator.Operation.Multiply;
import com.boyko.calculator.Operation.Point;

import java.util.HashMap;

public  class OperationsInit {

    public HashMap<Character, IOperation> operation;

    public OperationsInit() {
        HashMap<Character, IOperation> operation2 = new HashMap<>();
        operation2.put('+', new Add(1));
        operation2.put('-', new Minus(1));
        operation2.put('*', new Multiply(3));
        operation2.put('/', new Div(3));
        operation2.put('(', new BracketOpen(0));
        operation2.put(')', new BracketClose(-1));
        operation2.put('.', new Point(-100));
        this.operation = operation2;
    }
}
