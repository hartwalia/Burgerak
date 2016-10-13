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
        stall.setDistance("1 km");
        stall.setName("N");
        stall.setStatus("Open");

        Stall stall2 = new Stall();
        stall2.setDistance("1 km");
        stall2.setName("M");
        stall2.setStatus("Open");

        tempList.add(stall);
        tempList.add(stall2);

        return tempList;
    }
}
