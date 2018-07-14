package com.titouan.next.movilenext_class1_room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "words_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    @NonNull
    public String getWord() {
        return mWord;
    }

    public Word(@NonNull String word) {
        mWord = word;
    }
}
