package com.example.demo;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GetDataFromFireBase {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myReference;

    public ArrayList<Question> getQuesrion(){
        final ArrayList<Question> list = new ArrayList<>();

        firebaseDatabase = FirebaseDatabase.getInstance();
        myReference = firebaseDatabase.getReference("Mon Hoc").child("Toan").child("test").child("Đề số 1");
        final Question[] question = {null};
        Log.d("dexem", "vao dc roi");

        myReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // check = 0;
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // NUM = 1;
                    String title = (String) snapshot.child("title").getValue();
                    String viewQuestion = (String) snapshot.child("image").getValue();
                    String ansA = (String) snapshot.child("ansA").getValue();
                    String ansB = (String) snapshot.child("ansB").getValue();
                    String ansC = (String) snapshot.child("ansC").getValue();
                    String ansD = (String) snapshot.child("ansD").getValue();
                    String dapan = (String) snapshot.child("result").getValue();
                    question[0] = new Question(title, viewQuestion, ansA, ansB, ansC, ansD, dapan, "");
                    list.add(question[0]);
                    Log.d("de_xem", "test:" + ansA + "," + ansB + "," + ansC + "," + ansD + "!!!");
                }
                //  count = count+ NUM;
                //  NUM = 0;

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Fail_test", "ko connect dc vs Firebase");
            }

        });
        return list;
    }

}
