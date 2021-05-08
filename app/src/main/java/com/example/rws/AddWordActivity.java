package com.example.rws;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class AddWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_words);
        EditText word = findViewById(R.id.editTextTextPersonName);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewWord(word.getText().toString());
            }
        });
    }
    private void addNewWord(String word){
        WordRoomDatabase db = WordRoomDatabase.getDbInstance(this.getApplicationContext());
        Word words = new Word();
        words.word = word;

        db.wordDao().insertWord(words);
        finish();
    }
}