package com.appandroid.proejct;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int score;
    private int width, height, prevX, prevY;
    DisplayMetrics displayMetrics = new DisplayMetrics();
    private ImageView ball;
    private Random rand = new Random();
    private TextView scoreText;
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize text and ball variables
        scoreText = findViewById(R.id.score);
        ball = findViewById(R.id.ball);

        //Array for all images of the ball
        images = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};

        //Get window height and width
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;

        //Set default previous positions
        prevX=(int) ball.getX();
        prevY=(int) ball.getY();
    }

    public void moveBall(View v){
        //Set the previous positions to the current one
        prevX=(int) ball.getX();
        prevY=(int) ball.getY();

        //Get new positions within the users view
        int newX = rand.nextInt(width-ball.getWidth()*2)+ball.getWidth();
        int newY = rand.nextInt(height-ball.getHeight()+100)+ball.getHeight();

        //Set the ball's  positions to the new positions
        ball.setX(newX);
        ball.setY(newY);

        //Update the score and text
        score++;
        scoreText.setText("Times hit: " + score);
    }

    public void resetGame(View v){
        //Position the ball to the middle
        ball.setX(width/2);
        ball.setY(height/2);

        //Set its image to the original(basket ball)
        ball.setImageResource(images[0]);

        //Set the score to zero and reset its text
        score=0;
        scoreText.setText("Times hit: " + score);
    }

    public void moveBack(View v){
        //Set the balls position to its previous position variables
        ball.setX(prevX);
        ball.setY(prevY);
    }

    public void changeBall(View v){
        //Create a random integer between 0 and the number of images
        int randomImg = rand.nextInt(5);

        //Set the ball's image to a random image using the random number
        ball.setImageResource(images[randomImg]);
    }
}