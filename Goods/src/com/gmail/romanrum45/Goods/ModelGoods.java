/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.romanrum45.Goods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.*;

/**
 *
 * @author Rum
 */
public class ModelGoods {

    private ArrayList<Goods> arListGoods;
    private int sizeGoods;
    private boolean stateSortByCost;
    private int tableSelectedRow;
    public final static String[] COLUMNS = new String[]{"Категория", "Название", "Дата оформления",
        "Цена за 1 ед.", "Количество", "Номер накладной"};

    public ModelGoods() {
        arListGoods = new ArrayList();
        stateSortByCost = false;
        tableSelectedRow = -1;
    }

    // Создать продукт
    public void createGoods(String category, String name, String dateRegistration, int cost, int quantity, String consignmentNumber) {
        Goods goods = new Goods(category, name, dateRegistration, cost, quantity, consignmentNumber);
        arListGoods.add(goods);
        sizeGoods++;
    }

    //Удалить продукт
    public void removeGoods() {

    }

    // Вернуть массив товаров
    public Goods[] getGoods() {
        Goods[] array = new Goods[sizeGoods];
        return arListGoods.toArray(array);
    }

    // Сортировка по цене  
    public void sortByCost() {
        if (stateSortByCost == false) {
            sortByCostAscending();
            stateSortByCost = true;
            return;
        } else {
            sortByCostDescending();
            stateSortByCost = false;
            return;
        }

    }

    // Сортировка по цене по возрастанию
    private void sortByCostAscending() {
        GoodsCostAscendingComparator costComparator = new GoodsCostAscendingComparator();
        Collections.sort(arListGoods, costComparator);
        //return getGoods();

    }

    // Сортировка по цене по убыванию
    private void sortByCostDescending() {
        GoodsCostDescendingComparator costComparator = new GoodsCostDescendingComparator();
        Collections.sort(arListGoods, costComparator);
    }

    // Поиск по номеру накладной
    public Goods searchByConsignmentNumber(String consignmentNumber) {
        Goods foundGood = null;
        for (Goods good : arListGoods) {
            if (good.getConsignmentNumber().equals(consignmentNumber)) {
                foundGood = good;
                break;
            }
        }
        return foundGood;
    }

    // Поиск по категории
    public Goods searchByCategory(String category) {
        Goods foundGood = null;
        for (Goods good : arListGoods) {
            if (good.getCategory().equals(category)) {
                foundGood = good;
                break;
            }
        }
        return foundGood;
    }

    public void setTableSelectedRow(int tableSelectedRow) {
        this.tableSelectedRow = tableSelectedRow;
    }

    public int getTableSelectedRow() {
        return tableSelectedRow;
    }

    public static boolean isNumeric(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void saveInFileTxt(File file) {
        String path = file.getPath();
        if(!path.endsWith(".txt"))
            path = path + ".txt";
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path))) {
            Object[] goods = getGoods()[getTableSelectedRow()].getValuesGood();
            fileWriter.write(new Date().toString() + "\r\n");
            for (int i = 0; i < goods.length; i++) {
                fileWriter.write(COLUMNS[i] + " - " + goods[i].toString() + "\r\n");
            }

        } catch (InvalidPathException e) {
            System.out.println("Неверный путь файла");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }

    public String openFileTxt(File file) {
        String stateOpen;
        String category = null;
        String name = null;
        String dateRegistration = null;
        String cost = null;
        String quantity = null;
        String consignmentNumber = null;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            fileReader.readLine();
            category = fileReader.readLine();
            name = fileReader.readLine();
            dateRegistration = fileReader.readLine();
            cost = fileReader.readLine();
            quantity = fileReader.readLine();
            consignmentNumber = fileReader.readLine();
            //createGoods(category,name,dateRegistration,cost,quantity,consignmentNumber);
            try {
                category = category.substring(COLUMNS[0].length() + 3);
                name = name.substring((COLUMNS[1].length() + 3));
                dateRegistration = dateRegistration.substring((COLUMNS[2].length() + 3));
                cost = cost.substring((COLUMNS[3].length() + 3));
                quantity = quantity.substring((COLUMNS[4].length() + 3));
                consignmentNumber = consignmentNumber.substring((COLUMNS[5].length() + 3));                                
            } catch (Exception ex) {
                return stateOpen = "Неверный формат файла.";
            }            

        } catch (InvalidPathException e) {
            System.out.println("Неверный путь файла");
            return stateOpen = "Неверный путь файла.";
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
            return stateOpen = "Ошибка ввода-вывода.";
        }
        
        if(searchByConsignmentNumber(consignmentNumber) != null){
                    return stateOpen = "Товар с такой накладной уже существует.";
                }
        
        
        createGoods(category, name, dateRegistration, Integer.valueOf(cost), Integer.valueOf(quantity), consignmentNumber);
        return stateOpen = "Файл успешно загружен.";
    }

}
