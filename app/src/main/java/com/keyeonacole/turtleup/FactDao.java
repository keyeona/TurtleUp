package com.keyeonacole.turtleup;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface FactDao {

    @Insert
    void insertSingleFact(Fact fact);

    @Query("SELECT * FROM fact WHERE id IN (:factIds)")
    List<Fact> loadAllByIds(int[] factIds);

    @Query("SELECT * FROM fact")
    LiveData<List<Fact>> getFavorites();

    @Delete
    void delete(Fact fact);

    @Query("SELECT * FROM fact WHERE id LIKE :id")
    LiveData<List<Fact>> loadAllByFavorites(int id);

}
