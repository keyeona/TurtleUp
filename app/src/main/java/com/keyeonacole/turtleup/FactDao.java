package com.keyeonacole.turtleup;

public interface FactDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

}
