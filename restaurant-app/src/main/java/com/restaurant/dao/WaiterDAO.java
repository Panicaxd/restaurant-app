package com.restaurant.dao;

import com.restaurant.config.DatabaseConfig;
import com.restaurant.model.Waiter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WaiterDAO {
    public void addWaiter(Waiter waiter) throws SQLException {
        String sql = "INSERT INTO waiters (name, day, daily_profit, table_number) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, waiter.getName());
            statement.setString(2, waiter.getDay());
            statement.setDouble(3, waiter.getDailyProfit());
            statement.setInt(4, waiter.getTableNumber());
            statement.executeUpdate();
        }
    }

    public List<Waiter> getAllWaiters() throws SQLException {
        List<Waiter> waiters = new ArrayList<>();
        String sql = "SELECT * FROM waiters";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Waiter waiter = new Waiter(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("day"),
                        resultSet.getDouble("daily_profit"),
                        resultSet.getInt("table_number")
                );
                waiters.add(waiter);
            }
        }
        return waiters;
    }

    public void deleteWaiter(int id) throws SQLException {
        String sql = "DELETE FROM waiters WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public void updateWaiter(Waiter waiter) throws SQLException {
        String sql = "UPDATE waiters SET name = ?, day = ?, daily_profit = ?, table_number = ? WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, waiter.getName());
            statement.setString(2, waiter.getDay());
            statement.setDouble(3, waiter.getDailyProfit());
            statement.setInt(4, waiter.getTableNumber());
            statement.setInt(5, waiter.getId());
            statement.executeUpdate();
        }
    }
}
