package com.example.saibahmed.tic_tac_toe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int MyActivePlayer = 0;
    // 0 for cross and 1 for circle

    //my game state

    int[] MyGameState = {2,2,2,2,2,2,2,2,2};

    public void imageTapped(View view){
        ImageView myTapped=(ImageView) view;
        int TappedImageTag=Integer.parseInt(myTapped.getTag().toString());

        if (MyGameState[TappedImageTag]==2){
            MyGameState[TappedImageTag]=MyActivePlayer;

            if (MyActivePlayer==0)
            {
                myTapped.setImageResource(R.drawable.cross);
                myTapped.animate().rotation(360).setDuration(600);
                MyActivePlayer=1;
            }else {
                myTapped.setImageResource(R.drawable.circle);
                MyActivePlayer=0;
            }

        }
        else{
            Toast.makeText(this,"This position is already filled!",Toast.LENGTH_SHORT).show();
        }

    }

    public void PlayAgain(View view)
    {
        //change game state back to 2
        for (int i=0;i<MyGameState.length;i++)
        {
            MyGameState[i]=2;
        }

        // make active player 0 again
        MyActivePlayer = 0;


        //change all image to ic_launcher
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.lineone);
        for (int i=0;i<linearLayout.getChildCount();i++)
        {
            ((ImageView)linearLayout.getChildAt(i)).setImageResource(R.drawable.img);

        }

        LinearLayout linearLayoutone=(LinearLayout)findViewById(R.id.linetwo);
        for (int i=0;i<linearLayoutone.getChildCount();i++)
        {
            ((ImageView)linearLayoutone.getChildAt(i)).setImageResource(R.drawable.img);
        }

        LinearLayout linearLayoutthree=(LinearLayout)findViewById(R.id.linethree);
        for (int i=0;i<linearLayoutthree.getChildCount();i++)
        {
            ((ImageView)linearLayoutthree.getChildAt(i)).setImageResource(R.drawable.img);
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
