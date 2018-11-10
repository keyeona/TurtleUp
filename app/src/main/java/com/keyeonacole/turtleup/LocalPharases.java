package com.keyeonacole.turtleup;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;

import butterknife.BindString;
import butterknife.ButterKnife;

public class LocalPharases {
        ArrayList<String > phrase = null;


        public ArrayList PhraseList(Context context) {

            String localPhrase1 = context.getString(R.string.local_phrase_1);
            String localPhrase2 = context.getString(R.string.local_phrase_2);
            String localPhrase3 = context.getString(R.string.local_phrase_3);
            String localPhrase4 = context.getString(R.string.local_phrase_4);
            String localPhrase5 = context.getString(R.string.local_phrase_5);
            String localPhrase6 = context.getString(R.string.local_phrase_6);
            String localPhrase7 = context.getString(R.string.local_phrase_7);
            String localPhrase8 = context.getString(R.string.local_phrase_8);
            String localPhrase9 = context.getString(R.string.local_phrase_9);
            String localPhrase10 = context.getString(R.string.local_phrase_10);
            String localPhrase11 = context.getString(R.string.local_phrase_11);
            String localPhrase12 = context.getString(R.string.local_phrase_12);
            String localPhrase13 = context.getString(R.string.local_phrase_13);
            String localPhrase14 = context.getString(R.string.local_phrase_14);
            String localPhrase15 = context.getString(R.string.local_phrase_15);
            String localPhrase16 = context.getString(R.string.local_phrase_16);
            String localPhrase17 = context.getString(R.string.local_phrase_17);



            phrase = new ArrayList<>();
            phrase.add(localPhrase1);
            phrase.add(localPhrase2);
            phrase.add(localPhrase3);
            phrase.add(localPhrase4);
            phrase.add(localPhrase5);
            phrase.add(localPhrase6);
            phrase.add(localPhrase7);
            phrase.add(localPhrase8);
            phrase.add(localPhrase9);
            phrase.add(localPhrase10);
            phrase.add(localPhrase11);
            phrase.add(localPhrase12);
            phrase.add(localPhrase13);
            phrase.add(localPhrase14);
            phrase.add(localPhrase15);
            phrase.add(localPhrase16);
            phrase.add(localPhrase17);
            return phrase;
        }

        public int getPhraseCounts(Context context){
            int count = PhraseList(context).size();
            return count;
        }

        public String getPhrase(int i, Context context){
            String string = (String) PhraseList(context).get(i);
            return string;
        }

}
