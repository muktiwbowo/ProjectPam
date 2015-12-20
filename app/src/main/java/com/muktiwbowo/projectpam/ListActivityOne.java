package com.muktiwbowo.projectpam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by muktiwbowo on 06/12/15.
 */
public class ListActivityOne extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity_one);

        toolbar = (Toolbar) findViewById(R.id.toolbar_two);
        setSupportActionBar(toolbar);

    }


}
