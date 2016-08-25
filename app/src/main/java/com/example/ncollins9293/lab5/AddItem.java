package com.example.ncollins9293.lab5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageSwitcher;


/**
 * Created by Nicholas on 2016-07-05.
 */

//Class to encapsulate functions for adding an item to ListView
public class AddItem extends AppCompatActivity {

    @Override
    //Setup addItem function and go to another Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additem);

        Button addItem = (Button) findViewById(R.id.btnAdd);

        addItem.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                EditText etDescription = (EditText) findViewById(R.id.etDescription);
                EditText etOpinion = (EditText) findViewById(R.id.etOpinion);

                Intent intent = new Intent(AddItem.this, MainActivity.class);
                String name = etDescription.getText().toString();
                String opinion = etOpinion.getText().toString();
                intent.putExtra("pictureName", name);
                intent.putExtra("opinion", opinion);
                intent.putExtra("picture", 1);
                startActivity(intent);
            }
        });
    }
}
