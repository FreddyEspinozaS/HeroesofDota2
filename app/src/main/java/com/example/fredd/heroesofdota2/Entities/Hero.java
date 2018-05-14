package com.example.fredd.heroesofdota2.Entities;

import java.util.ArrayList;

public class Hero {

    public Hero(int idHero, String name, String localized_name, String primary_attr, String attack_type, ArrayList<String> roles, int legs) {
        this.idHero = idHero;
        this.name = name;
        this.localized_name = localized_name;
        this.primary_attr = primary_attr;
        this.attack_type = attack_type;
        this.roles = roles;
        this.legs = legs;
    }

    public int getIdHero() {
        return idHero;
    }

    public void setIdHero(int idHero) {
        this.idHero = idHero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalized_name() {
        return localized_name;
    }

    public void setLocalized_name(String localized_name) {
        this.localized_name = localized_name;
    }

    public String getPrimary_attr() {
        return primary_attr;
    }

    public void setPrimary_attr(String primary_attr) {
        this.primary_attr = primary_attr;
    }

    public String getAttack_type() {
        return attack_type;
    }

    public void setAttack_type(String attack_type) {
        this.attack_type = attack_type;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    private int idHero;
    private String name;
    private String localized_name;
    private String primary_attr;
    private String attack_type;
    private ArrayList<String> roles;
    private int legs;


}
