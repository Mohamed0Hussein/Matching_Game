package com.example.matching_game;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void Start(View v){
        button_click.start();
        Intent intent = new Intent(this,GameActivity.class);
        intent.putExtra("player",playerName.getText().toString());
        startActivity(intent);

    }
    MediaPlayer button_click;
    EditText playerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        button_click = MediaPlayer.create(this,R.raw.button_click);

        playerName = findViewById(R.id.editText);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
