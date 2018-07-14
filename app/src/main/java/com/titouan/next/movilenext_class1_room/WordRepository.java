package com.titouan.next.movilenext_class1_room;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;

    private LiveData<List<Word>> mWords;

    public WordRepository(Application application) {
        mWordDao = WordRoomDatabase.getInstance(application).wordDao();
        mWords = mWordDao.getAll();
    }

    public void insert(String word) {
        new InsertAsyncTask(mWordDao).execute(new Word(word));
    }


    private static class InsertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mDao;

        InsertAsyncTask(WordDao dao) {
            mDao = dao;
        }


        @Override
        protected Void doInBackground(Word... words) {
            for (Word word : words) {
                mDao.insert(word);
            }

            return null;
        }
    }

    public LiveData<List<Word>> getWords() {
        return mWords;
    }
}
