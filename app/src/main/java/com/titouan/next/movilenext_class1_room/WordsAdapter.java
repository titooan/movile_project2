package com.titouan.next.movilenext_class1_room;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WordViewHolder> {

    private List<Word> mWords;

    public WordsAdapter(List<Word> words) {
        mWords = words;
    }

    public WordsAdapter() { }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WordViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_word, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int position) {
        wordViewHolder.mTextView.setText(mWords.get(position).getWord());
    }

    @Override
    public int getItemCount() {
        return mWords == null ? 0 : mWords.size();
    }

    public void setWords(List<Word> words) {
        mWords = words;
        notifyDataSetChanged();
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textView)
        protected TextView mTextView;


        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
