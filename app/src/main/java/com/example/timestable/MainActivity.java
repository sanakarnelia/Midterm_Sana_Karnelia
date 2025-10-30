package com.example.timestable;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button tableBn,HistoryBtn;
    EditText userInput;

    ListView listView;

    private ArrayList<String> TableList = new ArrayList<>();
    private static ArrayList<Integer> HistoryList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        userInput = findViewById(R.id.userIn);
        tableBn = findViewById(R.id.tableBtn);
        HistoryBtn = findViewById(R.id.historybtn);
        listView = findViewById(R.id.listview);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,TableList);
        listView.setAdapter(adapter);

        //start second activity (History view)when user click on the history button
        HistoryBtn.setOnClickListener( v ->{
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putIntegerArrayListExtra("HistoryList",HistoryList);
            startActivity(intent);
        });


        //when user click on table button
        tableBn.setOnClickListener(v -> calculateTable());
    }
    public void calculateTable(){
       String number = userInput.getText().toString();

        //check if user input is not null
        if(number.isEmpty()){
            Toast.makeText(this,"plz Enter A number",Toast.LENGTH_SHORT).show();
            return;
        }
        //Calculate table
        int Tnumber = Integer.parseInt(number);
        for( int i=1;i<=10;i++){
            TableList.add(Tnumber + " X " + i +" = " + (Tnumber*i));

        }
        adapter.notifyDataSetChanged();


        if(!HistoryList.contains(Tnumber)){
            HistoryList.add(Tnumber);
        }




    }
}