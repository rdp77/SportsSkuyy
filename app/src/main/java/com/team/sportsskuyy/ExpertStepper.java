package com.team.sportsskuyy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.victoralbertos.breadcumbs_view.BreadcrumbsView;
import pl.droidsonroids.gif.GifImageView;

public class ExpertStepper extends AppCompatActivity {

    DatabaseReference databaseLatihan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_stepper);
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
        this.setTitle("Latihan Sulit");
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
                    ExpertStepper.this.finish();
                }else if(button.getText() == "Lanjut Langkah Ke 2"){
                    button.setText("Lanjut Langkah Ke 3");
                    anim.setImageResource(R.drawable.highkneeup);
                    keterangan.setText("Lakukan High Knee Up\nselama 45 detik");
                    lanjot.nextStep();
                    addLatihan("High Knee Up",52);
                }else if(button.getText() == "Lanjut Langkah Ke 3"){
                    button.setText("Lanjut Langkah Ke 4");
                    anim.setImageResource(R.drawable.mountainclimber);
                    keterangan.setText("Lakukan Mountain Climbers\nselama 45 detik");
                    lanjot.nextStep();
                    addLatihan("Mountain Climbers",52);
                }else if(button.getText() == "Lanjut Langkah Ke 4"){
                    button.setText("Istirahat Pertama");
                    anim.setImageResource(R.drawable.situp);
                    keterangan.setText("Lakukan Sit Up\nselama 45 detik");
                    lanjot.nextStep();
                    addLatihan("Sit Up",37);
                }else if(button.getText() == "Istirahat Pertama"){
                    button.setText("Lanjut Langkah Ke 6");
                    anim.setImageResource(R.drawable.ic_break);
                    keterangan.setText("Istirahat dahulu\nselama 20 detik");
                    lanjot.nextStep();
                }else if(button.getText() == "Lanjut Langkah Ke 6"){
                    button.setText("Lanjut Langkah Ke 7");
                    anim.setImageResource(R.drawable.plankknee);
                    keterangan.setText("Lakukan Plank Knee Twist\nselama 45 detik");
                    lanjot.nextStep();
                    addLatihan("Plank Knee Twist",47);
                }else if(button.getText() == "Lanjut Langkah Ke 7"){
                    button.setText("Lanjut Langkah Ke 8");
                    anim.setImageResource(R.drawable.widepushup);
                    keterangan.setText("Lakukan Wide Push Up\nselama 45 detik");
                    lanjot.nextStep();
                    addLatihan("Wide Push Up",37);
                }else if(button.getText() == "Lanjut Langkah Ke 8"){
                    button.setText("Lanjut Langkah Ke 9");
                    anim.setImageResource(R.drawable.crunch);
                    keterangan.setText("Lakukan Crunch\nselama 45 detik");
                    lanjot.nextStep();
                    addLatihan("Crunch",32);
                }else if(button.getText() == "Lanjut Langkah Ke 9"){
                    button.setText("Istirahat Kedua");
                    anim.setImageResource(R.drawable.pushup);
                    keterangan.setText("Lakukan Push Up\nselama 45 detik");
                    lanjot.nextStep();
                    addLatihan("Push Up",32);
                }else if(button.getText() == "Istirahat Kedua"){
                    button.setText("Lanjut Langkah Ke 10");
                    anim.setImageResource(R.drawable.ic_break);
                    keterangan.setText("Istirahat dahulu\nselama 20 detik");
                    lanjot.nextStep();
                }else if(button.getText() == "Lanjut Langkah Ke 10"){
                    button.setText("Lanjut Langkah Ke 11");
                    anim.setImageResource(R.drawable.russiantwist);
                    keterangan.setText("Lakukan Russian Twist\nselama 45 detik");
                    lanjot.nextStep();
                    addLatihan("Russin Twist",32);
                }else if(button.getText() == "Lanjut Langkah Ke 11"){
                    button.setText("Lanjut Langkah Ke 12");
                    anim.setImageResource(R.drawable.burpeess);
                    keterangan.setText("Lakukan Burpees\nselama 45 detik");
                    lanjot.nextStep();
                    addLatihan("Burpess",67);
                }else if(button.getText() == "Lanjut Langkah Ke 12"){
                    button.setText("Lanjut Langkah Ke 13");
                    anim.setImageResource(R.drawable.toejump);
                    keterangan.setText("Lakukan Toe Jump\nselama 45 detik");
                    lanjot.nextStep();
                    addLatihan("Toe Jump",37);
                }else if(button.getText() == "Lanjut Langkah Ke 13"){
                    button.setText("Lanjut Langkah Ke 14");
                    anim.setImageResource(R.drawable.plank);
                    keterangan.setText("Lakukan Plank\nselama 45 detik");
                    lanjot.nextStep();
                    addLatihan("Plank",62);
                }else if(button.getText() == "Lanjut Langkah Ke 14"){
                    button.setText("Istirahat Ketiga");
                    anim.setImageResource(R.drawable.squat);
                    keterangan.setText("Lakukan Squat\nselama 45 detik");
                    lanjot.nextStep();
                    addLatihan("Squat",42);
                }else if(button.getText() == "Istirahat Ketiga"){
                    button.setText("Lanjut Langkah Ke 15");
                    anim.setImageResource(R.drawable.ic_break);
                    keterangan.setText("Istirahat dahulu\nselama 20 detik");
                    lanjot.nextStep();
                }else if(button.getText() == "Lanjut Langkah Ke 15"){
                    button.setText("Lanjut Langkah Ke 16");
                    anim.setImageResource(R.drawable.situp);
                    keterangan.setText("Lakukan Sit Up\nselama 45 detik");
                    lanjot.nextStep();
                    addLatihan("Sit Up",37);
                }else if(button.getText() == "Lanjut Langkah Ke 16"){
                    button.setText("Lanjut Langkah Ke 17");
                    anim.setImageResource(R.drawable.pushup);
                    keterangan.setText("Lakukan Push Up\nselama 45 detik");
                    lanjot.nextStep();
                    addLatihan("Push Up",37);
                }else if(button.getText() == "Lanjut Langkah Ke 17"){
                    button.setText("Lanjut Langkah Ke 18");
                    anim.setImageResource(R.drawable.jumpingjacks);
                    keterangan.setText("Lakukan Jumping Jack\nselama 45 detik");
                    lanjot.nextStep();
                    addLatihan("Jumping Jack",57);
                }else if(button.getText() == "Lanjut Langkah Ke 18"){
                    button.setText("Lanjut Langkah Ke 19");
                    anim.setImageResource(R.drawable.burpeess);
                    keterangan.setText("Lakukan Burpees\nselama 50 detik");
                    lanjot.nextStep();
                    addLatihan("Burpess",67);
                }else if(button.getText() == "Lanjut Langkah Ke 19") {
                    button.setText("SELESAI");
                    anim.setImageResource(R.drawable.plank);
                    keterangan.setText("Lakukan Plank\nselama 50 detik");
                    lanjot.nextStep();
                    addLatihan("Plank",63);
                }else{
                    button.setText("Lanjut Langkah Ke 2");
                    nyerah.setVisibility(View.VISIBLE);
                    anim.setImageResource(R.drawable.jumpingjacks);
                    keterangan.setText("Lakukan Jumping Jacks\nselama 50 detik");
                    lanjot.nextStep();
                    addLatihan("Jumping Jacks",57);
                }
            }
        });
    }

    public void addLatihan(String gerakan, int kalori) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm::ss dd/MM/yyyy");
        Date date = new Date();

        String id_latihan = databaseLatihan.push().getKey();
        String tanggal = dateFormat.format(date);
        int jumlah_kalori = 847;

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
        alertDialogBuilder.setTitle("Hellow gaes inpo buat kalian yg lthn");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Noob kali you,yakin mau berhenti?\nudah latihan loh!")
                .setIcon(R.mipmap.icons)
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        ExpertStepper.this.finish();
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
