package org.example;

import org.example.configs.DBConfig;
import org.example.dao.CarDao;
import org.example.entity.Car;
import org.example.entity.Plane;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(DBConfig.class);

        CarDao bean = applicationContext.getBean(CarDao.class);

        Car car = Car.builder()
                .cost(1)
                .color("RED")
                .model("Nissan")
                .build();

        car.setPlane(Plane.builder()
                .name("SU777")
                .countryCode("RU")
                .build());

        bean.addCar(car);

    }
}
