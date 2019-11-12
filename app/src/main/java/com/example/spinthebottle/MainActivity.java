package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_spin;
    ImageView iv_bottle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_spin = (Button) findViewById(R.id.b_spin);
        iv_bottle = (ImageView) findViewById(R.id.iv_bottle);

        b_spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final int thespinDegrees;

                Random r = new Random();


                thespinDegrees = r.nextInt(3600);


                RotateAnimation rotateBottle = new RotateAnimation(0, thespinDegrees, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);

                rotateBottle.setDuration(2000);
                rotateBottle.setFillAfter(true);

                rotateBottle.setInterpolator(new AccelerateDecelerateInterpolator());

                rotateBottle.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // Toast
                        if ((thespinDegrees % 360 > 90) && (thespinDegrees % 360 <179)){
                            // left has been chosen
                            //Toast.makeText(MainActivity.this, "Left " + thespinDegrees % 360, Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainActivity.this, "The person to the SE has been chosen", Toast.LENGTH_SHORT).show();

                        } else if ((thespinDegrees % 360 > 180) && (thespinDegrees % 360 < 269)) {
                            // right has been chosen
                            Toast.makeText(MainActivity.this, "The person to the SW has been chosen", Toast.LENGTH_SHORT).show();

                        } else if ((thespinDegrees % 360 > 270) && (thespinDegrees % 360 < 359)){
                            Toast.makeText(MainActivity.this, "The person to the NW has been chosen", Toast.LENGTH_SHORT).show();


                        } else if ((thespinDegrees % 360 > 0) && (thespinDegrees % 360 < 89)) {
                            Toast.makeText(MainActivity.this, "The person to the NE has been chosen", Toast.LENGTH_SHORT).show();


                        }

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                iv_bottle.startAnimation(rotateBottle);





            }
        });
    }
}
