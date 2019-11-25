package com.example.final_ca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WeaponItemDetails extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_item_details);
        textView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String temp = intent.getStringExtra("name");
        textView.setText(temp);
    }
}
