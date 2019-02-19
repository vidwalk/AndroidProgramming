package com.example.session2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "Startup";
    private static final String ACTIONTAG = "Click";
    private static final String ActivityLifecycle = "Changed";

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(ActivityLifecycle, "On Create started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "ContentView = set");

        button = findViewById(R.id.button);

        Log.d(TAG, "Setting up onClick listener");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(ACTIONTAG, "User clicked");
                button.setText("Ok");
                Toast.makeText(MainActivity2.this, "Please stop", Toast.LENGTH_SHORT).show();
            }
        });

        Log.d(TAG, "Changing button text");
        button.setText("Click me bish");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(ActivityLifecycle, "On Start started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(ActivityLifecycle, "On Resume started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(ActivityLifecycle, "On Pause started");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(ActivityLifecycle, "On Restart started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(ActivityLifecycle, "On Stop started");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(ActivityLifecycle, "On Destroy started");
    }
}
