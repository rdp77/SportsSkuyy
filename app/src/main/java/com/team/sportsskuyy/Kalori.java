package com.team.sportsskuyy;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Kalori extends AppCompatActivity {

    DatabaseReference databaseLatihans;
    ListView listViewLatihans;
    List<addFirebase> latihanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalori);

        databaseLatihans = FirebaseDatabase.getInstance().getReference("latihan");
        listViewLatihans = (ListView) findViewById(R.id.listViewLatihans);
        latihanList = new ArrayList<>();

        this.setTitle("Data Kalori");
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseLatihans.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                latihanList.clear();
                for (DataSnapshot latihanSnapshot : dataSnapshot.getChildren()) {
                    addFirebase latihan = latihanSnapshot.getValue(addFirebase.class);
                    latihanList.add(latihan);
                }
                KaloriList adapter = new KaloriList(Kalori.this, latihanList);
                listViewLatihans.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println(databaseError.getDetails()+" "+databaseError.getMessage());
            }
        });
    }
}
