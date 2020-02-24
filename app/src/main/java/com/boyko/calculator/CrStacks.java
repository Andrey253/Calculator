package com.boyko.calculator;

import java.util.Stack;

public class CrStacks {

    private String s;
    public Stack<Object> stackObj = new Stack<>();

    public CrStacks(String expression) {
        this.s = expression;

        s = "1-2+3/4+5";
        int pos = s.length() - 1;
        while (pos >= 0) {
            try {
                while (Enables.Operator.contains(s.charAt(pos))) {
                    stackObj.push(s.charAt(pos));
                    s = s.substring(0, pos);
                    pos--;
                }
                while (pos >= 0 && Enables.Numbers.contains(s.charAt(pos))) {
                    pos--;
                }
                stackObj.push(Double.parseDouble(s.substring(pos + 1, s.length())));
                s = s.substring(0, pos + 1);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("my OUT");
            }
        }
        new Calculator(stackObj);
        //System.out.println("my stacks " + stackObj);
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
int pos = 0;
        while ( s.length()>0)
    {
        try {
            while (Enables.Operator.contains(s.charAt(0))){
                if (stackNumbers.isEmpty())
                    stackNumbers.push(0.0);
                stackOperand.push(s.charAt(0));
                stackObj.push(s.charAt(0));
                //new Calculator(this);
                //System.out.println("my stackOperand after " + stackOperand);
                s = s.substring(1, s.length());
                //System.out.println("my s oper after " + s);
            }
            while (Enables.Numbers.contains(s.charAt(pos))){
                pos++;
            }
            stackNumbers.push(Double.parseDouble(s.substring(0, pos)));
            stackObj.push(Double.parseDouble(s.substring(0, pos)));
            //new Calculator(this);
            //System.out.println("my stackNumbers After " + stackNumbers);
            s = s.substring(pos, s.length());
            //System.out.println("my s Num After " + s);

        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("my OUT");
        }
    }
        System.out.println("my stackNumbers " + stackNumbers);
        System.out.println("my stackOperand " + stackOperand);
        System.out.println("my stackObj " + stackObj);
}*/
