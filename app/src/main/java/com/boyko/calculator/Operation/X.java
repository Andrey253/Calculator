package com.boyko.calculator.Operation;

import android.widget.Button;

import com.boyko.calculator.Enables;

public class X {
    private String space(String s, String exp, Button but) {

        if (exp.length()>0) {
            System.out.println("my expression "+ exp);
            System.out.println("my containsKey "+ Enables.Button.containsKey(s.charAt(exp.length()-1)));
            System.out.println("my Нужен пробел "+ Enables.Button.get(s.charAt(exp.length()-1)).contains(but.getText().toString()));
            System.out.println("my ( "+ Enables.Button.get('('));
            System.out.println("my ) "+ Enables.Button.get(')'));
        }
        if (exp.length()>0)
            if (Enables.Button.containsKey(s.charAt(exp.length()-1))){
                if (Enables.Button.get(s.charAt(exp.length()-1)).contains(but.getText().toString()))
                    return " ";
            }
        return "";
    }
}
