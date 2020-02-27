package com.boyko.calculator;

import com.boyko.calculator.Enum.OperationsInit;

import java.util.Stack;

public class Calculator {

    public Stack<Double> stackDouble;
    public Stack<Character> stackOper;
    private Double result;
    private Character oper_up;
    private Character oper_down;
    private OperationsInit operationsInit = new OperationsInit();

    public Double getResult() {
        return result;
    }

    public Calculator(Stack stacks) {

        stackDouble = new Stack<>();
        stackOper = new Stack<>();

        while (!stacks.isEmpty()){

            if (stacks.peek().getClass() == Double.class){
                stackDouble.push((Double) stacks.pop());
            } else {
                stackOper.push((Character) stacks.pop());
            }

            if (stackOper.size() > 0 && stackOper.peek() == '('){ continue; }
            while (stackOper.size() > 0 && stackOper.peek() == ')'){

                oper_up     = stackOper.pop();

                if (stackOper.size() != 0) oper_down   = stackOper.peek();

                if (oper_down == '(' && oper_up == ')'){
                    if (stackOper.size() != 0) stackOper.pop();
                } else{
                    oper_down = stackOper.pop();
                    operationsInit.operation.get(oper_down).exec(stackDouble,stackOper);
                    stackOper.push(oper_up);
                }
            }

            calculator();
        }
        this.result = stackDouble.peek();
    }

    private void calculator() {
        if (stackDouble.size() > 0 && stackOper.size() > 1){ // Усли в стеке одно число, то в функции "0" ставится автоматически

            oper_up     = stackOper.pop();
            oper_down   = stackOper.pop();

            if (operationsInit.operation.get(oper_down).getPriority()
                    >= operationsInit.operation.get(oper_up).getPriority()){

                operationsInit.operation.get(oper_down).exec(stackDouble, stackOper);
                stackOper.push(oper_up);

                calculator();

            } else {
                stackOper.push(oper_down);
                stackOper.push(oper_up);
            }
        }
    }
}
