package com.team.sportsskuyy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Dokumentasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumentasi);
        this.setTitle("Tutorial Dan Penjelasan");

        final Button keluar = findViewById(R.id.metu);

        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dokumentasi.this.finish();
            }
        });
    }
}
