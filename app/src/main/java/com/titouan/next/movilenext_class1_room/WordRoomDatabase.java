package com.titouan.next.movilenext_class1_room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    private static final String WORD_DATABASE = "word_database";

    private static WordRoomDatabase sInstance;

    public abstract WordDao wordDao();

    static WordRoomDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (WordRoomDatabase.class) {
                if (sInstance == null) {
                    sInstance =
                            Room.databaseBuilder(
                                context,
                                WordRoomDatabase.class,
                                WORD_DATABASE)
                            .build();
                }
            }
        }

        return sInstance;
    }
}
