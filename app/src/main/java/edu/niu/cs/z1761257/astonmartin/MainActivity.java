//Author: Pravin Kandala - z1761257
//Assignment 2 - Using Intents and Widgets


package edu.niu.cs.z1761257.astonmartin;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner modelSpin;
    private ImageView carIV;
    private Button detailBtn;

    public int newPosition = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Connecting to the screen
        modelSpin = (Spinner)findViewById(R.id.modelSpinner);
        carIV = (ImageView)findViewById(R.id.carImageView);
        detailBtn = (Button)findViewById(R.id.button);


        //creating arrayadapter for spinner
        ArrayAdapter<String> model = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_layout,Models.names);

        modelSpin.setAdapter(model);

        //set title of spinner
        modelSpin.setPrompt("Select model");

        //when user selects spinner option
        modelSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //adding image resource
                carIV.setImageResource(Models.id[position]);

                //variable for intent
                newPosition = position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });//end of setOnItemSelectedListener


    }//end of onCreate

    //Button function to send intent to other screen
    public void goDetail(View view){
        Intent nameIntent = new Intent(this, Description.class);

        //sending newPosition by intent to other screen
        nameIntent.putExtra("detailPage", newPosition);
        startActivity(nameIntent);
    }//end of goDetail


}//end of MainActivity

