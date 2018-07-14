package com.titouan.next.movilenext_class1_room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;

    private LiveData<List<Word>> mWords;

    public WordViewModel(Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mWords = mRepository.getWords();
    }

    public LiveData<List<Word>> getWords() {
        return mWords;
    }

    public void insert(String word) {
        mRepository.insert(word);
    }
}
