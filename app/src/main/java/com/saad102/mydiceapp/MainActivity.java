package com.saad102.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnRollTheDice;
    private ImageView dice1;
    private ImageView dice2;
    private int [] diceImages = {R.drawable.dice1, R.drawable.dice2,
            R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRollTheDice = (Button)findViewById(R.id.btnRolalTheDice);
        dice1 = (ImageView) findViewById(R.id.dice1);
        dice2 = (ImageView) findViewById(R.id.dice2);
       final MediaPlayer diceSound = MediaPlayer.create(this, R.raw.dice_sound);






        btnRollTheDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rndObj = new Random();
                int myRndNumber = rndObj.nextInt(6);
                dice1.setImageResource(diceImages[myRndNumber]);

                myRndNumber = rndObj.nextInt(6);
                dice2.setImageResource(diceImages[myRndNumber]);
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(5)
                        .playOn(dice1);
                YoYo.with(Techniques.Shake)
                        .duration(400
                        )
                        .repeat(5)
                        .playOn(dice2);

                diceSound.start();
            }
        });
    }
}