package com.aryan.g.nik.dd_final;

public class EnvironmentClass extends MainClass{
    private int HealthBuff;
    private int HealthDeBuff;

    private int DamageBuff;
    private int DamageDeBuff;

    private int ArmorBuff;
    private int ArmorDeBuff;

    private String AreaCode;

    private String CharacterCode;

    public EnvironmentClass(String characterCode,String areaCode,
                            int healthBuff,int healthDeBuff,int damageBuff,
                            int damageDeBuff,int armorBuff,int armorDeBuff)
    {

    }

    public int getHealthBuff() {
        return HealthBuff;
    }

    public void setHealthBuff(int healthBuff) {
        HealthBuff = healthBuff;
    }

    public int getHealthDeBuff() {
        return HealthDeBuff;
    }

    public void setHealthDeBuff(int healthDeBuff) {
        HealthDeBuff = healthDeBuff;
    }

    public int getDamageBuff() {
        return DamageBuff;
    }

    public void setDamageBuff(int damageBuff) {
        DamageBuff = damageBuff;
    }

    public int getDamageDeBuff() {
        return DamageDeBuff;
    }

    public void setDamageDeBuff(int damageDeBuff) {
        DamageDeBuff = damageDeBuff;
    }

    public int getArmorBuff() {
        return ArmorBuff;
    }

    public void setArmorBuff(int armorBuff) {
        ArmorBuff = armorBuff;
    }

    public int getArmorDeBuff() {
        return ArmorDeBuff;
    }

    public void setArmorDeBuff(int armorDeBuff) {
        ArmorDeBuff = armorDeBuff;
    }

    public String getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(String areaCode) {
        AreaCode = areaCode;
    }

    public String getCharacterCode() {
        return CharacterCode;
    }

    public void setCharacterCode(String characterCode) {
        CharacterCode = characterCode;
    }
}
