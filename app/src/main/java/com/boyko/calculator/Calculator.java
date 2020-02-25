package com.boyko.calculator;

import com.boyko.calculator.Operation.BracketOpen;
import com.boyko.calculator.Operation.IOperation;

import java.util.Stack;

public class Calculator {


    private Double result;
    public Stack<Double> stackDouble;
    public Stack<Character> stackOper;
    Character oper_up;
    Character oper_down;
    OperationsInit operationsInit = new OperationsInit();
    IOperation classOperation;

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
//            System.out.println("my stackOper " + stackOper);
            if ((Character) stackOper.peek() != '('){
               // System.out.println("my oper2 " + stackOper.peek());
//                System.out.println("my stackOper до " + stackOper);
//                System.out.println("my stackDouble до " + stackDouble);
                if (stackDouble.size() > 0 && stackOper.size() > 1){ // Усли в стеке одно число, то в функции "0" ставится автоматически

                    oper_up     = stackOper.pop();
                    oper_down   = stackOper.peek();
                    stackOper.push(oper_up);

                    //System.out.println("my oper " + oper_up);

                    if (operationsInit.operation.get(oper_down).getPriority()
                            >= operationsInit.operation.get(oper_up).getPriority()){

                        operationsInit.operation.get(oper_down).exec(stackDouble, stackOper);

                    } else if (oper_up == ')' && oper_down == '('){
                        stackOper.pop(); // delete (
                    }
                }
                System.out.println("my stackOper после " + stackOper);
                System.out.println("my stackDouble посл " + stackDouble);

            }else continue;
        }

/*        while (stackDouble.size() > 1 && stackOper.size() > 0){

            classOperation = operationsInit.operation.get(stackOper.peek());
            classOperation.exec(stackDouble, stackOper);

        }*/

        this.result = stackDouble.peek();
        System.out.println("my result " + this.getResult());
        System.out.println("my result " + stackDouble);
    }

    private void calc() {


        if (stackDouble.size() > 1 && stackOper.size() > 1 &&
                operationsInit.operation.get(oper_down  ).getPriority() >=
                operationsInit.operation.get(oper_up    ).getPriority())
            calc();
    }
}
