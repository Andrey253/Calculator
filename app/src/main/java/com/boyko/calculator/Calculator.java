package com.boyko.calculator;

import java.util.Stack;

public class Calculator {

    private String s;
    private Stack<Character> stackOperand = new Stack ();
    private Stack<String> stackNumbers = new Stack ();

    public Calculator(String expression) {
        this.s = expression;
s="-(-11+22)*(33+44)";
        int pos = 0;
        while ( s.length()>0)
        {
            try {
                while (Enables.Operator.contains(s.charAt(0))){
                    if (stackNumbers.isEmpty())
                        stackNumbers.push("0");
                    stackOperand.push(s.charAt(0));
                    System.out.println("my stackOperand after " + stackOperand);
                    s = s.substring(1, s.length());
                    System.out.println("my s oper after " + s);
                }
                while (Enables.Numbers.contains(s.charAt(pos))){
                    pos++;
                }
                stackNumbers.push(s.substring(0, pos));
                System.out.println("my stackNumbers After " + stackNumbers);
                s = s.substring(pos, s.length());
                //pos=0;
                System.out.println("my s Num After " + s);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("my OUT");
            }
        }
        System.out.println("my stackNumbers " + stackNumbers);
        System.out.println("my stackOperand " + stackOperand);
    }
}
/*        for (int pos = s.length()-1; pos > 0; pos--)
        {
            if (Character.isDigit(s.charAt(pos)) || s.charAt(pos) == '.')
            {
            }else {
                sb.insert(pos+1, " ");
                sb.insert(pos, " ");
            }
        }*/
/*
int pos = s.length()-1;
        while ( pos >= 0)
                {
                try {
                while (Enables.Operator.contains(s.charAt(pos))){
                stackOperand.push(s.charAt(pos));
                s = s.substring(0, pos);
                pos--;
                }
                while (Enables.Numbers.contains(s.charAt(pos))){
                pos--;
                }
                stackNumbers.push(s.substring(pos+1, s.length()));
                s = s.substring(0, pos+1);

                } catch (Exception e) {
                e.printStackTrace();
                System.out.println("my OUT");
                }
                }*/
