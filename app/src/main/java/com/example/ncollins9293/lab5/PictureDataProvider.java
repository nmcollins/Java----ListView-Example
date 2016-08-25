package com.example.ncollins9293.lab5;

/**
 * Created by Ncollins9293 on 6/29/2016.
 */
//From the instructions: Each node will consist of a position ID,
// a Text View, and an Image View.

//This class does processing of pictures
public class PictureDataProvider {
    private int picture_resource;
    private String picture_name;
    private String picture_opinion;
    private int position_id;

    //Pictures are loaded from resources and we need to manage them via this provider class
    public PictureDataProvider(int picture_resource, String picture_name, String picture_opinion, int positionNumber) {
        this.setPicture_resource(picture_resource);
        this.setPicture_name(picture_name);
        this.setPicture_opinion(picture_opinion);
        this.setPosition_id(positionNumber);
    }

    //Retrieve a picture resource, i.e. a specific number to identify a picture
    public int getPicture_resource() {
        return picture_resource;
    }

    //Set the number of a picture so it can later be retrieved by that id number
    public void setPicture_resource(int picture_resource) {
        this.picture_resource = picture_resource;
    }

    //Find the position id of a picture resources
    public int getPosition_id() {
        return position_id;
    }

    //Set the position id of a picture resource
    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    //get the picture name
    public String getPicture_name() {
        return picture_name;
    }

    //set the picture name
    public void setPicture_name(String picture_name) {
        this.picture_name = picture_name;
    }

    //get the opinion associated with a picture
    public String getPicture_opinion() {
        return picture_opinion;
    }

    //set the opinion associated with a picture
    public void setPicture_opinion(String picture_opinion) {
        this.picture_opinion = picture_opinion;
    }
}
