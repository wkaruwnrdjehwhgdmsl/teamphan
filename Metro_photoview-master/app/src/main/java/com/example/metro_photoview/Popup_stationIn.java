package com.example.metro_photoview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


public class Popup_stationIn extends Activity implements View.OnClickListener {
    private Context mContext;

    private ImageView map;
    private TextView btn_ok;
    private int n;



    public void setMapNumber(int n){
        this.n = n;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_stationIn);

        map = (ImageView)findViewById(R.id.map);
        btn_ok = (TextView)findViewById(R.id.btn_ok);

        switch (n)
        map.setImageResource(R.drawable.map2);
        btn_ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
