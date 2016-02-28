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
  //  private TextView titleTV;
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
       // titleTV = (TextView)findViewById(R.id.titleTextView);


        ArrayAdapter<String> model = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_layout,Models.names);

        modelSpin.setAdapter(model);
        modelSpin.setPrompt("Select model");

        modelSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String presentName;

                presentName = parent.getItemAtPosition(position).toString();

                // Toast.makeText(getApplicationContext(),"Position: "+position,Toast.LENGTH_LONG);

                carIV.setImageResource(Models.id[position]);
                detailBtn.setText("More..");
                detailBtn.setVisibility(View.VISIBLE);
             //   titleTV.setText(presentName);

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
    }


}//end of MainActivity

