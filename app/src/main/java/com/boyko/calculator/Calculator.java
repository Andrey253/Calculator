package com.boyko.calculator;

import java.util.Stack;
import java.util.WeakHashMap;

public class Calculator {

    public Stack<Double> stackDouble;
    public Stack<Character> stackOper;
    Double double_up;
    Double double_down;
    Character oper_up;
    Character oper_down;
    OperationsInit operationsInit = new OperationsInit();

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
            System.out.println("my stackOper " + stackOper);
            System.out.println("my stackDouble " + stackDouble +"         _______________");

        }

        while (stackDouble.size() > 1 && stackOper.size() > 1){

            operationsInit.operation.get(stackOper.peek()).exec(stackDouble, stackOper);
        }

    }

    private void calc() {

        if (stackDouble.size() > 1 && stackOper.size() > 1){

            oper_up     = stackOper.pop();
            oper_down   = stackOper.peek();

            if (operationsInit.operation.get(oper_down).getPriority()
                    >= operationsInit.operation.get(oper_up).getPriority()){

                operationsInit.operation.get(oper_down).exec(stackDouble, stackOper);
                stackOper.push(oper_up);

            } else {

                stackOper.push(oper_up);
            }
        }
        if (stackDouble.size() > 1 && stackOper.size() > 1 &&
                operationsInit.operation.get(oper_down).getPriority()
                        >= operationsInit.operation.get(oper_up).getPriority())
            calc();
    }
}
