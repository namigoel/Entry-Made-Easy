package com.parul.termproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OutCampus extends AppCompatActivity {

    List<CampusOut> students = new ArrayList<>();
    CampusAdapter campusadapter;
    RecyclerView recyclerView;
    ProgressDialog progressBar;
    DatabaseReference mentry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_campus);

        //ListView to view all students out of cmpus (Hostel Name {Roll No  , Name})
        progressBar = new ProgressDialog(OutCampus.this);
        progressBar.setCancelable(true);
        progressBar.setMessage("Please Wait ...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        progressBar.show();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mentry = database.getReference("records");

        mentry.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot record : snapshot.getChildren()) {
                    Entry rec = record.getValue(Entry.class);
                    if (rec.isStatus() == true) {
                        CampusOut cout = new CampusOut(rec.getName(), rec.getRollNo());
                        students.add (cout);

                    }
                }
                progressBar.dismiss();



                Log.e("studnets",String.valueOf(students.size()));
                campusadapter = new CampusAdapter(students);
                recyclerView = findViewById(R.id.recycler_view);
                recyclerView.addItemDecoration(new DividerItemDecoration(OutCampus.this,  LinearLayoutManager.VERTICAL));
                LinearLayoutManager layoutManager = new   LinearLayoutManager(OutCampus.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(campusadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(OutCampus.this, "Some Error Occured"+error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("erorr",error.getDetails());
            }
        });




    }
}
