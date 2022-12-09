package com.example.android_3125_ex5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.android_3125_ex5.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int computerScore = 0;
    private int userScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageArray = { R.drawable.dice1, R.drawable.dice2,
                R.drawable.dice3, R.drawable.dice4,
                R.drawable.dice5, R.drawable.dice6 };

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random1 = generateRandomNumber(0,5);
                int random2 = generateRandomNumber(0,5);

                binding.diceP1.setImageResource(imageArray[random1]);
                binding.diceP2.setImageResource(imageArray[random2]);

                int score = Math.abs(random1 - random2);

                if (random1 > random2) {
                    computerScore += score;
                    binding.scoreP2.setText("Score : " + computerScore);
                } else {
                    userScore += score;
                    binding.scoreP1.setText("Score : "+userScore);
                }
            }
        });
    }

    public static int generateRandomNumber(int min, int max) {
        return new Random().nextInt((max- min) + 1) + min;
    }
}