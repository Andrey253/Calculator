package com.boyko.calculator;

import android.widget.Button;
import android.widget.TextView;

import com.boyko.calculator.Enum.Enables;

public class InputChar {

    public boolean last_simbol_is_operator;
    public String inputChar;
    public int dif_count_bracket;

    public InputChar(String tvstring, String textbutton) {

        last_simbol_is_operator = Enables.Operator.contains(textbutton.charAt(0)) ? true : false;

        if (textbutton.contains("=")){

        }else
        if (textbutton.contains("+/-")){
            if (tvstring == "-")  inputChar =  "";
            else if (tvstring.length() == 0)
                inputChar =  "-";
            else
                try {
                    Double.toString(Double.parseDouble(tvstring));
                    if (tvstring.contains("-"))
                        inputChar =  tvstring.substring(1,tvstring.length());
                    else
                        inputChar =  "-" + tvstring;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

        } else if (textbutton.contains("cl")){
            inputChar =  "";
        } else if (textbutton.contains("back")) {

            String s = tvstring;

            if (s.length() > 0){

                inputChar =  s.substring(0, s.length() - 1);
            }
        } else if (enableButtonChar(textbutton, tvstring))
            {
                if (!textbutton.contains(")")){
                    inputChar =  tvstring + textbutton;
                }else if (CloseBracketEnable(tvstring)){
                    inputChar =  tvstring + ")";
                }
            }
    }

    private boolean CloseBracketEnable(String  tvstring) {
        String s = tvstring;
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
        dif_count_bracket = countOpenBracket - countCloseBracket -1;
        return countOpenBracket > countCloseBracket;
    }

    private boolean enableButtonChar(String textbutton, String tvstring) {

        String exp = tvstring;

        if (exp.length()>0)
        {
            if (Enables.Button.get(exp.charAt(exp.length()-1)).contains(textbutton)) {
                return true;
            }
        }else return true;

        return false;
    }
}
