package com.boyko.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Button button;
    private StacksBuilder stacksBuilder;
    private Calculator calculator;
    private InputChar inputChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
    }
    public void onClickButton(View v)
        {
            button = (Button) v;
            inputChar = new InputChar(tv.getText().toString(), button.getText().toString());
            tv.setText(inputChar.inputChar);
        }
    public void onClickequally(View v)
        {
            int ccbr = inputChar.dif_count_bracket;
            stacksBuilder = new StacksBuilder(tv.getText().toString());
            calculator = new Calculator(stacksBuilder.stackObj);
            tv.setText(calculator.getResult().toString());
        }
}
