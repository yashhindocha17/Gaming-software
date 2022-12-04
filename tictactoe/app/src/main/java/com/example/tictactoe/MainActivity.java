package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    boolean gameActive= true;
    int activePlayer=1;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winPos = {{0,1,2}, {3,4,5}, {6,7,8},
                      {0,3,6}, {1,4,7}, {2,5,8},
                      {0,4,8}, {2,4,6}};

    @SuppressLint("SetTextI18n")
    public void playerTap(View view)
    {
        ImageView img =(ImageView) view;
        int TappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive)
        {
            gameReset(view);
        }

        if(gameState[TappedImage]==2 && gameActive)
        {
            gameState[TappedImage]=activePlayer;
            img.setTranslationY(-10f);
            if(activePlayer==1){
                img.setImageResource(R.drawable.o);
                activePlayer= 0;
                TextView status = findViewById(R.id.Status);
                status.setText("X's turn - tap to play");
            }
            else{
                img.setImageResource(R.drawable.xq);
                activePlayer=1;
                TextView status = findViewById(R.id.Status);
                status.setText("O's turn - tap to play");
            }
            img.animate().translationXBy(0f).setDuration(300);
        }
        for(int[] winPose: winPos){
            if(gameState[winPose[0]]==gameState[winPose[1]] &&
                    gameState[winPose[1]]==gameState[winPose[2]] &&
                    gameState[winPose[0]]!=2 )
            {
                gameActive=false;
                String winnerStr;
                if(gameState[winPose[0]]==0)
                {
                    winnerStr="x won";
                }
                else
                {
                    winnerStr="O won";
                }
                TextView status = findViewById(R.id.Status);
                status.setText(winnerStr);
            }

        }
    }

    @SuppressLint("SetTextI18n")
    public void gameReset(View view)
    {
        gameActive=true;
        activePlayer=0;
        Arrays.fill(gameState, 2);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);



        TextView status = findViewById(R.id.Status);
        status.setText("O's Turn - Tap to play");
    }

//    public void playagain(View view){
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}