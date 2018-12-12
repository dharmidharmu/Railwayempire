package com.example.saranya.railwayempire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class reserve extends AppCompatActivity {
    EditText fromtxt;
    EditText totxt;
    EditText tictxt;
    EditText classtxt;
    EditText typetxt;
    private FirebaseAuth mAuth;
    private FirebaseDatabase book;
    Button btn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);
        fromtxt=(EditText)findViewById(R.id.fromtxt);
        totxt=(EditText)findViewById(R.id.totxt);
        tictxt=(EditText)findViewById(R.id.tictxt);
        typetxt=(EditText)findViewById(R.id.jtypetxt);
        classtxt=(EditText)findViewById(R.id.jclasstxt);
        btn=(Button)findViewById(R.id.reg);
        mAuth= FirebaseAuth.getInstance();
        book=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=book.getReference().child("train");
    }
    public void onclickreserve(View view){
        String from =fromtxt.getText().toString().trim();
        String to=totxt.getText().toString().trim();
        String tic=tictxt.getText().toString().trim();
        String type=typetxt.getText().toString().trim();
        String classid=classtxt.getText().toString().trim();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference book;
        book = firebaseDatabase.getReference().child(mAuth.getUid()).child("current");
        book bk=new book(from,to,tic,type,classid);
        book.setValue(bk);

        Toast.makeText(this, "BOOKING SUCCESSFUL", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,nav.class));
    }
}
