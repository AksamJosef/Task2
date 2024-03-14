package org.hiberexample.dao;

import org.hiberexample.config.DBHibernateConfig;
import org.hiberexample.model.Plane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PlaneDaoImplHibernate implements PlaneDao {
    @Override
    public void createTable() {

        String sql = """
                CREATE TABLE IF NOT EXISTS plane (
                id BIGSERIAL PRIMARY KEY,
                name VARCHAR (40),
                max_speed INTEGER,
                country_code VARCHAR (2)
                )
                """;

        try(SessionFactory sessionFactory = DBHibernateConfig.getSession()) {
            Session session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            tx.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropTable() {
        String sql = """
                DROP TABLE IF EXISTS plane;
                """;

        try(SessionFactory sessionFactory = DBHibernateConfig.getSession()) {
            Session session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            tx.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void savePlane(Plane plane) {
        System.out.println("Подготовлен запрос на сохранение сущности Plane: \n" + plane.toString());

        try (SessionFactory sessionFactory = DBHibernateConfig.getSession()) {
            Session session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            session.save(plane);
            tx.commit();

            System.out.println("Успешно сохранена сущность Plane! \n" );

            session.close();
        } catch (Exception e) {
            System.out.println("ОШИБКА!!!!!!!!!!!!!!");
            e.printStackTrace();
        }
    }

    @Override
    public void deletePlaneById(Long id) {
        String hql = """
                DELETE FROM Plane p
                WHERE p.id  = :id
                """;

        SessionFactory sessionFactory = DBHibernateConfig.getSession();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);

        query.executeUpdate();

        if (false) {
            tx.commit();
            System.out.println("COMMIT");
        } else {
            System.out.println("ROLLBACK");
            tx.rollback();
        }
        session.close();

        System.out.println("Успешно удалена сущность Plane с id = " + id);
    }

    @Override
    public List<Plane> getAll() {
        String hql = "FROM Plane";

        SessionFactory sessionFactory = DBHibernateConfig.getSession();
        Session session = sessionFactory.openSession();

//        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(hql);
        List<Plane> resultList = query.getResultList();

//        tx.commit();
        session.close();

        return resultList;
    }
}
