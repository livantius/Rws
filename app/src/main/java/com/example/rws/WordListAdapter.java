package com.example.rws;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.MyViewHolder> {
    private List<Word> wordList;
    public  WordListAdapter(List<Word> wordList){
        this.wordList = wordList;
    }

    public void setUserList(List<Word> wordsList){
        this.wordList = wordsList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public WordListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.MyViewHolder holder, int position) {
        holder.textViewWord.setText(wordList.get(position).word);

    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textViewWord;

        public MyViewHolder(View view){
            super(view);
            textViewWord = view.findViewById(R.id.textViewWord);
        }
    }
}
