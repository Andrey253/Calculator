package com.boyko.calculator;

import java.util.Stack;

public class Calculator {


    private Double result;
    public Stack<Double> stackDouble;
    public Stack<Character> stackOper;
    Character oper_up;
    Character oper_down;
    OperationsInit operationsInit = new OperationsInit();

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
            calc();
        }

        while (stackDouble.size() > 1 && stackOper.size() > 0){

            operationsInit.operation.get(stackOper.peek()).exec(stackDouble, stackOper);
        }

        this.result = stackDouble.peek();
        System.out.println("my result " + this.getResult());
    }

    private void calc() {

        if (stackDouble.size() > 0 && stackOper.size() > 1){

            oper_up     = stackOper.pop();
            oper_down   = stackOper.peek();
            stackOper.push(oper_up);

            if (operationsInit.operation.get(oper_down).getPriority()
                    >= operationsInit.operation.get(oper_up).getPriority()){

                operationsInit.operation.get(oper_down).exec(stackDouble, stackOper);

            } else if (oper_up == ')' && oper_down == '('){
                stackOper.pop(); // delete (
            }
        }
        if (stackDouble.size() > 0 && stackOper.size() > 1 &&
                operationsInit.operation.get(oper_down  ).getPriority() >=
                operationsInit.operation.get(oper_up    ).getPriority())
            calc();
    }
}
