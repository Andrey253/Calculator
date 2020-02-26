package com.boyko.calculator;

import java.util.Stack;

public class CrStacks {

    public Calculator calculator;
    private String s;
    public Stack<Object> stackObj = new Stack<>();
    private StringBuilder sb;

    public CrStacks(String expression) {
        this.s = expression;
        //s = " (33-30)";
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

        //new Calculator(stackObj);
    }
}
/*      Сборка строки с разделителем ПРОБЕЛ между символами
        for (int pos = s.length()-1; pos > 0; pos--)
        {
            if (Character.isDigit(s.charAt(pos)) || s.charAt(pos) == '.')
            {
            }else {
                sb.insert(pos+1, " ");
                sb.insert(pos, " ");
            }
        }*/

/* Формирование стека символов выражения с начала строки
int pos = 0;
        while ( s.length()>0)
    {
        try {
            while (Enables.Operator.contains(s.charAt(0))){

                stackOperand.push(s.charAt(0));
                stackObj.push(s.charAt(0));
                s = s.substring(1, s.length());
            }
            while (Enables.Numbers.contains(s.charAt(pos))){
                pos++;
            }
            stackNumbers.push(Double.parseDouble(s.substring(0, pos)));
            stackObj.push(Double.parseDouble(s.substring(0, pos)));
            s = s.substring(pos, s.length());
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("my OUT");
        }
    }
        System.out.println("my stackNumbers " + stackNumbers);
        System.out.println("my stackOperand " + stackOperand);
        System.out.println("my stackObj " + stackObj);
}*/

/*        int pos = s.length() - 1;
        while (pos >= 0) {
            System.out.println("my  s.length()1 " + s.length());
            System.out.println("my  pos1 " + pos);

                if (Enables.Operator.contains(s.charAt(pos))) {
                    stackObj.push(s.charAt(pos));
                    s = s.substring(0, pos);
                    if (pos == 0) break;
                    pos--;
                }
            System.out.println("my stackObj1 " + stackObj);
            System.out.println("my  s.length()2 " + s.length());
            System.out.println("my  pos2 " + pos);

                while ( Enables.Numbers.contains(s.charAt(pos))) {
                    if (pos == 0) break;
                    pos--;
                }

                stackObj.push(Double.parseDouble(s.substring(pos , s.length())));
                s = s.substring(0, pos+1 );
            System.out.println("my stackObj2 " + stackObj);

        }*/
