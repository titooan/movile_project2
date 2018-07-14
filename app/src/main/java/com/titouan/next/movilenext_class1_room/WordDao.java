package com.titouan.next.movilenext_class1_room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Insert
    void insert(List<Word> words);

    @Query("DELETE FROM words_table")
    void clearAll();

    @Query("SELECT * FROM words_table ORDER BY word")
    LiveData<List<Word>> getAll();
}
