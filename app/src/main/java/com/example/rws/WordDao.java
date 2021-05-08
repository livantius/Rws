package com.example.rws;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
    public interface WordDao {
        @Query("SELECT * FROM Word")
        List<Word> getAllWord();
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insertWord(Word word);
    }
