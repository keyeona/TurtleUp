package com.keyeonacole.turtleup;

import java.util.ArrayList;

public class Fact {
    private String title;
    private String type;
    private String imageLink;
    private String fact;
    private ArrayList<String> locations;
    private String diet;
    private String petRating;
    private String scientificName;
    private String landOrSea;
    private String id;
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
