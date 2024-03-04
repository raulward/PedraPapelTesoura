package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectRock(View view) {
        verifyWinner("Rock");
    }

    public void selectPaper(View view) {
        verifyWinner("Paper");

    }

    public void selectScissor(View view) {
        verifyWinner("Scissor");

    }

    private String generateRandomChoice(){
        String[] choices = new Choices().choices;

        int randomNumber = new Random().nextInt(3);

        ImageView imageView = findViewById(R.id.image_default);
        ImageChoices imageAppChoice = new ImageChoices();

        String randomChoice = choices[randomNumber];
        switch (randomChoice){
            case "Rock":
                imageView.setImageResource(imageAppChoice.images[randomNumber]);
                break;
            case "Paper":
                imageView.setImageResource(imageAppChoice.images[randomNumber]);
                break;
            case "Scissor":
                imageView.setImageResource(imageAppChoice.images[randomNumber]);;
                break;

        }
        return randomChoice;

    }

    private void verifyWinner(String userChoice) {

        String appChoice = generateRandomChoice();

        TextView textResult = findViewById(R.id.text_result);
        ImageView imageView = findViewById(R.id.image_default);


        if (userChoice.equals(appChoice)){
            textResult.setText("Empate!");
        } else if (
                (userChoice.equals("Rock") && appChoice.equals("Scissor")) ||
                (userChoice.equals("Paper") && appChoice.equals("Rock")) ||
                (userChoice.equals("Scissor") && appChoice.equals("Paper"))

        ) {
            textResult.setText("Parabéns! Você ganhou :)");
        } else {
            textResult.setText("Que pena! Você perder :(");
        }


    }


}