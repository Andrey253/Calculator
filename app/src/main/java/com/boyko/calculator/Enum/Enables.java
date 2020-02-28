package com.boyko.calculator.Enum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Enables {
    public static Map<Character, String> Button;
    public static List<Character> Numbers;
    public static List<Character> Operator;
    public static List<Character> CalcOperator;

    static {
        Button = new HashMap<>();

        Button.put('0', "0123456789.+-*/)");
        Button.put('1', "0123456789.+-*/)");
        Button.put('2', "0123456789.+-*/)");
        Button.put('3', "0123456789.+-*/)");
        Button.put('4', "0123456789.+-*/)");
        Button.put('5', "0123456789.+-*/)");
        Button.put('6', "0123456789.+-*/)");
        Button.put('7', "0123456789.+-*/)");
        Button.put('8', "0123456789.+-*/)");
        Button.put('9', "0123456789.+-*/)");

        Button.put('+', "0123456789(");
        Button.put('-', "0123456789(");
        Button.put('*', "0123456789(");
        Button.put('/', "0123456789(");

        Button.put(')', ")+-*/");
        Button.put('(', "(0123456789-");

        Button.put('.', "0123456789");

        Numbers = new ArrayList<>();
        Numbers.add('0');
        Numbers.add('1');
        Numbers.add('2');
        Numbers.add('3');
        Numbers.add('4');
        Numbers.add('5');
        Numbers.add('6');
        Numbers.add('7');
        Numbers.add('8');
        Numbers.add('9');
        Numbers.add('.');

        Operator = new ArrayList<>();
        Operator.add('+');
        Operator.add('-');
        Operator.add('*');
        Operator.add('/');
        Operator.add('(');
        Operator.add(')');

        CalcOperator = new ArrayList<>();
        CalcOperator.add('+');
        CalcOperator.add('-');
        CalcOperator.add('*');
        CalcOperator.add('/');
    }
}
