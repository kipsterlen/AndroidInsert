package com.example.lterer.androidinsertt;import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RetrieveActivity extends AppCompatActivity {


    DatabaseReference databaseReference;

    ProgressDialog progressDialog;

    List<StudentDetails> list = new ArrayList<>();

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(RetrieveActivity.this));

        progressDialog = new ProgressDialog(RetrieveActivity.this);

        progressDialog.setMessage("Loading Data from Firebase Database");

        progressDialog.show();

        databaseReference = FirebaseDatabase.getInstance().getReference(MainActivity.Database_Path);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    StudentDetails studentDetails = dataSnapshot.getValue(StudentDetails.class);

                    list.add(studentDetails);
                }

                adapter = new RecyclerViewAdapter(RetrieveActivity.this, list);

                recyclerView.setAdapter(adapter);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();

            }
        });

    }
}
