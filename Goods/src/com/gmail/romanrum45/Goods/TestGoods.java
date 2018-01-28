/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.romanrum45.Goods;

import javax.swing.JFrame;


/**
 *
 * @author Rum
 */
public class TestGoods {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ModelGoods modelGoods = new ModelGoods();
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GoodsUI goodsUI = new GoodsUI(modelGoods);
                goodsUI.setVisible(true);
                goodsUI.setLocationRelativeTo(null);                
            }
        });
        // TODO code application logic here
        
        
    }
    
}
