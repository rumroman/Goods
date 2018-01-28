/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.romanrum45.Goods;

import java.util.Comparator;

/**
 *
 * @author Rum
 */
public class GoodsCostAscendingComparator implements Comparator<Goods> {

    @Override
    public int compare(Goods goodsA, Goods goodsB) {
        return goodsA.getCost() - goodsB.getCost();
    }
    
}
