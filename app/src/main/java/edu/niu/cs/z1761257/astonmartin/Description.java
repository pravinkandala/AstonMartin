package edu.niu.cs.z1761257.astonmartin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Description extends AppCompatActivity {

    private TextView titleTV, descriptionTV;
    private Button backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


     //   Toast.makeText(getApplicationContext(),"Title: "+titleTV,Toast.LENGTH_SHORT).show();
        //connecting to the screen
        titleTV = (TextView)findViewById(R.id.titleTextView);
        descriptionTV = (TextView)findViewById(R.id.decsriptionTextView);
        backbtn = (Button)findViewById(R.id.button);

        //getting position from previous page
        int number = getIntent().getIntExtra("detailPage", -1);

        //Displaying content
        titleTV.setText("Specifications:\n" + Models.names[number]);
        descriptionTV.setText(Models.description[number]);

    }//end of onCreate

    //button function to goback to main page

    public void goBack(View view){
        Intent mainPage = new Intent(this, MainActivity.class);
        startActivity(mainPage);
    }


}
