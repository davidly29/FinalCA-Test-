package com.example.final_ca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button buttonViewWeapons, buttonSave;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance().getReference("weapons");

        buttonViewWeapons = (Button) findViewById(R.id.buttonViewWeapons);
        buttonSave = (Button) findViewById(R.id.buttonSave);

        buttonViewWeapons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Weapon_Display.class));
            }
        });
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabase.child("CT-SMG").child("1").setValue(new WeaponObjectHolder("Ump45", "smg", "rapid fire mid range gun", "35"));
                mDatabase.child("CT-SMG").child("2").setValue(new WeaponObjectHolder("P90", "smg", "Close range smg", "26"));
                mDatabase.child("CT-SMG").child("3").setValue(new WeaponObjectHolder("MP5-SD", "smg", "silenced smg", "27"));
                mDatabase.child("CT-SMG").child("4").setValue(new WeaponObjectHolder("MP7", "smg", "long range high damage smg", "29"));
                mDatabase.child("CT-SMG").child("5").setValue(new WeaponObjectHolder("PP-Bizon", "smg", "Rapid fire short range smg", "27"));
                mDatabase.child("CT-SMG").child("6").setValue(new WeaponObjectHolder("MP9", "smg", "Close range smg", "26"));

                mDatabase.child("T-SMG").child("1").setValue(new WeaponObjectHolder("Ump45", "smg", "rapid fire mid range gun", "35"));
                mDatabase.child("T-SMG").child("2").setValue(new WeaponObjectHolder("P90", "smg", "Close range smg", "26"));
                mDatabase.child("T-SMG").child("3").setValue(new WeaponObjectHolder("MP5-SD", "smg", "silenced smg", "27"));
                mDatabase.child("T-SMG").child("4").setValue(new WeaponObjectHolder("MP7", "smg", "long range high damage smg", "29"));
                mDatabase.child("T-SMG").child("5").setValue(new WeaponObjectHolder("PP-Bizon", "smg", "Rapid fire short range smg", "27"));
                mDatabase.child("T-SMG").child("6").setValue(new WeaponObjectHolder("Mac-10", "smg", "Close range cheap smg", "29"));

                mDatabase.child("CT-Rifle").child("1").setValue(new WeaponObjectHolder("Famas", "rifle", "Medium range burst rifle", "30"));
                mDatabase.child("CT-Rifle").child("2").setValue(new WeaponObjectHolder("M4A4", "rifle", "Long range reliable rifle", "33"));
                mDatabase.child("CT-Rifle").child("3").setValue(new WeaponObjectHolder("M4a1-S", "rifle", "silenced long range rifle", "33"));
                mDatabase.child("CT-Rifle").child("4").setValue(new WeaponObjectHolder("AUG", "rifle", "long range high damage scoped rifle", "28"));
                mDatabase.child("CT-Rifle").child("5").setValue(new WeaponObjectHolder("SSG-08", "rifle", "long range sniper rifle", "88"));
                mDatabase.child("CT-Rifle").child("6").setValue(new WeaponObjectHolder("AWP", "rifle", "long range high  powered sniper rifle", "115"));
                mDatabase.child("CT-Rifle").child("7").setValue(new WeaponObjectHolder("SCAR-20", "rifle", "long range high powered semi auto rifle", "80"));

                mDatabase.child("T-Rifle").child("1").setValue(new WeaponObjectHolder("Galil", "rifle", "Medium range low damage rifle", "30"));
                mDatabase.child("T-Rifle").child("2").setValue(new WeaponObjectHolder("AK-47", "rifle", "Long range high damage rifle", "36"));
                mDatabase.child("T-Rifle").child("3").setValue(new WeaponObjectHolder("SG 553", "rifle", "long range high damage scoped rifle", "30"));
                mDatabase.child("T-Rifle").child("4").setValue(new WeaponObjectHolder("SSG-08", "rifle", "long range sniper rifle", "88"));
                mDatabase.child("T-Rifle").child("5").setValue(new WeaponObjectHolder("AWP", "rifle", "long range high  powered sniper rifle", "115"));
                mDatabase.child("T-Rifle").child("6").setValue(new WeaponObjectHolder("G3SG1", "rifle", "long range high powered semi auto rifle", "80"));

                mDatabase.child("CT-Pistol").child("1").setValue(new WeaponObjectHolder("P2000", "pistol", "Semi auto pistol", "35"));
                mDatabase.child("CT-Pistol").child("2").setValue(new WeaponObjectHolder("UPS-S", "pistol", "Semi auto silenced pistol", "36"));
                mDatabase.child("CT-Pistol").child("3").setValue(new WeaponObjectHolder("CZ75-Auto", "pistol", "Full auto pistol", "31"));
                mDatabase.child("CT-Pistol").child("4").setValue(new WeaponObjectHolder("Five-Seven", "pistol", "Semi auto high damage pistol", "24"));
                mDatabase.child("CT-Pistol").child("5").setValue(new WeaponObjectHolder("Dual Berettas", "pistol", "semi auto short range pistol", "38"));
                mDatabase.child("CT-Pistol").child("6").setValue(new WeaponObjectHolder("Desert Eagle", "pistol", "long range high powered pistol", "50"));
                mDatabase.child("CT-Pistol").child("6").setValue(new WeaponObjectHolder("R8 Revolver", "pistol", "long range revolver", "86"));

                mDatabase.child("T-Pistol").child("1").setValue(new WeaponObjectHolder("Glock", "pistol", "Semi auto pistol low damage pistol", "30"));
                mDatabase.child("T-Pistol").child("2").setValue(new WeaponObjectHolder("CZ75-Auto", "pistol", "Full auto pistol", "31"));
                mDatabase.child("T-Pistol").child("3").setValue(new WeaponObjectHolder("Tec-9", "pistol", "Semi auto high range pistol", "33"));
                mDatabase.child("T-Pistol").child("4").setValue(new WeaponObjectHolder("Dual Berettas", "pistol", "semi auto short range pistol", "38"));
                mDatabase.child("T-Pistol").child("5").setValue(new WeaponObjectHolder("Desert Eagle", "pistol", "long range high powered pistol", "50"));
                mDatabase.child("T-Pistol").child("6").setValue(new WeaponObjectHolder("R8 Revolver", "pistol", "long range revolver", "86"));

                mDatabase.child("CT-Heavy").child("1").setValue(new WeaponObjectHolder("Nova", "shotgun", "Semi auto pistol low damage shotgun", "26"));
                mDatabase.child("CT-Heavy").child("2").setValue(new WeaponObjectHolder("XM1014", "shotgun", "Full auto shotgun", "20"));
                mDatabase.child("CT-Heavy").child("3").setValue(new WeaponObjectHolder("MAG-7", "shotgun", "Semi auto low damage shotgun", "30"));
                mDatabase.child("CT-Heavy").child("4").setValue(new WeaponObjectHolder("M249", "shotgun", "Full auto heavy rifle", "32"));
                mDatabase.child("CT-Heavy").child("5").setValue(new WeaponObjectHolder("Negev", "shotgun", "long range high powered rifle", "35"));

                mDatabase.child("T-Heavy").child("1").setValue(new WeaponObjectHolder("Nova", "shotgun", "Semi auto pistol low damage shotgun", "26"));
                mDatabase.child("T-Heavy").child("2").setValue(new WeaponObjectHolder("XM1014", "shotgun", "Full auto shotgun", "20"));
                mDatabase.child("T-Heavy").child("3").setValue(new WeaponObjectHolder("Sawed-off", "shotgun", "Semi auto low damage shotgun", "32"));
                mDatabase.child("T-Heavy").child("4").setValue(new WeaponObjectHolder("M249", "shotgun", "Full auto heavy rifle", "32"));
                mDatabase.child("T-Heavy").child("5").setValue(new WeaponObjectHolder("Negev", "shotgun", "long range high powered rifle", "35"));

            }
        });
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
               // Log.d("", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("", "Failed to read value.", error.toException());
            }
        });

    }
}
