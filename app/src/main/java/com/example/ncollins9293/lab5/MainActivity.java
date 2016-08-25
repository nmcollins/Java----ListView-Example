package com.example.ncollins9293.lab5;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//MainActivity class gets the pictures, starts setting up the ListView
public class MainActivity extends ListActivity {

    public static int[] picture_view_resource_array = {R.drawable.chrysanthemum, R.drawable.desert,
                                   R.drawable.hydrangeas, R.drawable.jellyfish,
                                   R.drawable.koala, R.drawable.lighthouse,
                                   R.drawable.penguins, R.drawable.tulips};

    List<Integer> picture_view_resource = new ArrayList<Integer>();

    List<String> picture_names = new ArrayList<String>();
    List<String> picture_opinions = new ArrayList<String>();
    public static CustomAdapter adapter;


    @Override
    //Get all resources needed to start loading data into the items to appear
    //in the ListView
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int i = 0;
        Bundle b = getIntent().getExtras();

        String[] picture_opinions2 = getResources().getStringArray(R.array.Picture_Opinions);
        for (int z=0; z<picture_opinions2.length; z++) {
            picture_opinions.add(picture_opinions2[z]);
        }

       // picture_opinions = getResources().getStringArray(R.array.Picture_Opinions);
        String[] picture_names2 = (getResources().getStringArray(R.array.Picture_Titles));

        for (int z=0; z<picture_names2.length; z++) {
            picture_names.add(picture_names2[z]);
        }

        for (int z=0; z<picture_view_resource_array.length;z++)
        {
            picture_view_resource.add(picture_view_resource_array[z]);
        }

        adapter = new CustomAdapter(getApplicationContext(), R.layout.row_layout);
        String picturename;
        String opinion;
        int picNumber = 0;

        if(b != null) {
            picturename = b.getString("pictureName");
            opinion = b.getString("opinion");
            picNumber = b.getInt("picture");
            picture_names.add(picturename);
            picture_opinions.add(opinion);
            picture_view_resource.add(picture_view_resource_array[picNumber]);

           /* PictureDataProvider dataProvider = new PictureDataProvider(picNumber,
                    picturename, opinion, adapter.getCount()+1);
            adapter.add(dataProvider);*/
        }
        setListAdapter(adapter);

        //From the instructions:  "Every time you click on an item in your list will produce a
        // toast message of the text within that node."
        //This code will set an appropriate click listener to accomplish this.
        //Actually, what we do is more elaborate than a toast message, we created a Pop
        //activity that will display the text information and a bigger version of the image.
        ListView listView = getListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> av, View view, int j, long l) {
                Intent popIntent = new Intent(MainActivity.this, Pop.class);
                popIntent.putExtra("POP_INFO", picture_names.get(j));
                int PicId = getResources().getIdentifier(String.valueOf(picture_view_resource.get(j)), "drawable", getPackageName());
                popIntent.putExtra("PICNUM", PicId);
                startActivity(popIntent);
            }
        });

        //Go to the add item activity when button is clicked
        Button addItem = (Button) findViewById(R.id.btnAddNew);
        addItem.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent addItem = new Intent(MainActivity.this, AddItem.class);
                addItem.putExtra("TOTAL", adapter.getCount());
                startActivityForResult(addItem, 1);

            }
        });


    for(String names:picture_names) {
            //From the instructions: . Each node will consist of a position ID, a Text View, and an
            // Image View.  The constructor used below uses data that will populate these objects
            // along with the position id.  Therefore, each dataProvider object that is used by
            //the adapater will have all of these components.
            PictureDataProvider dataProvider = new PictureDataProvider(picture_view_resource.get(i),
                    names, picture_opinions.get(i), i);
            adapter.add(dataProvider);
            i++;
        }
    }

}
