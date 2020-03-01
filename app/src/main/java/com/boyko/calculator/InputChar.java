package com.boyko.calculator;

import android.widget.Button;
import android.widget.TextView;

import com.boyko.calculator.Enum.Enables;

public class InputChar {

    public boolean isLastCharOperator() {
        return last_is_operator;
    }

    public String getInputString() {
        return inputString;
    }

    public int getDif_count_bracket() {
        return dif_count_bracket;
    }

    private boolean last_is_operator;
    private String inputString;
    private int dif_count_bracket;

    public InputChar(String tvstring, String textbutton) {

        last_is_operator = Enables.Operator.contains(textbutton.charAt(0)) ? true : false;

        if (textbutton.contains("+/-")){
            if (tvstring == "-")  inputString =  "";
            else if (tvstring.length() == 0)
                inputString =  "-";
            else
                inputString = (tvstring.charAt(0) == '-') ? tvstring.substring(1,tvstring.length()) : "-" + tvstring;

        }
        else if (textbutton.contains("cl")){
            inputString =  "";
        }
        else if (textbutton.contains(".") && tvstring.length() == 0){
            inputString =  "0.";
        }
        else if (textbutton.contains(".") && Enables.CalcOperator.contains(tvstring.charAt(tvstring.length()-1))){
            inputString =  tvstring +"0.";
        }
        else if (textbutton.contains("back")) {

            String s = tvstring;
            inputString = (s.length() > 0) ?  s.substring(0, s.length() - 1) : "";

        }
        else if (enableButtonChar(tvstring, textbutton)){

            inputString = (!textbutton.contains(")")) ? tvstring + textbutton : (CloseBracketEnable(tvstring)) ? tvstring + ")" : tvstring;
            }
        else inputString = tvstring;

        CloseBracketEnable(inputString);
    }

    private boolean CloseBracketEnable(String  s) {

        int pos = s.length();
        int countCloseBracket=0;
        int countOpenBracket=0;
        while (pos >0){
            pos--;
                if (s.charAt(pos)==')')
                    countCloseBracket++;
                if (s.charAt(pos)=='(')
                    countOpenBracket++;
        }
        this.dif_count_bracket = countOpenBracket - countCloseBracket;
        return countOpenBracket > countCloseBracket;
    }

    private boolean enableButtonChar(String tvstring, String textbutton) {

        if (tvstring.length()>0)
        {
            if (Enables.Button.get(tvstring.charAt(tvstring.length()-1)).contains(textbutton)) {
                return true;
            }
        }else return true;

        return false;
    }
}
