package com.example.final_ca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Weapon_Display extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String, List<String>> listItems;
    MainAdapter adapter;
    Switch switchCompat;
    private AdapterOnClickHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon__display);
        switchCompat = findViewById(R.id.buttonSwitch);
        expandableListView = findViewById(R.id.listView);
        listGroup = new ArrayList<>();
        listItems = new HashMap<>();
        adapter = new MainAdapter(this, listGroup, listItems, handler);
        expandableListView.setAdapter(adapter);
        initList();

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String temp = parent.getExpandableListAdapter().getChild(groupPosition, childPosition).toString();
                Intent intent = new Intent(Weapon_Display.this, WeaponItemDetails.class);
                intent.putExtra("name", temp);
                startActivity(intent);
                return true;
            }
        });

    }

    private void initList() {
        //Titles
        listGroup.add(getString(R.string.ct_pistols));
        listGroup.add(getString(R.string.ct_smg));
        String[] array;

        //Items within title
        List<String> ct_details_pistol = new ArrayList<>();
        array = getResources().getStringArray(R.array.pistols_ct);
        for (String item : array) {
            ct_details_pistol.add(item);
        }
        List<String> ct_details_smg = new ArrayList<>();
        array = getResources().getStringArray(R.array.ct_smg);
        for (String item : array) {
            ct_details_smg.add(item);
        }

        //assign list to groups
        listItems.put(listGroup.get(0), ct_details_pistol);
        listItems.put(listGroup.get(1), ct_details_smg);
        adapter.notifyDataSetChanged();
    }
}
