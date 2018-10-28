package com.keyeonacole.turtleup;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface FactDao {
    @Query("SELECT * FROM fact WHERE id IN (:factIds)")
    List<Fact> loadAllByIds(int[] factIds);
}
