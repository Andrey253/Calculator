package com.boyko.calculator;

import com.boyko.calculator.Enum.Enables;

public class InputChar {

    public boolean isLastCharOperator() {
        return last_is_operator;
    }

    public String getInputString() {
        return inputStringThis;
    }

    public int getDif_count_bracket() {
        return dif_count_bracket;
    }

    private boolean last_is_operator;
    private String inputStringThis;
    private int dif_count_bracket;

    public InputChar(String tvstring, String textbutton) {

        if (tvstring.equals("Infinity") || tvstring.equals("-Infinity")){
            inputStringThis = textbutton;
        }
        else {
            last_is_operator = Enables.Operator.contains(textbutton.charAt(0)) ? true : false;

            if (textbutton.contains("+/-")){
                if (tvstring.length() == 0)
                    inputStringThis =  "-";
                else
                    inputStringThis = (tvstring.charAt(0) == '-') ? tvstring.substring(1,tvstring.length()) : "-" + tvstring;

            }
            else if (textbutton.contains("cl")){
                inputStringThis =  "";
                if (!MainActivity.stackStatic.empty()) MainActivity.stackStatic.pop();
            }
            else if (textbutton.contains(".") && tvstring.length() == 0){
                inputStringThis =  "0.";
            }
            else if (textbutton.contains(".") && Enables.CalcOperator.contains(tvstring.charAt(tvstring.length()-1))){
                inputStringThis =  tvstring +"0.";
            }
            else if (textbutton.contains("back")) {
                String s = tvstring;
                inputStringThis = (s.length() > 0) ?  s.substring(0, s.length() - 1) : "";

            }
            else if (enableButtonChar(tvstring, textbutton)){

                inputStringThis = (!textbutton.contains(")")) ? tvstring + textbutton : (CloseBracketEnable(tvstring)) ? tvstring + ")" : tvstring;
            }
            else inputStringThis = tvstring;

            CloseBracketEnable(inputStringThis);
        }
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

        if (tvstring.length()>0){
            if (Enables.Button.get(tvstring.charAt(tvstring.length()-1)).contains(textbutton)) {
                return true;
            }
        }
        else {
            return !Enables.NotFirst.contains(textbutton);
        }
        return false;
    }
}
