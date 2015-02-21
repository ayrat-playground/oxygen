package com.badykov.ayrat.swkazan;

import android.media.Image;

/**
 * Created by ayrat on 2/17/15.
 */
public class NamedImage {
    private String name;
    private int imageID;

    public NamedImage(String name, int imageID){

        this.name=name;
        this.imageID=imageID;
    }

    public String getName(){
        return name;
    }
    public int getImage(){
        return imageID;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setImage(int imageID){
        this.imageID=imageID;
    }

}
