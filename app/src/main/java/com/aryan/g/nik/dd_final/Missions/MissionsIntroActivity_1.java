package com.aryan.g.nik.dd_final.Missions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.aryan.g.nik.dd_final.AllCharacter.CharacterSelectActivity;
import com.aryan.g.nik.dd_final.FightBox.FightBoxActivity;
import com.aryan.g.nik.dd_final.R;
import com.google.android.material.button.MaterialButton;

public class MissionsIntroActivity_1 extends AppCompatActivity {

    TextView tv_intro;
    MaterialButton mBtnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missions_intro_1);
        findViews();
        newAnimationAfterIntroText();
        loadAnimationScreen();
        loadAnimationStoryText();
    }

    private void findViews()
    {
        mBtnContinue = findViewById(R.id.tv_continue);

        mBtnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MissionsIntroActivity_1.this, CharacterSelectActivity.class));
            }
        });

        tv_intro = findViewById(R.id.tv_letter_intro_texts);
    }
    @SuppressLint("SetTextI18n")
    private void newAnimationAfterIntroText()
    {
        new Handler(getMainLooper()).postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                mBtnContinue.setVisibility(View.VISIBLE);
            }
        },5000);
    }


    private void loadAnimationScreen() {
        Animation animation;
        animation = AnimationUtils.loadAnimation(this, R.anim.fade_screen);

        ConstraintLayout constraintLayout = findViewById(R.id.cl_mission_intro_act);
        constraintLayout.startAnimation(animation);
    }

    private void loadAnimationStoryText()
    {
        tv_intro.setText("my long text1");
        tv_intro.append("\nmy long text2");
        tv_intro.append("\nmy long text3");
        tv_intro.append("\nmy long text4");
        tv_intro.append("\nmy long text5");
        tv_intro.append("\nmy long text6");
        tv_intro.append("\nmy long text7");
        tv_intro.append("\nmy long text8");
        tv_intro.append("\nmy long text9");
        tv_intro.append("\nmy long text10");
        tv_intro.append("\nmy long text11");
        tv_intro.append("\nmy long text12");
        tv_intro.append("\nmy long text13");
        tv_intro.append("\nmy long text14");
        tv_intro.append("\nmy long text15");
        tv_intro.append("\nmy long text16");
        tv_intro.append("\nmy long text17");
        tv_intro.append("\nmy long text18");
        tv_intro.append("\nmy long text19");
        tv_intro.append("\nmy long text20");
        Paint textPaint = tv_intro.getPaint();
        String text = tv_intro.getText().toString();//get text
//        int width = Math.round(textPaint.measureText(text));//measure the text size
        int height = Math.round(textPaint.measureText(text));//measure the text size
        ViewGroup.LayoutParams params =  tv_intro.getLayoutParams();
//        params.width = width;
        params.height = height;
        tv_intro.setLayoutParams(params); //refine

//        DisplayMetrics displaymetrics = new DisplayMetrics();
//        this.getWindowManager().getDefaultDisplay().getRealMetrics(displaymetrics);
//        int screenWidth = displaymetrics.widthPixels;
        //this is optional. do not scroll if text is shorter than screen width
        //remove this won't effect the scroll
//        if (width <= screenWidth) {
//            //All text can fit in screen.
//            return;
//        }
        //set the animation
        TranslateAnimation slide = new TranslateAnimation(0, 0, 2200, 0);
        slide.setDuration(5000);
        slide.setRepeatCount(0);
        slide.setRepeatMode(0);
        slide.setInterpolator(new LinearInterpolator());
        tv_intro.startAnimation(slide);
    }
}