package com.boyko.calculator;

import java.util.Stack;
import java.util.WeakHashMap;

public class Calculator {

    public Stack<Double> stackDouble;
    public Stack<Character> stackOper;

    public Calculator(Stack stacks) {

        Double double_up;
        Double double_down;
        Character oper_up;
        Character oper_down;
        stackDouble = new Stack<>();
        stackOper = new Stack<>();

        OperationsInit operationsInit = new OperationsInit();

        while (!stacks.isEmpty()){

            if (stacks.peek().getClass() == Double.class){
                stackDouble.push((Double) stacks.pop());
            } else {
                stackOper.push((Character) stacks.pop());
            }

            if (stackDouble.size() > 1 && stackOper.size() > 1){

                double_up   = stackDouble.pop();
                double_down = stackDouble.peek();
                oper_up     = stackOper.pop();
                oper_down   = stackOper.peek();

                if (operationsInit.operation.get(oper_down).getPriority()
                        >= operationsInit.operation.get(oper_up).getPriority()){

                    stackDouble.push(double_up);
                    operationsInit.operation.get(oper_down).exec(stackDouble, stackOper);
                    stackOper.push(oper_up);
                    //System.out.println("my stackDouble " + stackDouble);

                } else {

                    stackDouble.push(double_up);

                    stackOper.push(oper_up);
                }
            }
        }





        //System.out.println("my stackOper " + stackOper);
        //System.out.println("my stackNum " + stacks.stackNumbers +"         _______________");
    }
}
