package com.example.rws;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "word")
public class Word {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "word")
    public String word;
}
