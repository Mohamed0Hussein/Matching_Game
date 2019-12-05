package com.example.matching_game;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView player,score;
    int Score;
    Random rand;
    int[] cards;
    int[] choosed_cards;
    ImageView[] viewing_cards;
    int[] pos;
    int n1,n2,n3,n4;
    public void fetchCards(){
        pos = new int[8];
        cards = new int[52];
        viewing_cards = new ImageView[8];
        viewing_cards[0] = findViewById(R.id.imageView1);
        viewing_cards[1] = findViewById(R.id.imageView2);
        viewing_cards[2] = findViewById(R.id.imageView3);
        viewing_cards[3] = findViewById(R.id.imageView4);
        viewing_cards[4] = findViewById(R.id.imageView5);
        viewing_cards[5] = findViewById(R.id.imageView6);
        viewing_cards[6] = findViewById(R.id.imageView7);
        viewing_cards[7] = findViewById(R.id.imageView8);


        cards[0] = R.drawable.c01;
        cards[1] = (R.drawable.c02);
        cards[2] = (R.drawable.c03);
        cards[3] = (R.drawable.c04);
        cards[4] = (R.drawable.c05);
        cards[5] = (R.drawable.c06);
        cards[6] = (R.drawable.c07);
        cards[7] = (R.drawable.c08);
        cards[8] = (R.drawable.c09);
        cards[9] = (R.drawable.c10);
        cards[10] = (R.drawable.c11);
        cards[11] = (R.drawable.c12);
        cards[12] = (R.drawable.c13);
        cards[13] = (R.drawable.d01);
        cards[14] = (R.drawable.d02);
        cards[15] = (R.drawable.d03);
        cards[16] = (R.drawable.d04);
        cards[17] = (R.drawable.d05);
        cards[18] = (R.drawable.d06);
        cards[19] = (R.drawable.d07);
        cards[20] = (R.drawable.d08);
        cards[21] = (R.drawable.d09);
        cards[22] = (R.drawable.d10);
        cards[23] = (R.drawable.d11);
        cards[24] = (R.drawable.d12);
        cards[25] = (R.drawable.d13);
        cards[26] = (R.drawable.h01);
        cards[27] = (R.drawable.h02);
        cards[28] = (R.drawable.h03);
        cards[29] = (R.drawable.h04);
        cards[30] = (R.drawable.h05);
        cards[31] = (R.drawable.h06);
        cards[32] = (R.drawable.h07);
        cards[33] = (R.drawable.h08);
        cards[34] = (R.drawable.h09);
        cards[35] = (R.drawable.h10);
        cards[36] = (R.drawable.h11);
        cards[37] = (R.drawable.h12);
        cards[38] = (R.drawable.h13);
        cards[39] = (R.drawable.s01);
        cards[40] = (R.drawable.s02);
        cards[41] = (R.drawable.s03);
        cards[42] = (R.drawable.s04);
        cards[43] = (R.drawable.s05);
        cards[44] = (R.drawable.s06);
        cards[45] = (R.drawable.s07);
        cards[46] = (R.drawable.s08);
        cards[47] = (R.drawable.s09);
        cards[48] = (R.drawable.s10);
        cards[49] = (R.drawable.s11);
        cards[50] = (R.drawable.s12);
        cards[51] = (R.drawable.s13);

    }
    public void StartPlaying(){
        choosed_cards = new int[4];
        n1=0;
        n2=0;
        n3=0;
        n4=0;
        for(int i=0;i<8;i++) {
            viewing_cards[i].setImageResource(R.drawable.card_back);
            viewing_cards[i].setTag(i);
        }
        do {
            n1 = rand.nextInt(52);
            n2 = rand.nextInt(52);
            n3 = rand.nextInt(52);
            n4 = rand.nextInt(52);
        } while((n1 == n2) || (n1 == n3) || (n1 == n4) || (n2 == n3) || (n2 == n4) || (n3 == n4));


        choosed_cards[0] = cards[n1];
        choosed_cards[1] = cards[n2];
        choosed_cards[2] = cards[n3];
        choosed_cards[3] = cards[n4];

        Log.i("Choosed Card 1",String.valueOf((n1)));
        Log.i("Choosed Card 2",String.valueOf((n2)));
        Log.i("Choosed Card 3",String.valueOf((n3)));
        Log.i("Choosed Card 4",String.valueOf((n4)));



        pos[0] = 0;
        pos[1] = 0;
        pos[2] = 1;
        pos[3] = 1;
        pos[4] = 2;
        pos[5] = 2;
        pos[6] = 3;
        pos[7] = 3;
    }

    public void CardPressed(final View v){
        //viewing_cards[Integer.parseInt(v.getTag().toString())].setImageResource(choosed_cards[pos[Integer.parseInt(v.getTag().toString())]]);
        final ObjectAnimator oa1 = ObjectAnimator.ofFloat(viewing_cards[Integer.parseInt(v.getTag().toString())], "scaleX", 1f, 0f);
        final ObjectAnimator oa2 = ObjectAnimator.ofFloat(viewing_cards[Integer.parseInt(v.getTag().toString())], "scaleX", 0f, 1f);
        oa1.setInterpolator(new DecelerateInterpolator());
        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
        oa1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                viewing_cards[Integer.parseInt(v.getTag().toString())].setImageResource(choosed_cards[pos[Integer.parseInt(v.getTag().toString())]]);
                oa2.start();
            }
        });
        oa1.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        rand = new Random();
        player = findViewById(R.id.player);
        player.setText(getIntent().getStringExtra("player"));
        fetchCards();
        StartPlaying();
    }
    public void reset(View v){
        StartPlaying();
    }
}
