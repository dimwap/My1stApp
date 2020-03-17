package com.example.my1stapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readData();   //чтение из ресурса в массив
        EditText textBox = (EditText) findViewById(R.id.save_text);
//        textBox.setFocusableInTouchMode(true);
//        textBox.requestFocus();
    }

    // Defining ordered collection as WeatherSample class
    //private List<WeatherSample> weatherSamples = new ArrayList<>();
    private List<mySample> Samples = new ArrayList<>();

   // button
    public void buttonClick(View view){
        TextView textArt = (TextView) findViewById(R.id.textArt);
        TextView textView = (TextView) findViewById(R.id.open_text);
        EditText textBox = (EditText) findViewById(R.id.save_text);
        String text = textBox.getText().toString();
        textView.setText(text);
        String skl = "-";
        String art = "-";
        for(mySample s : Samples) {
            if(s.getArt().contains(text)) {
                skl = s.getSkl();
                art = s.getArt();
            }
        }
        Toast.makeText(this, "Склад:"+skl, Toast.LENGTH_LONG).show();
        textArt.setText(text+"..  Арт: "+art);
        textView.setText("Склад: "+skl);
        textBox.setText("");
//        view.setFocusableInTouchMode(true);
//        textBox.requestFocus();
    }
    //read Data from res
    private void readData() {
        // Read the raw csv file
        InputStream is = getResources().openRawResource(R.raw.scratch);

        // Reads text from character-input stream, buffering characters for efficient reading
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        // Initialization
        String line = "";
        // Initialization и чтение файла
        try {
            // Step over headers
            reader.readLine();

            // If buffer is not empty
            while ((line = reader.readLine()) != null) {
                //...
                Log.d("MyActivity","Res: " + line);
                // -- separator columns of CSV
                String[] token = line.split(";");
                // Read the data
                mySample sample = new mySample();
                //String[] sample =
                // Setters
                sample.setArt(token[0]);
                sample.setSkl(token[1]);

                // Adding object to a class
                Samples.add(sample);

                // Log the object
                Log.d("My Activity", "SKLAD tokens: " + token[0] +"|"+ token[1]);
		Log.d("My Activity", "SamplesArray: " + sample.getSkl() +";"+ sample.getSkl());
            }

        } catch (IOException e) {
            // Logs error with priority level
            Log.wtf("MyActivity", "Error reading data on line" + line, e);

            // Prints throwable details
            e.printStackTrace();
        }
    }

}
