package org.dblesson.service;

import org.dblesson.dao.CatDao;
import org.dblesson.dao.CatDaoHibernateImpl;
import org.dblesson.dao.CatDaoJDBCImpl;
import org.dblesson.entity.Cat;

import java.util.List;

public class CatServiceImpl implements CatService {

//    private CatDao catDao = new CatDaoJDBCImpl();

    private CatDao catDao = new CatDaoHibernateImpl();

    @Override
    public void createTable() {
        catDao.createTable();
    }

    @Override
    public void dropTable() {
        System.out.println("Подготовлен запрос на удаление таблицы");

        catDao.dropTable();
    }

    @Override
    public void add(Cat cat) {
        catDao.add(cat);
    }

    @Override
    public void deleteById(Long id) {
        catDao.deleteById(id);
    }

    @Override
    public List<Cat> getAll() {
        return catDao.getAll();
    }
}
