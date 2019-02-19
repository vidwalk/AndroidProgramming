package com.example.session2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    Button button;
    EditText text1;
    EditText text2;
    Button grow;
    Button shrink;
    ProgressBar bar;
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        button = findViewById(R.id.button);
        text1 = findViewById(R.id.editText);
        text2 = findViewById(R.id.editText2);
        text1.setHint("user@email.com");
        text2.setHint("ILOVEAND");
        grow = findViewById(R.id.button2);
        shrink = findViewById(R.id.button3);
        bar = findViewById(R.id.progressBar);
        if(savedInstanceState != null) {
            Log.d(TAG, "OnCreate() Restoring previous state");
        }
        else {
            Log.d(TAG, "OnCreate() No saved state available");
        }

        grow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                bar.setProgress(bar.getProgress() + 10);
            }
        });
        shrink.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                bar.setProgress(bar.getProgress() - 10);
            }
        });
    }

    public void login(View v)
    {
        if(text1.getText().toString().equals("user@email.com") && text2.getText().toString().equals("ILOVEAND"))
            Toast.makeText(MainActivity4.this, "You are logged in", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity4.this, "Try again", Toast.LENGTH_SHORT).show();
    }

}
