package com.keyeonacole.turtleup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;

import java.io.IOException;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO: Do I initalize here?
        FirebaseApp.initializeApp(this);
        MainFragment mainFragment = null;
         try {
            mainFragment = new MainFragment();
        } catch (IOException e) {
            e.printStackTrace();
        }
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainerMain, mainFragment)
                .commit();
    }

}
