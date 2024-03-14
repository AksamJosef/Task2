package org.dblesson.dao;

import org.dblesson.config.DatabaseConfig;
import org.dblesson.entity.Cat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CatDaoJDBCImpl implements CatDao {

    @Override
    public void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS cat (
                id BIGSERIAL PRIMARY KEY,
                color VARCHAR (40),
                name VARCHAR (40),
                owner VARCHAR (40), 
                age INTEGER
                )
                """;
        Connection connection = DatabaseConfig.getConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropTable() {
        String sql = """
                DROP TABLE IF EXISTS cat
                """;
        Connection connection = DatabaseConfig.getConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(org.dblesson.entity.Cat cat) {
        String sql = """
                INSERT INTO cat(color, name, owner, age) 
                VALUES(?, ?, ?, ?)
                """;
        Connection connection = DatabaseConfig.getConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cat.getColor());
            preparedStatement.setString(2, cat.getName());
            preparedStatement.setString(3, cat.getOwner());
            preparedStatement.setInt(4, cat.getAge());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        String sql = String.format("DELETE FROM cat WHERE id = %d", id);

        Connection connection = DatabaseConfig.getConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<org.dblesson.entity.Cat> getAll() {
        String sql = """
                SELECT * FROM cat
                """;
        Connection connection = DatabaseConfig.getConnection();

        List<Cat> cats = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Cat cat = new Cat();
                cat.setId(resultSet.getLong("id"));
                cat.setColor(resultSet.getString("color"));
                cat.setName(resultSet.getString("name"));
                cat.setOwner(resultSet.getString("owner"));
                cat.setAge(resultSet.getInt("age"));

                cats.add(cat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cats;
    }
}
