package com.example.betaui;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class Locator extends AppCompatActivity{

    private FusedLocationProviderClient client;
    private TextView textView = findViewById(R.id.locationPanel);
    private Button trackButton = findViewById(R.id.trackButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_bus);


        requestPermission();

        client = LocationServices.getFusedLocationProviderClient(this);
        trackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(ActivityCompat.checkSelfPermission(Locator.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                    return;
                }
                client.getLastLocation().addOnSuccessListener(Locator.this, new OnSuccessListener<Location>(){
                    @Override
                    public void onSuccess(Location location) {
                        if(location != null){
                            textView.setText("Latitude: " + location.getLatitude() + " Longitude: " + location.getLongitude());
                        }
                    }

                });

            }

        });
    }

    public void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, 1);
    }
}
