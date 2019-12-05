package com.example.matching_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void Start(View v){
        Intent intent = new Intent(this,GameActivity.class);
        intent.putExtra("player",playerName.getText().toString());
        startActivity(intent);

    }
    EditText playerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerName = findViewById(R.id.editText);
    }
}
