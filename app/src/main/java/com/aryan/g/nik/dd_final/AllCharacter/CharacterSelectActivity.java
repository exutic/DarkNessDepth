package com.aryan.g.nik.dd_final.AllCharacter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aryan.g.nik.dd_final.FightBox.FightBoxActivity;
import com.aryan.g.nik.dd_final.R;

public class CharacterSelectActivity extends AppCompatActivity {

    Button btnArcherPage, btnKnightPage;
    Button btnArcherInfo, btnKnightInfo;
    Button btnArcherSelect, btnKnightSelect;
    ConstraintLayout cl_Archer, cl_Knight;
    LinearLayout ll_Archer_info, ll_Knight_info;


    public static PersonClass MainCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_select);

        findViews();
    }

    public void findViews() {
        cl_Archer = findViewById(R.id.cl_archer_page);
        ll_Archer_info = findViewById(R.id.ll_archer_info_page);
        btnArcherPage = findViewById(R.id.btn_show_archer_page);
        btnArcherInfo = findViewById(R.id.btn_info_archer);
        btnArcherSelect = findViewById(R.id.btn_select_archer);


        cl_Knight = findViewById(R.id.cl_warrior_page);
        ll_Knight_info = findViewById(R.id.ll_warrior_info_page);
        btnKnightPage = findViewById(R.id.btn_show_warrior_page);
        btnKnightInfo = findViewById(R.id.btn_info_warrior);
        btnKnightSelect = findViewById(R.id.btn_select_warrior);

        KnightDisables();

        ArcherButtons();
        KnightButtons();

    }

    public void ArcherButtons() {
        cl_Archer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_Archer_info.setVisibility(View.GONE);
            }
        });

        btnArcherPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cl_Knight.setVisibility(View.GONE);
                cl_Archer.setVisibility(View.VISIBLE);
                ArcherEnables();
                KnightDisables();
            }
        });

        btnArcherInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_Archer_info.setVisibility(View.VISIBLE);
            }
        });

        btnArcherSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainCharacter = new PersonClass("LSK", 10,1, 50, 0, 5, 15, 1);
                startActivity(new Intent(CharacterSelectActivity.this, FightBoxActivity.class));
            }
        });
    }

    public void KnightButtons() {
        cl_Knight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_Knight_info.setVisibility(View.GONE);
            }
        });

        btnKnightPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cl_Knight.setVisibility(View.VISIBLE);
                cl_Archer.setVisibility(View.GONE);
                ArcherDisables();
                KnightEnables();
            }
        });

        btnKnightInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_Knight_info.setVisibility(View.VISIBLE);
            }
        });

        btnKnightSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CharacterSelectActivity.this, "Under Development", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ArcherEnables() {
        cl_Archer.setEnabled(true);
        ll_Archer_info.setEnabled(true);
        btnArcherInfo.setEnabled(true);
        btnArcherSelect.setEnabled(true);
    }

    public void ArcherDisables() {
        cl_Archer.setEnabled(false);
        ll_Archer_info.setEnabled(false);
        btnArcherInfo.setEnabled(false);
        btnArcherSelect.setEnabled(false);
    }

    public void KnightEnables() {
        cl_Knight.setEnabled(true);
        ll_Knight_info.setEnabled(true);
        btnKnightInfo.setEnabled(true);
        btnKnightSelect.setEnabled(true);
    }

    public void KnightDisables() {
        cl_Knight.setEnabled(false);
        ll_Knight_info.setEnabled(false);
        btnKnightInfo.setEnabled(false);
        btnKnightSelect.setEnabled(false);
    }

}
