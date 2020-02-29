package com.boyko.calculator;

import com.boyko.calculator.Enum.OperationsInit;

import java.util.Stack;

public class Calculator {

    public Stack<Double> stackDouble;
    public Stack<Character> stackOperations;
    private Double result;
    private Character first_operation;
    private Character second_operation;
    private OperationsInit operationsInit = new OperationsInit();

    public Double getResult() {
        return result;
    }

    public Calculator(Stack stacks) {

        stackDouble = new Stack<>();
        stackOperations = new Stack<>();

        while (!stacks.isEmpty()){

            if (stacks.peek().getClass() == Double.class){
                stackDouble.push((Double) stacks.pop());
            } else {
                stackOperations.push((Character) stacks.pop());
            }

            while (stackOperations.size() > 0){ // Если есть скобка ), то будет и второй оператор в стеке
                if (stackOperations.peek() == ')'){
                    first_operation     = stackOperations.pop();
                    second_operation   = stackOperations.peek();

                    if (second_operation == '(' && first_operation == ')'){
                        stackOperations.pop();
                    } else{
                        second_operation = stackOperations.pop();
                        operationsInit.operation.get(second_operation).exec(stackDouble,stackOperations);
                        stackOperations.push(first_operation);
                    }
                } else break;
            }

            calculator();
        }
        this.result = stackDouble.peek();
    }

    private void calculator() {
        if (stackDouble.size() > 0 && stackOperations.size() > 1){ // Усли в стеке одно число, то в функции "0" ставится автоматически

            first_operation     = stackOperations.pop();
            second_operation   = stackOperations.pop();

            if (operationsInit.operation.get(second_operation).getPriority()
                    >= operationsInit.operation.get(first_operation).getPriority()
            && second_operation != '('){

                operationsInit.operation.get(second_operation).exec(stackDouble, stackOperations);
                stackOperations.push(first_operation);

                calculator();

            } else {
                stackOperations.push(second_operation);
                stackOperations.push(first_operation);
            }
        }
    }
}
