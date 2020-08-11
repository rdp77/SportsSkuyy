package com.team.sportsskuyy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.CountDownTimer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.victoralbertos.breadcumbs_view.BreadcrumbsView;
import pl.droidsonroids.gif.GifImageView;

public class EasyStepper extends AppCompatActivity {

    DatabaseReference databaseLatihan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_stepper);
        //Definisi firebase
        databaseLatihan = FirebaseDatabase.getInstance().getReference("latihan");
        // Definisi Gif
        final GifImageView anim = (GifImageView) findViewById(R.id.gif);
        // Definisi Breadcrumbs
        final BreadcrumbsView lanjot = (BreadcrumbsView) findViewById(R.id.breadcrumbs);
        // Definisi TextView
        final TextView keterangan = (TextView) findViewById(R.id.tulisan);
        // Definisi Button
        final Button button = (Button) findViewById(R.id.Lanjutes);
        final Button nyerah = (Button) findViewById(R.id.nyerahex);
        // Mengubah title
        this.setTitle("Latihan Mudah");
        // Hidden button first time
        nyerah.setVisibility(View.INVISIBLE);

        nyerah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Timer
                new CountDownTimer(3000,1000){
                    @Override
                    public void onFinish() {
                        button.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onTick(long millisUntilFinished) {
                        button.setVisibility(View.INVISIBLE);
                    }
                }.start();
                // Change Kabeh
                if (button.getText() == "SELESAI"){
                    button.setText("Keluar");
                    keterangan.setText("Latihan Telah Selesai");
                    anim.setImageResource(R.drawable.ic_trophy);
                    nyerah.setVisibility(View.INVISIBLE);
                    lanjot.nextStep();
                }else if(button.getText() == "Keluar"){
                    EasyStepper.this.finish();
                }else if(button.getText() == "Lanjut Langkah Ke 2"){
                    button.setText("Lanjut Langkah Ke 3");
                    anim.setImageResource(R.drawable.highkneeup);
                    keterangan.setText("Lakukan High Knee Up\nselama 30 detik");
                    addLatihan("High Knee Up", 40);
                    lanjot.nextStep();
                }else if(button.getText() == "Lanjut Langkah Ke 3"){
                    button.setText("Lanjut Langkah Ke 4");
                    anim.setImageResource(R.drawable.mountainclimber);
                    keterangan.setText("Lakukan Mountain Climbers\nselama 30 detik");
                    addLatihan("Mountain Climbers", 40);
                    lanjot.nextStep();
                }else if(button.getText() == "Lanjut Langkah Ke 4"){
                    button.setText("Istirahat Pertama");
                    anim.setImageResource(R.drawable.situp);
                    keterangan.setText("Lakukan Sit Up\nselama 25 detik");
                    addLatihan("Sit Up", 25);
                    lanjot.nextStep();
                }else if(button.getText() == "Istirahat Pertama"){
                    button.setText("Lanjut Langkah Ke 6");
                    anim.setImageResource(R.drawable.ic_break);
                    keterangan.setText("Istirahat dahulu\nselama 25 detik");
                    lanjot.nextStep();
                }else if(button.getText() == "Lanjut Langkah Ke 6"){
                    button.setText("Lanjut Langkah Ke 7");
                    anim.setImageResource(R.drawable.plankknee);
                    keterangan.setText("Lakukan Plank Knee Twist\nselama 30 detik");
                    addLatihan("Plank Knee Twist", 35);
                    lanjot.nextStep();
                }else if(button.getText() == "Lanjut Langkah Ke 7"){
                    button.setText("Lanjut Langkah Ke 8");
                    anim.setImageResource(R.drawable.widepushup);
                    keterangan.setText("Lakukan Wide Push Up\nselama 30 detik");
                    addLatihan("Wide Push Up", 25);
                    lanjot.nextStep();
                }else if(button.getText() == "Lanjut Langkah Ke 8"){
                    button.setText("Lanjut Langkah Ke 9");
                    anim.setImageResource(R.drawable.crunch);
                    keterangan.setText("Lakukan Crunch\nselama 30 detik");
                    addLatihan("Crunch", 20);
                    lanjot.nextStep();
                }else if(button.getText() == "Lanjut Langkah Ke 9"){
                    button.setText("Istirahat Kedua");
                    anim.setImageResource(R.drawable.pushup);
                    keterangan.setText("Lakukan Push Up\nselama 30 detik");
                    addLatihan("Push Up", 20);
                    lanjot.nextStep();
                }else if(button.getText() == "Istirahat Kedua"){
                    button.setText("Lanjut Langkah Ke 10");
                    anim.setImageResource(R.drawable.ic_break);
                    keterangan.setText("Istirahat dahulu\nselama 25 detik");
                    lanjot.nextStep();
                }else if(button.getText() == "Lanjut Langkah Ke 10"){
                    button.setText("Lanjut Langkah Ke 11");
                    anim.setImageResource(R.drawable.russiantwist);
                    keterangan.setText("Lakukan Russian Twist\nselama 30 detik");
                    addLatihan("Russian Twist", 20);
                    lanjot.nextStep();
                }else if(button.getText() == "Lanjut Langkah Ke 11"){
                    button.setText("Lanjut Langkah Ke 12");
                    anim.setImageResource(R.drawable.burpeess);
                    keterangan.setText("Lakukan Burpees\nselama 30 detik");
                    addLatihan("Burpess", 55);
                    lanjot.nextStep();
                }else if(button.getText() == "Lanjut Langkah Ke 12"){
                    button.setText("Lanjut Langkah Ke 13");
                    anim.setImageResource(R.drawable.toejump);
                    keterangan.setText("Lakukan Toe Jump\nselama 30 detik");
                    addLatihan("Toe Jump", 25);
                    lanjot.nextStep();
                }else if(button.getText() == "Lanjut Langkah Ke 13"){
                    button.setText("SELESAI");
                    anim.setImageResource(R.drawable.plank);
                    keterangan.setText("Lakukan Plank\nselama 30 detik");
                    addLatihan("Plank", 50);
                    lanjot.nextStep();
                } else {
                    button.setText("Lanjut Langkah Ke 2");
                    nyerah.setVisibility(View.VISIBLE);
                    keterangan.setText("Lakukan Jumping Jacks\nselama 30 detik");
                    anim.setImageResource(R.drawable.jumpingjacks);
                    addLatihan("Jumping Jacks", 45);
                    lanjot.nextStep();
                }
            }
        });
    }

    public void addLatihan(String gerakan, int kalori) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date date = new Date();

        String id_latihan = databaseLatihan.push().getKey();
        String tanggal = dateFormat.format(date);
        int jumlah_kalori = 400;

        addFirebase save = new addFirebase(id_latihan, tanggal, gerakan, kalori);
        databaseLatihan.child(id_latihan).setValue(save);
    }

    public void onBackPressed(){
        showDialog();
    }

    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Informasi");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Apakah Anda yakin mau berhenti?\nudah latihan loh!")
                .setIcon(R.mipmap.icons)
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        EasyStepper.this.finish();
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }

}
