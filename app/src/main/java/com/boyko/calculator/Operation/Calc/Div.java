package com.boyko.calculator.Operation.Calc;

import com.boyko.calculator.MainActivity;
import com.boyko.calculator.Operation.Operation;

import java.util.Stack;

public class Div extends Operation {
    public Div(int priority) {
        super(priority);
    }

    public void exec(Stack stDouble) {

        Double double_up = (Double) stDouble.pop();
        Double double_down = (Double) stDouble.pop();

            if (double_up != 0.0){
                stDouble.push(double_down / double_up);

            }
            else{
                MainActivity.tvError.setText("Деление на ноль");
                try {
                    stDouble.push(double_down / double_up);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }

    @Override
    public int getPriority() {
        return super.getPriority();
    }
}
