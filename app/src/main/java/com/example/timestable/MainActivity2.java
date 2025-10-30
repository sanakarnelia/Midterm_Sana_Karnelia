package com.example.timestable;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ArrayAdapter<Integer> adapter;
    Button backBtn;
    ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        backBtn =findViewById(R.id.back);
        listView=findViewById(R.id.listview2);

        ArrayList<Integer> history  = MainActivity.getHistoryList();
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, history);
        listView.setAdapter(adapter);

        //back to main menu
        backBtn.setOnClickListener(v->{
           finish();
        });


    }
}