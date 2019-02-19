package com.example.session2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        if(savedInstanceState != null) {
            Log.d(TAG, "OnCreate() Restoring previous state");
        }
        else {
            Log.d(TAG, "OnCreate() No saved state available");
        }
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                button.setText("THANKS!");
            }
        });
    }
}
