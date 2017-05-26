package com.example.salvador.animations_practices;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    TextView textView2;
    Button button;
    ObjectAnimator animation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ValueAnimator animation = ValueAnimator.ofFloat(0f, 100f);
        animation.setDuration(1000);
        animation.start();

        textView = (TextView)findViewById(R.id.my_textview);
        textView2 = (TextView)findViewById(R.id.my_textview2);

        findViewById(R.id.my_button).setOnClickListener(this);

        animation2 = ObjectAnimator.ofFloat(textView2, "Rotation", 360f);
        animation2.setDuration(1500);



        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator updatedAnimation) {
                // You can use the animated value in a property that uses the
                // same type as the animation. In this case, you can use the
                // float value in the translationX property.
                float animatedValue = (float)updatedAnimation.getAnimatedValue();
                textView.setTranslationX(animatedValue);
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
        case R.id.my_button:


            animation2.start();

            break;
        default:
            break;

        }

    }
}
