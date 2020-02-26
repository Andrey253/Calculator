package com.boyko.calculator;

import android.widget.Button;
import android.widget.TextView;

import com.boyko.calculator.Enum.Enables;

public class InputChar {

    public InputChar(TextView tv, Button b) {

        if (b.getText().toString().contains("=")){

        }else
        if (b.getText().toString().contains("+/-")){
            if (tv.getText().toString() == "-")  tv.setText("");
            else if (tv.getText().toString().length() == 0)
                tv.setText("-");
            else
                try {
                    Double.toString(Double.parseDouble(tv.getText().toString()));
                    if (tv.getText().toString().contains("-"))
                        tv.setText(tv.getText().toString().substring(1,tv.getText().toString().length()));
                    else
                        tv.setText("-" + tv.getText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

        } else if (b.getText().toString().contains("cl")){
            tv.setText("");
        } else if (b.getText().toString().contains("back")) {

            String s = tv.getText().toString();

            if (s.length() > 0){

                tv.setText(s.substring(0, s.length() - 1));
            }
        } else if (enableButtonChar(b, tv))
            {
                if (!b.getText().toString().contains(")")){
                    tv.setText( tv.getText().toString() + b.getText());
                }else if (CloseBracketEnable(tv)){
                    tv.setText( tv.getText().toString() + ")");
                }
            }
    }

    private boolean CloseBracketEnable(TextView tv) {
        String s = tv.getText().toString();
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
        return countOpenBracket > countCloseBracket;
    }

    private boolean enableButtonChar(Button but, TextView tv) {

        String exp = tv.getText().toString();

        if (exp.length()>0)
        {
            if (Enables.Button.get(exp.charAt(exp.length()-1)).contains(but.getText().toString())) {
                return true;
            }
        }else return true;

        return false;
    }
}
