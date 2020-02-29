package com.boyko.calculator;

import android.widget.Button;
import android.widget.TextView;

import com.boyko.calculator.Enum.Enables;

public class InputChar {

    public boolean last_simbol_is_operator;
    public String inputString;
    public int dif_count_bracket;

    public InputChar(String tvstring, String textbutton) {

        last_simbol_is_operator = Enables.Operator.contains(textbutton.charAt(0)) ? true : false;

        if (textbutton.contains("+/-")){
            if (tvstring == "-")  inputString =  "";
            else if (tvstring.length() == 0)
                inputString =  "-";
            else
                try {
                    Double.toString(Double.parseDouble(tvstring));
                    if (tvstring.contains("-"))
                        inputString =  tvstring.substring(1,tvstring.length());
                    else
                        inputString =  "-" + tvstring;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

        } else if (textbutton.contains("cl")){
            inputString =  "";
        } else if (textbutton.contains(".") && tvstring.length() == 0){
            String s = "0.";
        }
        else if (textbutton.contains("back")) {

            String s = tvstring;

            if (s.length() > 0){

                inputString =  s.substring(0, s.length() - 1);
            }
        } else if (enableButtonChar(tvstring, textbutton))
            {
                if (!textbutton.contains(")")){
                    inputString =  tvstring + textbutton;
                }else if (CloseBracketEnable(tvstring)){
                    inputString =  tvstring + ")";
                } else inputString = tvstring;
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
