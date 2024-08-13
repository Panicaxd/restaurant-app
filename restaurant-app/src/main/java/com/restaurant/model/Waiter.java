package com.restaurant.model;

public class Waiter {
    private int id;
    private String name;
    private String day;
    private double dailyProfit;
    private int tableNumber;

    public Waiter(int id, String name, String day, double dailyProfit, int tableNumber) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.dailyProfit = dailyProfit;
        this.tableNumber = tableNumber;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public double getDailyProfit() {
        return dailyProfit;
    }

    public void setDailyProfit(double dailyProfit) {
        this.dailyProfit = dailyProfit;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}