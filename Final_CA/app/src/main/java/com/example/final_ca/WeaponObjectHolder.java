package com.example.final_ca;

public class WeaponObjectHolder {
    private String name;
    private String type; //possible enum
    private String description;
    private String dmg;

    public WeaponObjectHolder(String name, String type, String description, String dmg) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.dmg = dmg;
    }

    public WeaponObjectHolder() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDmg() {
        return dmg;
    }

    public void setDmg(String dmg) {
        this.dmg = dmg;
    }
}
