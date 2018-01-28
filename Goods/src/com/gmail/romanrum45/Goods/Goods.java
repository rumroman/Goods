/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.romanrum45.Goods;

/**
 *
 * @author Rum
 */
public class Goods {
    
    private String category;
    private String name;
    private String dateRegistration;    // Дата оформления товара
    private int cost;               // Стоимость за единицу 
    private int quantity;           // Количество 
    private String consignmentNumber;  //Номер накладной
    
    public Goods(String category,String name,String dateRegistration){
        this.name = name;
        this.category = category;
        this.dateRegistration = dateRegistration;
    }
    
    public Goods(String category,String name,String dateRegistration,int cost,int quantity,String consignmentNumber){
        this.name = name;
        this.category = category;
        this.dateRegistration = dateRegistration;
        this.cost = cost;
        this.quantity = quantity;
        this.consignmentNumber = consignmentNumber;
    }
    
    // Увеличение количества товара на 1
    public void incQuantity(){
        quantity++;
    } 
    // Уменьшение количества товара на 1
    public void decQuantity(){
        quantity--;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public String getCategory(){
        return category;
    }
    
    public void setDateRegistration(String dateRegistration){
        this.dateRegistration = dateRegistration;
    }
    
    public String getDateRegistration(){
        return dateRegistration;
    }  
    
    // Изменения цены товара
    public void setCost(int cost){
        this.cost = cost;
    }
    
    public int getCost(){
        return cost;
    }
    
    // Изменения количества товара
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }    
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setConsignmentNumber(String consignmentNumber){
        this.consignmentNumber = consignmentNumber;
    }
    
    public String getConsignmentNumber(){
        return consignmentNumber;
    }
    
    // Рассчитать стоимость товаров
    public int calculateSum(){
        return cost * quantity; 
    }
    
    @Override
    public String toString(){        
        return String.valueOf(calculateSum());
    }
    
    public Object[] getValuesGood(){
        Object[] arrValues = new Object[] {category,name,dateRegistration,cost,quantity,consignmentNumber};
        return arrValues;
    }

    
    
    
}
