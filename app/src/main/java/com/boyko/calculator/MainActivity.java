package com.boyko.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private StacksBuilder stacksBuilder;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
    }
    public void onClickButton(View v)
        {
            new InputChar(tv, (Button) v);
        }
    public void onClickequally(View v)
        {
            stacksBuilder = new StacksBuilder(tv.getText().toString());
            calculator = new Calculator(stacksBuilder.stackObj);
            tv.setText(calculator.getResult().toString());
        }
}
