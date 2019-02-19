package com.example.session2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity5 extends AppCompatActivity {
    EditText result;
    int sum =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        result = findViewById(R.id.editText3);
    }

    public void buttonClick(View v)
    {
        switch(v.getId())
        {
            case R.id.button4:
                result.setText(result.getText().toString() + "1");
                break;
            case R.id.button5:
                result.setText(result.getText().toString() + "2");
                break;
            case R.id.button6:
                result.setText(result.getText().toString() + "3");
                break;
            case R.id.button7:
                result.setText(result.getText().toString() + "4");
                break;
            case R.id.button8:
                result.setText(result.getText().toString() + "5");
                break;
            case R.id.button9:
                result.setText(result.getText().toString() + "6");
                break;
            case R.id.button10:
                result.setText(result.getText().toString() + "7");
                break;
            case R.id.button11:
                result.setText(result.getText().toString() + "8");
                break;
            case R.id.button12:
                result.setText(result.getText().toString() + "9");
                break;
            case R.id.button13:
                sum = 0;
                result.setText("" + sum);
                break;
            case R.id.button14:
                result.setText(result.getText().toString() + "0");
                break;
            case R.id.button15:
                if(result.getText().toString().contains("+")) {
                    String split[] = result.getText().toString().split(java.util.regex.Pattern.quote("+"));
                    for(int i = 0; i < split.length; i++)
                    sum = sum + Integer.parseInt(split[i]);
                    result.setText("" + sum);
                }
                else
                {
                    result.setText(result.getText().toString() + "+");
                }
                break;
        }
    }
}
