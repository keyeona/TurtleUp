package com.example.my_app.moti;

import java.util.ArrayList;

public class Phrases {
    ArrayList<String > phrase = null;

    public ArrayList PhraseList() {
        phrase = new ArrayList<>();
        phrase.add("You can do it!!!!!!");
        phrase.add("Hey! You're doing great!");
        phrase.add("Every failure is a success, you've learned something new");
        phrase.add("Don't worry even I mke mstcakes");
        phrase.add("I woke up on the wrong side of the bed, sooo I went back to bed and tried it again");
        phrase.add("I’ve just written a song about tortillas; actually, it’s more of a rap.");
        phrase.add("You know what I just found perfection! It's in the dictionary, so far that the only place I've seen it");
        phrase.add("I recently decided to sell my vacuum cleaner as all it was doing was gathering dust.");
        phrase.add("Chooo Choooo just slowly chigging a long");
        phrase.add("Let's take a moment to reflect on something wonderful today!");
        phrase.add("The best thing about today is you!");
        phrase.add("Yeah, hugs are nice. I could really go for a hug right now. C'mon bring it in..");
        phrase.add("You know what 0 + 0 is? Well I can tell you it the number of time you need to harshly criticize your work.");
        phrase.add("How's it going? Just wanted to say that I think you are doing good! Can't wait to see what's next.");
        phrase.add("Don't stop believing ...ooooo o o");
        phrase.add("Thanks for being a great person!");
        phrase.add("Weeeeee! When life gives you rollercoasters I just enjoy the ride!!");
        return phrase;
    }

    public int getPhraseCounts(){
        int count = PhraseList().size();
        return count;
    }

    public String getPhrase(int i){
        String string = (String) PhraseList().get(i);
        return string;
    }
}
