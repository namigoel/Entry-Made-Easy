package com.parul.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.parul.authentication.MESSAGE";
    public Button acc;
    public Button inf;
    public Button campus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //acc = (Button) findViewById(R.id.account);
        inf = (Button) findViewById(R.id.info);
        campus = (Button) findViewById(R.id.outcampus);

//        acc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, CreateAccount.class);
//                intent.putExtra(EXTRA_MESSAGE , "create your account");
//                startActivity(intent);
//            }
//        });

        campus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, OutCampus.class);
                startActivity (i);
            }
        });

        inf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CarddetectActivity.class);
                intent.putExtra(EXTRA_MESSAGE , "Search students who are out of campus");
                startActivity(intent);
            }
        });
    }

}
