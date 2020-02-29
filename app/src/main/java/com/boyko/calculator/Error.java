package com.boyko.calculator;

import android.webkit.SafeBrowsingResponse;

import com.boyko.calculator.Enum.Enables;

public class Error {
    private boolean notErrors;
    private String inputString;
    private int dif_count_bracket;

    public boolean isNotErrors() {
        return notErrors;
    }

    public Error(String inputString, int dif_count_bracket) {

        notErrors = false;
        if (dif_count_bracket != 0){
            MainActivity.tvError.setText("не хватает скобок: "+ dif_count_bracket +" штук");
        }else if (Enables.CalcOperator.contains(inputString.charAt(inputString.length()-1))){
            MainActivity.tvError.setText("последний символ оператор, завершите выражение");
        }
        else {
            MainActivity.tvError.setText("");
            notErrors = true;

        }

    }


}
