package com.aryan.g.nik.dd_final.MainMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.aryan.g.nik.dd_final.AllCharacter.PersonClass;
import com.aryan.g.nik.dd_final.AllCharacter.CharacterSelectActivity;
import com.aryan.g.nik.dd_final.Missions.MissionsIntroActivity_1;
import com.aryan.g.nik.dd_final.R;
import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Animation unFade, shake, fadeIn, fadeOut, enterFromLeft, enterFromRight, enterFromRightDown, enterFromRightUp, enterFromUp, enterFromUpRight, enterFromUpLeft, enterFromDown, enterFromDownRight, enterFromDownLeft;
    TextView txtD, txtA, txtR, txtK, txtN, txtE, txtS, txtS2, txtD2, txtE2, txtP, txtT, txtH, txt1;
    MaterialButton mBtnStartGame, mBtnLoadgame, mBtnSettings, mBtnExit;
    int backButtonCount = 0;


    public static PersonClass Enemy1;
    Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //4 buttons
        //animated background
        //animated buttons

        //btn new game - fresh start in the game with character select
        //btn continue - you will start where you left of
        //btn option - manage sounds - text font
        //btn about - some intro about text base games and this version
        //btn exit - will shutdown the application

        //scoreboard for other players -> online have to connect to 1 website refer to the game

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findVIEWS();
        setAnimation();
        getAnimation();

        createRandomEnemy();

    }

    @SuppressLint("NonConstantResourceId")
    public void onClickS(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.main_btn_new_game:
//                Toast.makeText(this, "Start Game", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MissionsIntroActivity_1.class));
                overridePendingTransition(0,0);
                break;
            case R.id.main_btn_load_game:
                Toast.makeText(this, "Load Game", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_btn_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_btn_about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_btn_exit_game:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                break;
        }
    }

    void findVIEWS() {
        txtD = findViewById(R.id.main_game_title_d1);
        txtA = findViewById(R.id.main_game_title_a);
        txtR = findViewById(R.id.main_game_title_r);
        txtK = findViewById(R.id.main_game_title_k);
        txtN = findViewById(R.id.main_game_title_n);
        txtE = findViewById(R.id.main_game_title_e1);
        txtS = findViewById(R.id.main_game_title_s1);
        txtS2 = findViewById(R.id.main_game_title_s2);
        txtD2 = findViewById(R.id.main_game_title_d2);
        txtE2 = findViewById(R.id.main_game_title_e2);
        txtP = findViewById(R.id.main_game_title_p);
        txtT = findViewById(R.id.main_game_title_t);
        txtH = findViewById(R.id.main_game_title_h);
        txt1 = findViewById(R.id.main_game_title_1);

        txtD.setVisibility(View.INVISIBLE);
        txtA.setVisibility(View.INVISIBLE);
        txtR.setVisibility(View.INVISIBLE);
        txtK.setVisibility(View.INVISIBLE);
        txtN.setVisibility(View.INVISIBLE);
        txtE.setVisibility(View.INVISIBLE);
        txtS.setVisibility(View.INVISIBLE);
        txtS2.setVisibility(View.INVISIBLE);
        txtD2.setVisibility(View.INVISIBLE);
        txtE2.setVisibility(View.INVISIBLE);
        txtP.setVisibility(View.INVISIBLE);
        txtT.setVisibility(View.INVISIBLE);
        txtH.setVisibility(View.INVISIBLE);
        txt1.setVisibility(View.INVISIBLE);
    }

    void setAnimation() {
//        fadeIn = new AlphaAnimation(0, 1);
//        fadeIn.setInterpolator(new DecelerateInterpolator());
//        fadeIn.setDuration(1200);

        fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setStartOffset(400);
        fadeOut.setDuration(0);

        enterFromLeft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_enter_from_left);
        enterFromRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_enter_from_right);
        enterFromDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_enter_from_down);
        enterFromUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_enter_from_up);


        enterFromRightDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_enter_from_right_down);
        enterFromRightUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_enter_from_right_up);

        enterFromUpRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_enter_from_up_right);
        enterFromUpLeft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_enter_from_up_left);

        enterFromDownRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_enter_from_down_right);
        enterFromDownLeft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_enter_from_down_left);

        shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_shake);

        unFade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_unfade);
    }

    void getAnimation() {

        new Handler().postDelayed(new Runnable() {
            public void run() {
                txtA.setVisibility(View.VISIBLE);
                txtR.setVisibility(View.VISIBLE);
                txtK.setVisibility(View.VISIBLE);
                txtN.setVisibility(View.VISIBLE);
                txtE.setVisibility(View.VISIBLE);
                txtS.setVisibility(View.VISIBLE);
                txtS2.setVisibility(View.VISIBLE);
                txtE2.setVisibility(View.VISIBLE);
                txtP.setVisibility(View.VISIBLE);
                txtT.setVisibility(View.VISIBLE);
                txtH.setVisibility(View.VISIBLE);

                txtA.startAnimation(enterFromLeft);
                txtR.startAnimation(enterFromUpLeft);
                txtK.startAnimation(enterFromDownLeft);

                txtN.startAnimation(enterFromUp);
                txtE.startAnimation(enterFromDown);
                txtS.startAnimation(enterFromUpRight);
                txtS2.startAnimation(enterFromDownRight);

                txtE2.startAnimation(enterFromDownRight);
                txtP.startAnimation(enterFromRightDown);
                txtT.startAnimation(enterFromRightUp);
                txtH.startAnimation(enterFromRight);


            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                txtD.startAnimation(unFade);
                txtD2.startAnimation(unFade);
                txt1.startAnimation(unFade);


            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                txtD.setVisibility(View.VISIBLE);
                txtD2.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.VISIBLE);
            }
        }, 2400);

        new Handler().postDelayed(new Runnable() {
            public void run() {

                txtD.startAnimation(shake);
                txtD2.startAnimation(shake);
                txt1.startAnimation(shake);
            }
        }, 3200);


    }

    void createRandomEnemy() {
        rnd = new Random();
        Enemy1 = new PersonClass("Dalam", rnd.nextInt(10) + 20, 1,
                rnd.nextInt(15) + 35, 0, rnd.nextInt(4) + 1, rnd.nextInt(10) + 5, 2);
    }

    @Override
    public void onBackPressed() {
        /**
         * Back button listener.
         * Will close the application if the back button pressed twice.
         */
        if (backButtonCount == 1) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
            backButtonCount = 1;
        }

    }
}
