package com.team.sportsskuyy;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class KaloriList extends ArrayAdapter<addFirebase> {
    private Activity context;
    private List<addFirebase> latihanList;
    private int kalori;
    private String string_kalori;

    public KaloriList(Activity context, List<addFirebase> latihanList) {
        super(context, R.layout.list_layout,latihanList);
        this.context = context;
        this.latihanList = latihanList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewTanggal = (TextView) listViewItem.findViewById(R.id.textViewTanggal);
        TextView textViewGerakan = (TextView) listViewItem.findViewById(R.id.textViewGerakan);
        TextView textViewKalori = (TextView) listViewItem.findViewById(R.id.textViewKalori);

        addFirebase latihan = latihanList.get(position);

        kalori = latihan.getKalori();
        string_kalori = Integer.toString(kalori);

        textViewTanggal.setText(latihan.getTanggal());
        textViewGerakan.setText("Gerakan \t: "+latihan.getGerakan());
        textViewKalori.setText("Kalori \t\t\t: "+string_kalori);

        return listViewItem;
    }
}
