package com.aryan.g.nik.dd_final.AllCharacter;

import com.aryan.g.nik.dd_final.MainClass;

public class PersonClass extends MainClass
{
    //TODO Character Basic Info
    private String Name;
    private int HitPoint;
    private int Level;
    private int HitRating;
    private int Xp;
    private int NormalDamage;
    private int CritChanceRating;
    private int Armor;

    private WeaponClass weaponClass;

    //TODO Character Abilities Variables
    private String CharacterAbility_1_Name;
    private String CharacterAbility_2_Name;
    private String CharacterAbility_3_Name;
    private int CharacterAbility_1_CoolDown;
    private int CharacterAbility_2_CoolDown;
    private int CharacterAbility_3_CoolDown;

    //TODO Character Potion & Elixir Variables
    private boolean CharacterPotionSlot_1;
    private boolean CharacterPotionSlot_2;
    private boolean CharacterPotionSlot_3;
    private String CharacterPotionName_1;
    private String CharacterPotionName_2;
    private String CharacterPotionName_3;

    private boolean CharacterElixirSlot_1;
    private boolean CharacterElixirSlot_2;
    private boolean CharacterElixirSlot_3;
    private String CharacterElixirName_1;
    private String CharacterElixirName_2;
    private String CharacterElixirName_3;

    //TODO Character Weapon Variables
    private boolean IsCharacterDualWield;
    private boolean IsCharacterWeaponEquipped;


    //Default Constructor
    public PersonClass()
    {

    }

    //Test Constructor Character
    public PersonClass(String name, int HitPoint, int Level,
                       int HitRating, int Xp, int NormalDamage, int CritChanceRating, int Armor)
    {
        this.Name = name;
        this.HitPoint = HitPoint;
        this.Level = Level;
        this.HitRating = HitRating;
        this.Xp = Xp;
        this.NormalDamage = NormalDamage;
        this.CritChanceRating = CritChanceRating;
        this.Armor = Armor;
    }




    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getHitPoint() {
        return HitPoint;
    }

    public void setHitPoint(int hitPoint) {
        HitPoint = hitPoint;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getHitRating() {
        return HitRating;
    }

    public void setHitRating(int hitRating) {
        HitRating = hitRating;
    }

    public int getXp() {
        return Xp;
    }

    public void setXp(int xp) {
        Xp = xp;
    }

    public int getNormalDamage() {
        return NormalDamage;
    }

    public void setNormalDamage(int normalDamage) {
        NormalDamage = normalDamage;
    }

    public int getCritChanceRating() {
        return CritChanceRating;
    }

    public void setCritChanceRating(int critChanceRating) {
        CritChanceRating = critChanceRating;
    }

    public int getArmor() {
        return Armor;
    }

    public void setArmor(int armor) {
        Armor = armor;
    }


}
