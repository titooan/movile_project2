package com.titouan.next.movilenext_class1_room;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final int NEW_WORD_REQUEST = 1;
    public static final String EXTRA_WORD = "extra_word";

    @BindView(R.id.recyclerView)
    protected RecyclerView mRecyclerView;

    private WordsAdapter mAdapter;
    private WordViewModel mWordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view ->
                startActivityForResult(NewWordActivity.getStartIntent(this), NEW_WORD_REQUEST));

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);

        setupRecyclerView();

//        mWordViewModel.insert("Plop");
//
//        LiveData<List<Word>> words = mWordViewModel.getWords();
//
//        for (Word word : words.getValue()) {
//            Log.d("Word: ", word.getWord());
//        }
    }

    private void setupRecyclerView() {
        mAdapter = new WordsAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mWordViewModel.getWords().observe(this, mAdapter::setWords);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == NEW_WORD_REQUEST && resultCode == RESULT_OK) {
            String word = data.getStringExtra(EXTRA_WORD);
            if(!TextUtils.isEmpty(word)) {
                mWordViewModel.insert(word);
            }
        }

    }
}
