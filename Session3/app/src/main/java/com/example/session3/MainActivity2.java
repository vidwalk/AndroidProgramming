package com.example.session3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle myBundle = getIntent().getExtras();
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        btn2.setOnClickListener(closeActivity);
        btn3.setOnClickListener(emailIntent);
        if(myBundle != null && myBundle.containsKey(MainActivity.value))
        {
            // get value
            String c = myBundle.getString(MainActivity.value);

            Toast.makeText(this, "The value is: " + c, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "didn't get any values", Toast.LENGTH_SHORT).show();
        }
    }
    View.OnClickListener closeActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    View.OnClickListener emailIntent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "This is a test email");
            intent.putExtra(Intent.EXTRA_TEXT, "Test for the test of a test");

            if(intent.resolveActivity(getPackageManager()) != null)
            {
                startActivity(intent);
            }
        }
    };
}

