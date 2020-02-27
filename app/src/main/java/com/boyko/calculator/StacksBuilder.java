package com.boyko.calculator;

import com.boyko.calculator.Enum.Enables;

import java.util.Stack;

public class StacksBuilder {

    private String s;
        public Stack<Object> stackObj = new Stack<>();
        public StacksBuilder(String expression) {
        this.s = " " + expression;
        stackObj.push('.');

        int pos = s.length() - 1;
        while (pos >= 0) {

            if (!Enables.Operator.contains(s.charAt(pos)) && !Enables.Numbers.contains(s.charAt(pos))) break;

            while (Enables.Operator.contains(s.charAt(pos))) {
                stackObj.push(s.charAt(pos));
                s = s.substring(0, pos);
                pos--;
            }

            if (!Enables.Operator.contains(s.charAt(pos)) && !Enables.Numbers.contains(s.charAt(pos))) break;

            while ( Enables.Numbers.contains(s.charAt(pos))) {
                pos--;
            }

            stackObj.push(Double.parseDouble(s.substring(pos+1 , s.length())));
            s = s.substring(0, pos+1 );
        }
    }
}