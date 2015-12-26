package com.muktiwbowo.projectpam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by muktiwbowo on 25/11/15.
 */
public class CategoryActivity extends Fragment {

    String[] kategori = new String[]{"Android", "Java", "Python", "Ruby", "HTML", "PHP", "JavaScript",
            "Objective-C", "Swift", "MySQL", "PostgreSQL", "Perl"
    };

    public CategoryActivity() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.kategori, container, false);

        ListView listView = (ListView) v.findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.card_view, R.id.text_view, kategori);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), position + " is clicked", Toast.LENGTH_SHORT).show();
                if (position == 0) {

                    Intent intent = new Intent(getActivity(),AndroidActivity.class);
                    startActivity(intent);
                }

            }
        });


        return v;
    }
}
