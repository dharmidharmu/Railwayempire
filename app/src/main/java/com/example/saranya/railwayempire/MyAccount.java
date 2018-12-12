package com.example.saranya.railwayempire;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyAccount extends AppCompatActivity {
    private TextView name;
    private TextView city;
    private TextView email;
    private TextView phone;
    private FirebaseAuth mAuth;
    private FirebaseDatabase display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        final TextView name=(TextView)findViewById(R.id.dispname);
        final TextView city=(TextView)findViewById(R.id.dispcity);
        final TextView email=(TextView)findViewById(R.id.dispemail);
        final TextView phone=(TextView)findViewById(R.id.dispphone);
        mAuth= FirebaseAuth.getInstance();
        display=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=display.getReference().child(mAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                train data =dataSnapshot.getValue(train.class);
                name.setText(" "+data.getNameFld());

                city.setText(" "+data.getAdrssFld());
                email.setText(" "+data.getEmailFld());
                phone.setText(" "+data.getMobileNoFld());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
