package org.dblesson.dao;

import org.dblesson.config.DatabaseConfig;
import org.dblesson.entity.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CatDaoHibernateImpl implements CatDao {
    @Override
    public void createTable() {
        System.out.println("Подготовлен запрос на создание таблицы");

        String sql = """
                CREATE TABLE IF NOT EXISTS cat (
                id BIGSERIAL PRIMARY KEY,
                color VARCHAR (40),
                name VARCHAR (40),
                owner VARCHAR (40), 
                age INTEGER
                )
                """;

        try (SessionFactory sessionFactory = DatabaseConfig.getSessionFactory()) {
            Session session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            tx.commit();

            session.close();

            System.out.println("Таблица успешно создана");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void dropTable() {
        String sql = """
                DROP TABLE IF EXISTS cat 
                """;

        try (SessionFactory sessionFactory = DatabaseConfig.getSessionFactory()) {
            Session session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            tx.commit();

            session.close();

            System.out.println("Таблица успешно удалена");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Cat cat) {
        try (SessionFactory sessionFactory = DatabaseConfig.getSessionFactory()) {
            Session session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();

            session.save(cat);

            tx.commit();
            session.close();

            System.out.println("Таблица успешно удалена");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        String hql = """
                DELETE FROM Cat
                WHERE id = :id
                """;

        SessionFactory sessionFactory = DatabaseConfig.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        try {
            Query query = session.createQuery(hql);
            query.setParameter("id", id);

            query.executeUpdate();

            if (true) {
                throw new RuntimeException();
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();

            e.printStackTrace();
        }

        session.close();
    }

    @Override
    public List<Cat> getAll() {
        String hql = "FROM Cat"; // SELECT * FROM cat

        SessionFactory sessionFactory = DatabaseConfig.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        Query query = session.createQuery(hql);

        List resultList = query.getResultList();

        tx.commit();

        session.close();

        return resultList;
    }
}
