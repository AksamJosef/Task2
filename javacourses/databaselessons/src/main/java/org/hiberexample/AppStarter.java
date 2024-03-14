package org.hiberexample;

import org.hiberexample.dao.PlaneDao;
import org.hiberexample.dao.PlaneDaoImplHibernate;
import org.hiberexample.enums.CountryCode;
import org.hiberexample.model.Plane;

import java.util.List;

public class AppStarter {
    public static void main(String[] args) {
        PlaneDao planeDao = new PlaneDaoImplHibernate();

        planeDao.createTable();

        Plane plane = Plane.builder()
                .name("Boeing 777")
                .countryCode(CountryCode.US)
                .maxSpeed(777)
                .build();

        planeDao.savePlane(plane);

        List<Plane> planes = planeDao.getAll();

        planes.forEach(System.out::println);

        Long idForRemoval = planes.stream().findAny().map(Plane::getId).orElseThrow();

        planeDao.deletePlaneById(idForRemoval);

//        planeDao.dropTable();
    }
}
