package com.example.rws;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private WordListAdapter wordListAdapter;
    static WordRoomDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        loadWordsList();

        FloatingActionButton button = findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddWordActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.RV);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        db = WordRoomDatabase.getDbInstance(getApplicationContext());
        List<Word> wordList = db.wordDao().getAllWord();
        wordListAdapter = new WordListAdapter(wordList);
        recyclerView.setAdapter(wordListAdapter);
    }
    private void loadWordsList(){
        WordRoomDatabase db = WordRoomDatabase.getDbInstance(this.getApplicationContext());
        List<Word> wordList = db.wordDao().getAllWord();
        wordListAdapter.setUserList(wordList);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100){
            loadWordsList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadWordsList();
    }
}