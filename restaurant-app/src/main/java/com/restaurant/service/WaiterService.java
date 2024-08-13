package com.restaurant.service;

import com.restaurant.dao.WaiterDAO;
import com.restaurant.model.Waiter;

import java.sql.SQLException;
import java.util.List;

public class WaiterService {
    private WaiterDAO waiterDAO = new WaiterDAO();

    public void addWaiter(Waiter waiter) {
        try {
            waiterDAO.addWaiter(waiter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Waiter> getAllWaiters() {
        try {
            return waiterDAO.getAllWaiters();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteWaiter(int id) {
        try {
            waiterDAO.deleteWaiter(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateWaiter(int id, String name, String day, double dailyProfit, int tableNumber) {
        Waiter waiter = new Waiter(id, name, day, dailyProfit, tableNumber);
        try {
            waiterDAO.updateWaiter(waiter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}