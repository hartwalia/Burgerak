package com.example.hart.burgerak.controller;

import com.example.hart.burgerak.model.Stall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rashi on 1/10/2016.
 */

public class ListPopulator {

    public static List<Stall> LoadStall(){
        List<Stall> tempList = new ArrayList<>();

        Stall stall = new Stall();
        stall.setName("Zally's Burger Stand");
        stall.setStatus("Open");

        Stall stall2 = new Stall();
        stall2.setName("Burger Bakar Kaw");
        stall2.setStatus("Open");

        Stall stall3 = new Stall();
        stall3.setName("Sausage Bakar Kaw Kaw");
        stall3.setStatus("Open");

        tempList.add(stall);
        tempList.add(stall2);
        tempList.add(stall3);

        return tempList;
    }
}
