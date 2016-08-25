package com.example.ncollins9293.lab5;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ncollins9293 on 6/29/2016.
 */

//From the instructions: Custom Adapter – this class consists of the items that will be the
// nodes for data structure in the custom layout. Each node will consist of a position ID,
// a Text View, and an Image View.
//This Adapter does, as is typical, tie together the data with the row objects that end up in
//the ListView.  The exact data is set up in detail in the PictureDataProvider class.
//This Adapter puts together a Text View, Image View

public class CustomAdapter extends ArrayAdapter{

    List list = new ArrayList();


    //Basic Constructor
    public CustomAdapter(Context context, int resource) {
        super(context, resource);
    }


    //Encapsulate data used in ListItems
    //Note:positionid is not explicitly defined here because an Adapter like this, used with
    //a ListView, gives you a position as used in methods below
    static class DataHandler
    {
        ImageView MainImage;
        TextView name;
        TextView opinion;
    }


    //Simple add method to add objects to list
    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    //Get number of items in list
    @Override
    public int getCount() {
        return this.list.size();
    }

    //Retrieve a specific item based on position
    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    //View functions to process a row in the ListView, get objects from layout to use and populate
    //them
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
           row = convertView;
           DataHandler handler;

           if(convertView == null)
           {
               LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               row = inflater.inflate(R.layout.row_layout, parent, false);
               handler = new DataHandler();
               handler.MainImage = (ImageView) row.findViewById(R.id.picture_view);
               handler.name = (TextView) row.findViewById(R.id.picture_title);
               handler.opinion = (TextView) row.findViewById(R.id.Picture_Opinions);
               row.setTag(handler);
           }
        else
           {
               handler = (DataHandler) row.getTag();
           }

        PictureDataProvider dataProvider;
        dataProvider = (PictureDataProvider) this.getItem(position);
        handler.MainImage.setImageResource(dataProvider.getPicture_resource());
        handler.name.setText(dataProvider.getPicture_name());
        handler.opinion.setText(dataProvider.getPicture_opinion());

        return row;
    }
}
