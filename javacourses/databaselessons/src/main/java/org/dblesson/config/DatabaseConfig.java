package org.dblesson.config;

import org.dblesson.entity.Cat;
import org.hiberexample.model.Plane;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String DB_DRIVER = "org.postgresql.Driver";

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String DB_USERNAME = "postgres";

    private static final String DB_PASSWORD = "postgres";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        return new Configuration()
                .setProperty("hibernate.connection.url", DB_URL)
                .setProperty("hibernate.connection.driver_class", DB_DRIVER)
                .setProperty("hibernate.connection.username", DB_USERNAME)
                .setProperty("hibernate.connection.password", DB_PASSWORD)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                .setProperty("hibernate.show_sql", "true")
                .addAnnotatedClass(Cat.class)
                .buildSessionFactory();
    }
}
