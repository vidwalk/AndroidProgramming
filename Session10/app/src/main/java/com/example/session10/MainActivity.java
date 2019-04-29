package com.example.session10;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;
    private EditText editText;
    private TextView textView;
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        progressBar = findViewById(R.id.progressBar);
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                if (!notes.isEmpty()) {
                    textView.setText("");
                    for (Note n : notes) {
                        textView.append(n.getTitle() + "\n");
                    }
                } else {
                    textView.setText("Empty");
                }
            }
        });
        noteViewModel.isSaving().observe(this, new Observer<Boolean>(){
            @Override
            public void onChanged(@Nullable Boolean isSaving) {
                if (isSaving) {
                progressBarAsync progress = new progressBarAsync();
                progress.execute(0);
                }
            }
        });
    }

    public void saveNote(View v) {

        noteViewModel.insert(new Note(editText.getText().toString(), "description", 1));
    }

    public void deleteAllNotes(View v) {
        noteViewModel.deleteAllNotes();
    }

    private class progressBarAsync extends AsyncTask<Integer, Void, Void> {
        @Override
        protected Void doInBackground(final Integer... params) {
            new Thread(new Runnable() {
                public void run() {
                    progressStatus = params[0];
                    while (progressStatus < 100) {
                        progressStatus += 1;
                        // Update the progress bar
                        handler.post(new Runnable() {
                            public void run() {
                                progressBar.setProgress(progressStatus);
                            }
                        });
                        try {
                            // Sleep for 200 milliseconds.
                            // This will give a total of 2 seconds = 2000 milliseconds
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
            return null;
        }
        protected void onPostExecute() {
            noteViewModel.doneSaving();
        }
    }
}
