package com.boyko.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.boyko.calculator.Enum.Enables;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    public static TextView tvError;
    private Button button;
    private StacksBuilder stacksBuilder;
    private Calculator calculator;
    private InputChar inputChar;
    private String inpStringThis;
    private Error error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        tv.setText("");
        tvError = findViewById(R.id.textViewError);
    }
    public void onClickButton(View v)
        {
            button = (Button) v;
            inputChar = new InputChar(tv.getText().toString(), button.getText().toString());
            inpStringThis =inputChar.getInputString();
            tv.setText(inpStringThis);
        }
    public void onClickEqually(View v)
        {
           error = new Error(inpStringThis, inputChar.getDif_count_bracket());

          if (error.isNotErrors())
           {
                stacksBuilder = new StacksBuilder(tv.getText().toString());
                calculator = new Calculator(stacksBuilder.stackinput);
               String s = String.format("%.12f", calculator.getResult());
               s = s .replace(",",".");
               while (s.charAt(s.length()-1) == '0') s = s.substring(0,s.length()-1);
               if (s.charAt(s.length()-1) == '.') s = s.substring(0,s.length()-1);

                tv.setText("" + s);
            }
        }
}
