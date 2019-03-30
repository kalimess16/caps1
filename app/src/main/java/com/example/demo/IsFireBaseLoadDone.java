package com.example.demo;

import java.util.ArrayList;

public interface IsFireBaseLoadDone {
    void onFirebaseLoadSuccess(ArrayList<Question> arrayList);

    void onFirebaseLoadFailed(String mess);
}
