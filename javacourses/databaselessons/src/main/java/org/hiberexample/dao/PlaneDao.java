package org.hiberexample.dao;

import org.hiberexample.model.Plane;

import java.util.List;

public interface PlaneDao {

    void createTable();

    void dropTable();

    void savePlane(Plane plane);

    void deletePlaneById(Long id);

    List<Plane> getAll();

}
