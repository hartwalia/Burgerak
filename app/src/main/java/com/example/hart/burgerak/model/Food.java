package com.example.hart.burgerak.model;

import java.util.ArrayList;

/**
 * Created by 3SHEN on 1/10/2016.
 */

public class Food {
    private String mName;
    private ArrayList<String> mMeatType;
    private float price;

    public ArrayList<String> getMeatType() {
        return mMeatType;
    }

    public void setMeatType(ArrayList<String> meatType) {
        mMeatType = meatType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
