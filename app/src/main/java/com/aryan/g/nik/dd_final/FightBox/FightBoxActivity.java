package com.aryan.g.nik.dd_final.FightBox;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aryan.g.nik.dd_final.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import static com.aryan.g.nik.dd_final.AllCharacter.CharacterSelectActivity.MainCharacter;
import static com.aryan.g.nik.dd_final.MainMenu.MainActivity.Enemy1;

public class FightBoxActivity extends AppCompatActivity {

    LinearLayout ll_loot_result;
    TextView tv_result_log;
    TextView tv_player_stat;
    TextView tv_enemy_stat;
    TextView tv_loot_result;
    Button btnAttack;
    Button btn_loot;
    int round = 0;

    JSONObject JSON_Weapon;
    String JSON;

    Random WeaponDropChance;


    JSONObject JsonObjLoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_box);
        findViews();


    }

    private void findViews() {
        WeaponDropChance = new Random();

        ll_loot_result = findViewById(R.id.ll_loot_result);
        tv_loot_result = findViewById(R.id.tv_loot_result);

        tv_player_stat = findViewById(R.id.tv_player_stat);
        tv_enemy_stat = findViewById(R.id.tv_enemy_stat);

        tv_result_log = findViewById(R.id.tv_log);
        tv_result_log.setMovementMethod(new ScrollingMovementMethod());
        btn_loot = findViewById(R.id.btn_loot);
        btn_loot.setEnabled(false);
        btnAttack = findViewById(R.id.btn_attack);

        tv_player_stat.append("\n\nPlayer Stats");
        tv_player_stat.append("\nName: " + MainCharacter.getName());
        tv_player_stat.append("\nLevel: " + MainCharacter.getLevel());
        tv_player_stat.append("\nHp: " + MainCharacter.getHitPoint());
        tv_player_stat.append("\nHit Rate: " + MainCharacter.getHitRating());
        tv_player_stat.append("\nCrit Chance: " + MainCharacter.getCritChanceRating());
        tv_player_stat.append("\nNormal Dmg: " + MainCharacter.getNormalDamage());
        tv_player_stat.append("\nXp: " + MainCharacter.getXp());

        tv_enemy_stat.append("\n\nEnemy Stats");
        tv_enemy_stat.append("\nName: " + Enemy1.getName());
        tv_enemy_stat.append("\nLevel: " + Enemy1.getLevel());
        tv_enemy_stat.append("\nHp: " + Enemy1.getHitPoint());
        tv_enemy_stat.append("\nHit Rate: " + Enemy1.getHitRating());
        tv_enemy_stat.append("\nCrit Chance: " + Enemy1.getCritChanceRating());
        tv_enemy_stat.append("\nNormal Dmg: " + Enemy1.getNormalDamage());
        tv_enemy_stat.append("\nXp: " + Enemy1.getXp());
    }

    private void LoadJSONWeapon(int index) {
        try {
            JSON = ConvertJSONIntoString();
            JSON_Weapon = new JSONObject(JSON);
            JSONArray wJsonArray = JSON_Weapon.getJSONArray("Level_1_Weapons_Bow");

            JsonObjLoot = wJsonArray.getJSONObject(index);


        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    private String ConvertJSONIntoString() throws IOException {
        InputStream is = getResources().openRawResource(R.raw.weapons);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
        }

        return writer.toString();
    }

    @SuppressLint("NonConstantResourceId")
    public void attackAction(View view) throws JSONException {
        int id = view.getId();

        switch (id) {
            case R.id.btn_attack:
                //check round
                round++;

                tv_result_log.append("\n\n<><><><><><> Round : " + round + "<><><><><><>");

                //check characters situation (skipped)

                //ability coolDown check (skipped)

                //environment buff check (skipped)

                int CharHitChance = new Random().nextInt(100);
                int CharCritChance = new Random().nextInt(100);
                int CharDmg = 0;

                if (MainCharacter.getHitRating() >= CharHitChance) {
                    if (MainCharacter.getCritChanceRating() >= CharCritChance) {
                        CharDmg = MainCharacter.getNormalDamage() * 2;
                        //announce
                        tv_result_log.append("\nCritical Vow!!!!!!");
                        tv_result_log.append("\nLSK Crit Damage Occurred: " + CharDmg);
                    } else //normal dmg
                    {
                        CharDmg = MainCharacter.getNormalDamage();
                        tv_result_log.append("\nLSK Damage Occurred: " + CharDmg);
                    }

                    if (CharDmg <= Enemy1.getArmor()) {
                        CharDmg = 0;
                        tv_result_log.append("\nEnemy Dodged...");
                    } else {
                        CharDmg = CharDmg - Enemy1.getArmor();
                    }

                    Enemy1.setHitPoint(Enemy1.getHitPoint() - CharDmg);

                } else //miss attack
                {
                    //announce miss
                    tv_result_log.append("\nLSK Damage missed");
                }
//========================================= << Enemy >> =====================================================================

                int EnemyHitChance = new Random().nextInt(100);
                int EnemyCritChance = new Random().nextInt(100);
                int EnemyDmg = 0;

                if (Enemy1.getHitRating() >= EnemyHitChance) {
                    if (Enemy1.getCritChanceRating() >= EnemyCritChance) {
                        EnemyDmg = Enemy1.getNormalDamage() * 2;
                        //announce
                        tv_result_log.append("\nEnemy Crit Damage Occurred: " + EnemyDmg);
                    } else //normal dmg
                    {
                        EnemyDmg = Enemy1.getNormalDamage();
                        tv_result_log.append("\nEnemy Damage Occurred: " + EnemyDmg);
                    }


                    if (EnemyDmg <= MainCharacter.getArmor()) {
                        EnemyDmg = 0;
                        tv_result_log.append("\nPlayer Dodged...");
                    } else {
                        EnemyDmg = EnemyDmg - MainCharacter.getArmor();
                    }


                    MainCharacter.setHitPoint(MainCharacter.getHitPoint() - EnemyDmg);
                } else //miss attack
                {
                    //announce miss
                    tv_result_log.append("\nEnemy Damage missed");
                }


                if (MainCharacter.getHitPoint() <= 5) {
                    tv_result_log.append("\nPlayer is Bleeding to Death... ouch");
                }

                if (Enemy1.getHitPoint() <= 5) {
                    tv_result_log.append("\nEnemy is getting weaker...");
                }

                //check hp
                if (MainCharacter.getHitPoint() <= 0 || Enemy1.getHitPoint() <= 0) {
                    if (MainCharacter.getHitPoint() <= 0) {
                        Toast.makeText(this, "\nYou Are Fucked UP bitch... Lol", Toast.LENGTH_SHORT).show();
                    } else if (Enemy1.getHitPoint() <= 0) {
                        Toast.makeText(this, "\nEnemy Died....", Toast.LENGTH_SHORT).show();
                        btn_loot.setEnabled(true);
                    }
                    btnAttack.setEnabled(false);
                }


                tv_result_log.append("\n\nPlayer Stats");
                tv_result_log.append("\nHp: " + MainCharacter.getHitPoint());

                tv_result_log.append("\n\nEnemy Stats");
                tv_result_log.append("\nHp: " + Enemy1.getHitPoint());

                break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void lootAction(View view) throws JSONException {
        int id = view.getId();

        switch (id)
        {
            case R.id.btn_loot:
                int dropChance = WeaponDropChance.nextInt(100) + 1;
                LootTableMethod(dropChance);
                ll_loot_result.setVisibility(View.VISIBLE);

                String WeaponName = JsonObjLoot.getString("WeaponName");
                int WeaponDamage = JsonObjLoot.getInt("WeaponDamage");
                int WeaponCritChance = JsonObjLoot.getInt("WeaponCritChance");
                String WeaponType = JsonObjLoot.getString("WeaponType");
                int WeaponRange = JsonObjLoot.getInt("WeaponRange");
                int DropChance = JsonObjLoot.getInt("DropChance");

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("\nWeaponName: ").append(WeaponName);
                stringBuilder.append("\nWeaponDamage: ").append(WeaponDamage);
                stringBuilder.append("\nWeaponCritChance: ").append(WeaponCritChance);
                stringBuilder.append("\nWeaponType: ").append(WeaponType);
                stringBuilder.append("\nWeaponRange: ").append(WeaponRange);
                stringBuilder.append("\nDropChance: ").append(DropChance);
                stringBuilder.append("\nPlayer Rolled: ").append(dropChance);

                tv_loot_result.setText(stringBuilder.toString());

                btn_loot.setEnabled(false);
                break;

            case R.id.ll_loot_result:
                ll_loot_result.setVisibility(View.GONE);
                break;

        }
    }

    private void LootTableMethod(int dropChance) {
        if (dropChance >= 0 && dropChance <= 50) {
            LoadJSONWeapon(0);
        } else if (dropChance > 50 && dropChance <= 65) {
            LoadJSONWeapon(1);
        } else if (dropChance > 65 && dropChance <= 75) {
            LoadJSONWeapon(2);
        } else if (dropChance > 75 && dropChance <= 90) {
            LoadJSONWeapon(3);
        } else if (dropChance > 90 && dropChance <= 100) {
            LoadJSONWeapon(4);
        }
    }

}