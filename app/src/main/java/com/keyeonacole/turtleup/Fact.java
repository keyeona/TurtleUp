package com.keyeonacole.turtleup;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Fact {
    @ColumnInfo(name = "name")
    private String title;
    @ColumnInfo(name = "type")
    private String type;
    @ColumnInfo(name = "imageLink")
    private String imageLink;
    @ColumnInfo(name = "theFact")
    private String fact;
    @ColumnInfo(name = "locations")
    private ArrayList<String> locations;
    @ColumnInfo(name = "diet")
    private String diet;
    @ColumnInfo(name = "petRating")
    private String petRating;
    @ColumnInfo(name = "scientificName")
    private String scientificName;
    @ColumnInfo(name = "landOrSea")
    private String landOrSea;
    @PrimaryKey
    private String id;
    @ColumnInfo(name = "application")
    private  String application;


    public Fact(String title, String type, String imageLink, String fact, ArrayList<String> locations, String diet, String petRating, String scientificName,
                String landOrSea, String application, String id){
                           this.title = title;
                           this.type = type;
                           this.imageLink = imageLink;
                           this.fact = fact;
                           this.locations = locations;
                           this.diet = diet;
                           this.petRating = petRating;
                           this.scientificName = scientificName;
                           this.landOrSea = landOrSea;
                           this.application = application;
                           this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getFact() {
        return fact;
    }

    public ArrayList<String> getLocations() {
        return locations;
    }

    public String getDiet() {
        return diet;
    }

    public String getPetRating() {
        return petRating;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getLandOrSea() {
        return landOrSea;
    }

    public String getApplication() {return application;}

    public String getId() {
        return id;
    }
}
