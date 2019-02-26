package com.example.session3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static String value;
    private TextView text2;
    private TextView text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        Button btn4 = (Button) findViewById(R.id.button4);
        Button btn5 = (Button) findViewById(R.id.button5);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        btn.setOnClickListener(detailClicked);
        btn4.setOnClickListener(iLoveIt);
        btn5.setOnClickListener(iLoveItMore);
    }

    View.OnClickListener detailClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            value = "SendDataOver";
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra(value, value);
            startActivity(intent);
        }
    };

    View.OnClickListener iLoveIt = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text2.setText(getResources().getString(R.string.exercise7));
            text3.setText(getResources().getString(R.string.exercise7));
            //text3.setBackground(getResources().getColor(R.color.colorExercise7));
        }
    };

    View.OnClickListener iLoveItMore = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text2.setText(getResources().getString(R.string.exercise8));
            text3.setText(getResources().getString(R.string.exercise8));
            //text3.setBackground(getResources().getColor(R.color.colorExercise8));
        }
    };
}