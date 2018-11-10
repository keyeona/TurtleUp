package com.keyeonacole.turtleup;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import android.content.Intent;

import android.support.annotation.Nullable;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.my_app.moti.Phrases;

import java.util.List;
import java.util.Random;



/**
 * Implementation of App Widget functionality.
 */
public class MotiWidget extends AppWidgetProvider {


    static void updateAppWidget(final Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        // Construct the RemoteViews object
        final RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.moti_widget);
        LocalPharases phrases = new LocalPharases();

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        final String datbaseName = context.getString(R.string.database);
        final AppDatabase db = Room.databaseBuilder((context),
                AppDatabase.class, datbaseName).build();
        LiveData<List<Fact>> factLiveData = null;
        factLiveData = db.factDao().getFavorites();
        factLiveData.observeForever(new Observer<List<Fact>>() {
            @Override
            public void onChanged(@Nullable List<Fact> facts) {
                int count = facts.size();
                Random r = new Random();
                Toast.makeText(context, datbaseName, Toast.LENGTH_SHORT).show();
                if(count == 0){
                    String no_favs = context.getString(R.string.no_favorities);
                    views.setTextViewText(R.id.appwidget_text, no_favs);
                }else {
                    int i1 = r.nextInt(count - 0);
                    Fact  randomfact = facts.get(i1);
                    String widgetFact = randomfact.getFact();
                    views.setTextViewText(R.id.appwidget_text, widgetFact);
                }
            }
        });

        List<Fact> factList = factLiveData.getValue();
        //Fact testFact = factList.get(0);
        //String string = testFact.getFact();
        int phraseCount = phrases.getPhraseCounts(context);
        Random r = new Random();
        int i2 = r.nextInt(phraseCount - 0);
        String string = phrases.getPhrase(i2, context);
        views.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent);
        views.setTextViewText(R.id.appwidget_text, string);



        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }



    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);

        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }


}





