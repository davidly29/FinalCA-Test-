package com.example.final_ca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WeaponItemDetails extends AppCompatActivity {
    TextView textView, textViewDescription, textViewDamage, textViewType, textViewTitle;
    private DatabaseReference mDatabase;
    WeaponObjectHolder detail;
    ArrayList<WeaponObjectHolder> pistols = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon_item_details);
        textView = (TextView) findViewById(R.id.textView);
        textViewDamage = (TextView) findViewById(R.id.textViewDamage);
        textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        textViewType = (TextView) findViewById(R.id.textViewType);
        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        textView.setText("");
        Intent intent = getIntent();
        String temp = intent.getStringExtra("name");

        mDatabase = FirebaseDatabase.getInstance().getReference("weapons");
        Query query = mDatabase.child("CT-Pistol").orderByChild("name").equalTo(temp);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> snap = dataSnapshot.getChildren();
                 for(DataSnapshot child: snap){
                     detail = child.getValue(WeaponObjectHolder.class);
                     //test
                     textViewTitle.setText(detail.getName());
                     textView.setText(detail.getName());
                     textViewDamage.setText(detail.getDmg());
                     textViewDescription.setText(detail.getDescription());
                     textViewType.setText(detail.getType());
                 }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                throw databaseError.toException();
            }
        });

    }
}
