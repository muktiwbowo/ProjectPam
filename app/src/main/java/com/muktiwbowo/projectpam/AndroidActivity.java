package com.muktiwbowo.projectpam;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by muktiwbowo on 26/12/15.
 */
public class AndroidActivity extends Activity implements TextWatcher,
        AdapterView.OnItemClickListener {

    private EditText search;
    private ListView lv;
    private AndroidHelper androidHelperr;
    private ArrayAdapter<Android> adapter;
    private List<Android> listAndroid;
    final private MaterialDialog mMaterialDialog = new MaterialDialog(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android);
        lv = (ListView) findViewById(R.id.list_view_android);
        lv.setEmptyView(findViewById(R.id.empty));
        search = (EditText) findViewById(R.id.android_search);

        androidHelperr = AndroidHelper.getInstance(this);

        setData();

        search.addTextChangedListener(this);
        lv.setOnItemClickListener(this);
    }

    private void setData() {
        listAndroid = androidHelperr.getAllKata();

        adapter = new ArrayAdapter<Android>(this,
                android.R.layout.simple_expandable_list_item_1, listAndroid);
        lv.setAdapter(adapter);

    }

    @Override
    public void afterTextChanged(Editable arg0) {
    }

    @Override
    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                  int arg3) {
    }

    @Override
    public void onTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
        adapter.getFilter().filter(s.toString());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*Bundle b = new Bundle();
        b.putString("istilah", adapter.getItem(position).getKeyword());
        b.putString("arti", adapter.getItem(position).getResults());

        Intent i = new Intent(this, ArtiActivity.class);
        i.putExtras(b);
        startActivity(i);*/

        mMaterialDialog.setTitle(""+adapter.getItem(position).getaKeyword())
                .setMessage(""+adapter.getItem(position).getaResult())
                .setCanceledOnTouchOutside(true)
                .setPositiveButton("Back", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMaterialDialog.dismiss();
                    }
                });

        mMaterialDialog.show();
    }
}

