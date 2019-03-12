package com.example.kaspe.pokedex;

public class Pokemon {
    private String mName;
    private int mIconId;

    Pokemon(String name, int iconId) {
        mName = name;
        mIconId = iconId;
    }

    public String getName() {
        return mName;
    }

    public int getIconId() {
        return mIconId;
    }
}