package com.team.sportsskuyy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTargetView;
import com.getkeepsafe.taptargetview.TapTarget;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView kalori,easy,medium,expert;
    private DatabaseReference mDatabase;
    String all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Definisi Text And Image
        final ImageView imageView = findViewById(R.id.dokumentasi);
        final ImageView hapus = findViewById(R.id.delkalori);
        final TextView mTotal = findViewById(R.id.mTotal);
        //Definisi Kartu Pada Layout
        kalori = (CardView) findViewById(R.id.kalori);
        easy = (CardView) findViewById(R.id.mudah);
        medium = (CardView) findViewById(R.id.sedang);
        expert = (CardView) findViewById(R.id.sulit);
        //Click Listener Pada Kartu
        kalori.setOnClickListener(this);
        easy.setOnClickListener(this);
        medium.setOnClickListener(this);
        expert.setOnClickListener(this);
        imageView.setOnClickListener(this);
        //Definisi Firebase
        mDatabase = FirebaseDatabase.getInstance().getReference().child("latihan");

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.setValue(null);
                mTotal.setText("0");
                Snackbar.make(findViewById(R.id.delkalori),"Berhasil menghapus semua kalori",Snackbar.LENGTH_LONG).show();
            }
        });

        //Sum Kalori
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int sum = 0;
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    Map<String,Object> map = (Map<String,Object>) ds.getValue();
                    Object kal = map.get("kalori");
                    int pValue = Integer.parseInt(String.valueOf(kal));
                    sum += pValue;
                    mTotal.setText(String.valueOf(sum));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Tap Target
        TapTargetView.showFor(this,                 // `this` is an Activity
                TapTarget.forView(findViewById(R.id.dokumentasi), "Baca Tutorialnya\nDisini Gan")
                        // All options below are optional
                        .outerCircleColor(R.color.emerald)      // Specify a color for the outer circle
                        .outerCircleAlpha(0.96f)            // Specify the alpha amount for the outer circle
                        .targetCircleColor(R.color.white)   // Specify a color for the target circle
                        .titleTextSize(22)                  // Specify the size (in sp) of the title text
                        .textColor(R.color.white)    // Specify a color for both the title and description text
                        .dimColor(R.color.midnightblue)     // If set, will dim behind the view with 30% opacity of the given color
                        .drawShadow(true)                   // Whether to draw a drop shadow or not
                        .cancelable(false)                  // Whether tapping outside the outer circle dismisses the view
                        .tintTarget(true)                   // Whether to tint the target view's color
                        .transparentTarget(false)           // Specify whether the target is transparent (displays the content underneath)
                        .targetRadius(60),                  // Specify the target radius (in dp)
                new TapTargetView.Listener() {              // The listener can listen for regular clicks, long clicks or cancels
                    @Override
                    public void onTargetClick(TapTargetView view) {
                        super.onTargetClick(view);      // This call is optional
                    }
                });
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.kalori : i = new Intent(this,Kalori.class);startActivity(i); break;
            case R.id.mudah : i = new Intent(this, EasyStepper.class);startActivity(i); break;
            case R.id.sedang : i = new Intent(this, MediumStepper.class);startActivity(i); break;
            case R.id.sulit : i = new Intent(this, ExpertStepper.class);startActivity(i); break;
            case R.id.dokumentasi : i = new Intent(this, Dokumentasi.class);startActivity(i); break;
            default:break;
        }

    }
}
