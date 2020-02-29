package com.boyko.calculator.Enum;

import com.boyko.calculator.Operation.Calc.Add;
import com.boyko.calculator.Operation.BracketClose;
import com.boyko.calculator.Operation.BracketOpen;
import com.boyko.calculator.Operation.Calc.Div;
import com.boyko.calculator.Operation.IOperation;
import com.boyko.calculator.Operation.Calc.Minus;
import com.boyko.calculator.Operation.Calc.Multiply;
import com.boyko.calculator.Operation.Point;

import java.util.HashMap;

public  class OperationsInit {

    public HashMap<Character, IOperation> operation;

    public OperationsInit() {
        HashMap<Character, IOperation> operation2 = new HashMap<>();
        operation2.put('+', new Add(3));
        operation2.put('-', new Minus(3));
        operation2.put('*', new Multiply(4));
        operation2.put('/', new Div(4));
        operation2.put('(', new BracketOpen(2));
        operation2.put(')', new BracketClose(1));
        operation2.put('.', new Point(0));
        this.operation = operation2;
    }
}
