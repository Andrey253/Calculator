package com.boyko.calculator;

import com.boyko.calculator.Enum.OperationsInit;

import java.util.Stack;

public class Calculator {

    private Stack<Double> stackDouble;
    private Stack<Character> stackOperations;
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

        while (!stacks.isEmpty()) {

            if (stacks.peek().getClass() == Double.class) {
                    stackDouble.push((Double) stacks.pop());
            }
            else {
                stackOperations.push((Character) stacks.pop());
            }
            calculator();
        }
        if (stackDouble.size() !=0){
            this.result = stackDouble.peek();

        }
    }

    private void calculator() {
        if (stackDouble.size() > 0 && stackOperations.size() > 1) {
            first_operation = stackOperations.pop();
            second_operation = stackOperations.pop();

            if (second_operation == '(' && first_operation == ')') {
                calculator();
            }
            else if (first_operation == '(') {
                stackOperations.push(second_operation);
                stackOperations.push(first_operation);
            }
            else if (operationsInit.operation.get(second_operation).getPriority()
                    >= operationsInit.operation.get(first_operation).getPriority()) {
                operationsInit.operation.get(second_operation).exec(stackDouble);
                stackOperations.push(first_operation);
                calculator();
            }
            else {
                stackOperations.push(second_operation);
                stackOperations.push(first_operation);
            }
        }
    }
}