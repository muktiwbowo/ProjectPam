package com.muktiwbowo.projectpam;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by muktiwbowo on 19/12/15.
 */
public class ArtiActivity extends AppCompatActivity{
    private TextView txtArti, txtIstilah;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arti);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_thee);
        setSupportActionBar(toolbar);

        txtArti = (TextView) findViewById(R.id.arti);
        txtIstilah = (TextView) findViewById(R.id.istilah);

        Bundle b = getIntent().getExtras();
        if (b != null)
        {
            txtIstilah.setText(b.getString("istilah"));
            txtArti.setText(b.getString("arti"));
        }
    }
}
