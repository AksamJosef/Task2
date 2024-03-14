package org.jdbcexample.dao;

import org.jdbcexample.config.DBConfig;
import org.jdbcexample.model.Cat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDaoJDBCImpl implements CarDao {

    @Override
    public void createTable() {
        Connection connection = DBConfig.getConnection();

        String sql = """
                CREATE TABLE IF NOT EXISTS car (
                id BIGSERIAL PRIMARY KEY,
                color VARCHAR (40),
                cost INTEGER,
                model VARCHAR (100)
                )
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void dropTable() {
        Connection connection = DBConfig.getConnection();

        String sql = """
                DROP TABLE IF EXISTS car;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void saveCar(Cat car) {
        Connection connection = DBConfig.getConnection();
        String sql = """
        INSERT INTO car(color, cost, model) 
        VALUES(?, ?, ?)
        """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, car.getColor());
            preparedStatement.setInt(2, car.getCost().intValue());
            preparedStatement.setString(3, car.getModel());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCarById(Long id) {
        System.out.println("Производится удаление сущности с id = " + id);
        Connection connection = DBConfig.getConnection();
        String sql = String.format("DELETE FROM car WHERE id = %d", id);

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cat> getAllCars() {
        Connection connection = DBConfig.getConnection();
        List<Cat> userList = new ArrayList<>();
        String sql = "SELECT * FROM car";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Cat user = new Cat();
                user.setId(resultSet.getLong("id"));
                user.setColor(resultSet.getString("color"));
                user.setCost(resultSet.getLong("cost"));
                user.setModel(resultSet.getString("model"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
