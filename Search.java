package com.example.ilovebooksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Search extends AppCompatActivity {

    EditText name;
    Button search, back;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        DB = new DatabaseHelper(this);
        name =  findViewById(R.id.name);
        search =  findViewById(R.id.btnSearch);
        back = findViewById(R.id.back);

        //Search Code
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                SQLiteDatabase simpledb = getApplicationContext().openOrCreateDatabase("Userdata.db",Context.MODE_PRIVATE, null);
                Cursor res = simpledb.rawQuery("Select * from Userdetails where name='"+n+"'", null);
                if (res.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(), "No Record Found", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Name  \t "+res.getString(0)+"\n");
                    buffer.append("Contact  \t "+res.getString(1)+"\n");
                    buffer.append("Name of Books  \t "+res.getString(2)+"\n");
                }
                Toast.makeText(getApplicationContext(), "Result \n"+buffer.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        //Button to take you back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Search.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}