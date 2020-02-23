package com.boyko.calculator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {

    private String s;
    private Stack<Character> stackOperand = new Stack ();
    private Stack<String> stackNumbers = new Stack ();


    public Calculator(String expression) {
        this.s = expression;
        StringBuilder sb = new StringBuilder(s);

        if (s.charAt(0) == '-')
            stackNumbers.push("0");



/*        for (int pos = s.length()-1; pos > 0; pos--)
        {
            if (Character.isDigit(s.charAt(pos)) || s.charAt(pos) == '.')
            {
            }else {
                sb.insert(pos+1, " ");
                sb.insert(pos, " ");
            }
        }*/
        int pos = s.length()-1;
        while ( pos >= 0)
        {
            try {
                while (Enables.Operator.contains(s.charAt(pos))){
                    stackOperand.push(s.charAt(pos));
                    System.out.println("my in oper " + s.charAt(pos));
                    s = s.substring(0, pos);
                    pos--;

                    System.out.println("my s.oper " + s);

                }
                while (Enables.Numbers.contains(s.charAt(pos))){
                    pos--;
                }
                stackNumbers.push(s.substring(pos+1, s.length()));
                System.out.println("my in dig " + s.substring(pos+1, s.length()));
                s = s.substring(0, pos+1);
                System.out.println("my s.dig " + s);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("my OUT");
            }
        }
        //stackNumbers.push(s);
        System.out.println("my stackNumbers " + stackNumbers);
        System.out.println("my stackOperand " + stackOperand);
    }
}
