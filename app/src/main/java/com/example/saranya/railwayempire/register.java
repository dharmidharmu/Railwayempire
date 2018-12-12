package com.example.saranya.railwayempire;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class register extends AppCompatActivity
{
    public static final String userDetails = "com.example.saranya.railwayempire";
    private EditText
            RnameFld, RpasswordFld,
            RageFld, RadrssFld,
            RmobileNoFld, RcardNoFld,RemailFld;

    private Button RsubmitBtn;

    public boolean isValid(String s) {
        return (!s.trim().isEmpty());
    }



    public boolean passIsValid(String s) {
        return (s.length() >= 5 && isValid(s));
    }


    public int C2I(String st) {
        return Integer.parseInt(st);
    }
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth=FirebaseAuth.getInstance();

        RnameFld = (EditText) findViewById(R.id.RnameFld);
        RpasswordFld = (EditText) findViewById(R.id.RpasswordFld);
        RadrssFld = (EditText) findViewById(R.id.RaddressFld);
        RageFld = (EditText) findViewById(R.id.RageFld);
        RmobileNoFld = (EditText) findViewById(R.id.RmobileNoFld);
        RcardNoFld = (EditText) findViewById(R.id.RcardNoFld);
        RsubmitBtn = (Button) findViewById(R.id.RsubmitBtn);
        RemailFld= (EditText) findViewById(R.id.RemailFld);
    }
        public void onClickregister (View v){
            register();

        }
        private void register ()
        {

            String nameFld = RnameFld.getText().toString().trim();
            String passwordFld = RpasswordFld.getText().toString().trim();
            String ageFld = RageFld.getText().toString().trim();
            String adrssFld = RadrssFld.getText().toString().trim();
            String mobileNoFld = RmobileNoFld.getText().toString().trim();
            String cardNoFld = RcardNoFld.getText().toString().trim();
            String emailFld = RemailFld.getText().toString().trim();
            if (TextUtils.isEmpty(RnameFld.getText().toString().trim()) &&
                    TextUtils.isEmpty(RpasswordFld.getText().toString().trim()) && TextUtils.isEmpty(RageFld.getText().toString().trim())
                    && TextUtils.isEmpty(RadrssFld.getText().toString().trim()) && TextUtils.isEmpty(RmobileNoFld.getText().toString().trim()) && TextUtils.isEmpty(RcardNoFld.getText().toString().trim())
                    && TextUtils.isEmpty(RemailFld.getText().toString().trim())) {

                RnameFld.setError("Required");
                RpasswordFld.setError("Required");
                RageFld.setError("Required");
                RadrssFld.setError("Required");
                RmobileNoFld.setError("Required");
                RcardNoFld.setError("Required");
                RemailFld.setError("Required");
            } else if (TextUtils.isEmpty(RnameFld.getText().toString().trim())) {
                RnameFld.setError("Enter Username");
            } else if (TextUtils.isEmpty(RemailFld.getText().toString().trim())) {
                RemailFld.setError("Required");
            } else if (!emailValidator(RemailFld.getText().toString())) {
                RemailFld.setError("Please Enter Valid Email Address");
            } else if (TextUtils.isEmpty(RageFld.getText().toString().trim())) {
                RageFld.setError("Required");
            } else if (!ageValidator(RageFld.getText().toString())) {
                RageFld.setError("Age must be Between 0 to 100");
            } else if (TextUtils.isEmpty(RadrssFld.getText().toString().trim())) {
                RadrssFld.setError("Required");
            } else if (TextUtils.isEmpty(RcardNoFld.getText().toString().trim())) {
                RcardNoFld.setError("Required");
            } else if (TextUtils.isEmpty(RmobileNoFld.getText().toString().trim())) {
                RmobileNoFld.setError("Required");
            } else if (!phValidator(RmobileNoFld.getText().toString())) {
                RmobileNoFld.setError("Please Enter a Valid Mobile Number");
            } else if (TextUtils.isEmpty(RpasswordFld.getText().toString().trim())) {
                RpasswordFld.setError("Required");
            } else {
                mAuth.createUserWithEmailAndPassword(emailFld, passwordFld)
                        .addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    userdata();
                                    startActivity(new Intent(getApplicationContext(), second.class));
                                    Clickme();
                                    Toast.makeText(register.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(register.this, "Please Try again", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        }

    private void Clickme() {
        NotificationCompat.Builder builder =(NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("REGISTRATION SUCCESSFUL!!!!")
                .setContentText("Your Registration on Railway Empire Application is Successful");
        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,builder.build());
    }
    public static boolean emailValidator(String email)
    {
        return(!TextUtils.isEmpty(email)&& Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    private static boolean phValidator(String phone){
        Pattern pattern;
        Matcher matcher;
        final String PHONE_PATTERN="^[2-9]{2}[0-9]{8}$";
        pattern=Pattern.compile(PHONE_PATTERN);
        matcher=pattern.matcher(phone);
        return matcher.matches();
    }

    private static boolean ageValidator(String age){
        Pattern pattern;
        Matcher matcher;
        final String PHONE_PATTERN="^[0-9]{2}$";
        pattern=Pattern.compile(PHONE_PATTERN);
        matcher=pattern.matcher(age);
        return matcher.matches();
    }

    public void userdata(){

        String nameFld = RnameFld.getText().toString().trim();
        String passwordFld = RpasswordFld.getText().toString().trim();
        String ageFld = RageFld.getText().toString().trim();
        String adrssFld = RadrssFld.getText().toString().trim();
        String mobileNoFld = RmobileNoFld.getText().toString().trim();
        String cardNoFld = RcardNoFld.getText().toString().trim();
        String emailFld = RemailFld.getText().toString().trim();
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference register=firebaseDatabase.getReference(mAuth.getUid());
        train reg = new train(nameFld, passwordFld, ageFld, adrssFld, mobileNoFld,cardNoFld, emailFld);
        register.setValue(reg);

    }
    }