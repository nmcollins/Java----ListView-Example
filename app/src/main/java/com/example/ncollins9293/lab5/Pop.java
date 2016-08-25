package com.example.ncollins9293.lab5;

/**
 * Created by Nicholas on 2016-07-03.
 */

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;


//More elaborate than a simple toast, we can use a Pop class to display
//information about the item that was clicked by using this class
public class Pop extends Activity {

    //Get information about the layout, use that to display a picture nicely
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        //Popups do not completely take over the screen, they should be a bit
        //smaller than the view they are superimposed on top of.
        getWindow().setLayout((int)(width * .8), (int)(height * .6));
        TextView tvInfo = (TextView)findViewById(R.id.tvPopUp);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String data= extras.getString("POP_INFO");
            if (data!= null) {
                tvInfo.setText(data);
                //Since Data could exceed the size of the PopUp Window, we will allow scrolling
                tvInfo.setMovementMethod(new ScrollingMovementMethod());
            }
            int picNum = extras.getInt("PICNUM");
            ImageView ivToast = (ImageView) findViewById(R.id.ivPopUp);

            ivToast.setImageResource(picNum);
        }
    }
}
