package com.boyko.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);

    }
    public void onClickButton(View v)
        {
            CharIn charIn = new CharIn(tv, (Button) v);
        }
    public void onClickequally(View v)
        {
            Calculator calculator = new Calculator(tv.getText().toString());
        }
}
