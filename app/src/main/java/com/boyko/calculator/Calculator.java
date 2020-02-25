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
//         System.out.println("my stack full " + stacks);
        while (!stacks.isEmpty()){

            if (stacks.peek().getClass() == Double.class){
                stackDouble.push((Double) stacks.pop());
            } else {
                stackOper.push((Character) stacks.pop());
            }

            if (stackOper.size() > 0 && (Character) stackOper.peek() == '('){ continue; }
            while (stackOper.size() > 0 && (Character) stackOper.peek() == ')'){

                oper_up     = stackOper.pop();
                oper_down   = stackOper.peek();
                stackOper.push(oper_up);

                if (oper_down == '(' && oper_up == ')'){
                    stackOper.pop();
                    stackOper.pop();
                } else

                    operationsInit.operation.get(')');
            }

            System.out.println("my stackOper до " + stackOper);
            System.out.println("my stackDouble до " + stackDouble);

            calculator();

            System.out.println("my stackOper после " + stackOper);
            System.out.println("my stackDouble посл " + stackDouble);
        }

/*        while (stackDouble.size() > 1 && stackOper.size() > 0){

            classOperation = operationsInit.operation.get(stackOper.peek());
            classOperation.exec(stackDouble, stackOper);

        }*/

        this.result = stackDouble.peek();
        System.out.println("my result " + this.getResult());
        System.out.println("my result " + stackDouble);
    }

    private void calculator() {
        if (stackDouble.size() > 0 && stackOper.size() > 1){ // Усли в стеке одно число, то в функции "0" ставится автоматически

            oper_up     = stackOper.pop();
            oper_down   = stackOper.pop();
            System.out.println("my проверяем условие для выполнения  oper_down " + oper_down);

            if (operationsInit.operation.get(oper_down).getPriority()
                    >= operationsInit.operation.get(oper_up).getPriority()){
                System.out.println("my выполняем " + oper_down);
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
