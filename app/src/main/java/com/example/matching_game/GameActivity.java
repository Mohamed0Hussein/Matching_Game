package com.example.matching_game;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView player, score;
    int Score;
    int pressed_card_1;
    int pressed_card_2;
    int pressed_pos_1;
    int pressed_pos_2;
    boolean[] opened_cards;
    Random rand;
    int[] cards;
    int[] choosed_cards;
    ImageView[] viewing_cards;
    //    int[] pos;
    int n1, n2, n3, n4;

    public void fetchCards() {
        pressed_card_1 = 0;
        pressed_card_2 = 0;
//        pos = new int[8];
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

    public void StartPlaying() {
        for(int i =0;i<8;i++) {
            viewing_cards[i].setEnabled(true);
            opened_cards[i] = false;
        }
        pressed_pos_1 = -1;
        pressed_pos_2 = -1;
        Score = 0;
        score.setText("Score:" + Score);
        choosed_cards = new int[8];
        n1 = 0;
        n2 = 0;
        n3 = 0;
        n4 = 0;
        for (int i = 0; i < 8; i++) {
            viewing_cards[i].setImageResource(R.drawable.card_back);
            viewing_cards[i].setTag(i);
        }
        do {
            n1 = rand.nextInt(52);
            n2 = rand.nextInt(52);
            n3 = rand.nextInt(52);
            n4 = rand.nextInt(52);
        } while ((n1 == n2) || (n1 == n3) || (n1 == n4) || (n2 == n3) || (n2 == n4) || (n3 == n4));


        choosed_cards[0] = cards[n1];
        choosed_cards[1] = cards[n2];
        choosed_cards[2] = cards[n3];
        choosed_cards[3] = cards[n4];
        choosed_cards[4] = cards[n1];
        choosed_cards[5] = cards[n2];
        choosed_cards[6] = cards[n3];
        choosed_cards[7] = cards[n4];

        shuffle(choosed_cards);


    }

    public void CardPressed(final View v) {
        for(int i=0;i<8;i++){
            viewing_cards[i].setEnabled(false);
        }
        //viewing_cards[Integer.parseInt(v.getTag().toString())].setImageResource(choosed_cards[pos[Integer.parseInt(v.getTag().toString())]]);
        final ObjectAnimator oa1 = ObjectAnimator.ofFloat(viewing_cards[Integer.parseInt(v.getTag().toString())], "scaleX", 1f, 0f);
        final ObjectAnimator oa2 = ObjectAnimator.ofFloat(viewing_cards[Integer.parseInt(v.getTag().toString())], "scaleX", 0f, 1f);
        oa1.setInterpolator(new DecelerateInterpolator());
        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
        oa1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                viewing_cards[Integer.parseInt(v.getTag().toString())].setImageResource(choosed_cards[Integer.parseInt(v.getTag().toString())]);
                oa2.start();
            }
        });
        oa1.start();
        if (pressed_card_1 == 0) {
            pressed_card_1 = choosed_cards[Integer.parseInt(v.getTag().toString())];
            pressed_pos_1=Integer.parseInt(v.getTag().toString());
            viewing_cards[pressed_pos_1].setEnabled(false);
            for(int i=0;i<8;i++){
                if(i!=pressed_pos_1)
                    viewing_cards[i].setEnabled(true);
            }
        } else if (pressed_card_2 == 0) {
            pressed_card_2 = choosed_cards[Integer.parseInt(v.getTag().toString())];
            pressed_pos_2=Integer.parseInt(v.getTag().toString());
            viewing_cards[pressed_pos_2].setEnabled(false);

            if (pressed_card_1 == pressed_card_2) {
                Score++;
                score.setText("Score: " + Score);
                if (Score == 4) {
                    score.setText("Press Reset to play");
                }
                opened_cards[pressed_pos_1] = true;
                opened_cards[pressed_pos_2] = true;
                viewing_cards[pressed_pos_2].setEnabled(false);
                viewing_cards[pressed_pos_1].setEnabled(false);
                for(int i=0;i<8;i++){
                    if(i != pressed_pos_1 && i != pressed_pos_2)
                        viewing_cards[i].setEnabled(true);
                }
                pressed_pos_1=-1;
                pressed_pos_2=-1;
                pressed_card_2=0;
                pressed_card_1=0;




            } else {
                Score--;
                score.setText("Score: "+Score);

                new CountDownTimer(1000, 100) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        for(int i=0;i<8;i++){
                            viewing_cards[i].setEnabled(false);
                        }
                        final ObjectAnimator oaaa1 = ObjectAnimator.ofFloat(viewing_cards[pressed_pos_2], "scaleX", 1f, 0f);
                        final ObjectAnimator oaaa2 = ObjectAnimator.ofFloat(viewing_cards[pressed_pos_2], "scaleX", 0f, 1f);
                        oaaa1.setInterpolator(new DecelerateInterpolator());
                        oaaa2.setInterpolator(new AccelerateDecelerateInterpolator());
                        oaaa1.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                viewing_cards[pressed_pos_2].setImageResource(R.drawable.card_back);
                                oaaa2.start();
                            }
                        });
                        oaaa1.start();
                        final ObjectAnimator oaa1 = ObjectAnimator.ofFloat(viewing_cards[pressed_pos_1], "scaleX", 1f, 0f);
                        final ObjectAnimator oaa2 = ObjectAnimator.ofFloat(viewing_cards[pressed_pos_1], "scaleX", 0f, 1f);
                        oaa1.setInterpolator(new DecelerateInterpolator());
                        oaa2.setInterpolator(new AccelerateDecelerateInterpolator());
                        oaa1.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                viewing_cards[pressed_pos_1].setImageResource(R.drawable.card_back);
                                oaa2.start();
                            }
                        });
                        oaa1.start();



                    }


                }.start();

                new CountDownTimer(2000,100){

                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        pressed_pos_2=-1;
                        pressed_pos_1=-1;
                        pressed_card_1=0;
                        pressed_card_2=0;
                        for(int i=0;i<8;i++){
                            if(!opened_cards[i])
                                viewing_cards[i].setEnabled(true);
                        }
                    }
                }.start();

            }



        }
    }

    public static void shuffle(int[] tempArr) {
        Random rand = new Random();

        for (int i = 0; i < tempArr.length; i++) {
            int randomIndexToSwap = rand.nextInt(tempArr.length);
            int temp = tempArr[randomIndexToSwap];
            tempArr[randomIndexToSwap] = tempArr[i];
            tempArr[i] = temp;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        opened_cards = new boolean[8];
        rand = new Random();
        player = findViewById(R.id.player);
        score = findViewById(R.id.score);
        player.setText(getIntent().getStringExtra("player"));
        fetchCards();
        StartPlaying();
    }

    public void reset(View v) {
        StartPlaying();
    }
}
