package org.example;

import org.example.configs.DBConfig;
import org.example.entity.Motor;
import org.example.entity.Screwdriver;
import org.example.enums.Characteristic;
import org.example.enums.Country;
import org.example.service.ScrewdriverService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);

        ScrewdriverService service = context.getBean(ScrewdriverService.class);

        Screwdriver dewalt791 = Screwdriver.builder()
                .model("DeWALT DCD791")
                .rpm(2000)
                .country(Country.CHINA)
                .characteristic(Characteristic.BRUSHLESS)
                .build();

        Screwdriver dewalt701 = Screwdriver.builder()
                .model("DeWALT DCD701")
                .rpm(1200)
                .country(Country.CZECH)
                .characteristic(Characteristic.BRUSH)
                .build();

        Screwdriver makitaM20T = Screwdriver.builder()
                .model("Makita M20T")
                .rpm(1500)
                .country(Country.RUSSIA)
                .characteristic(Characteristic.BRUSHLESS)
                .motor(Motor.builder()
                        .country(Country.CZECH)
                        .isGood(true)
                        .build())
                .build();

        Screwdriver milwaukee = Screwdriver.builder()
                .model("Milwaukee")
                .rpm(2100)
                .country(Country.USA)
                .characteristic(Characteristic.BRUSHLESS)
                .motor(Motor.builder()
                        .country(Country.RUSSIA)
                        .isGood(true)
                        .build())
                .build();

//        service.add(dewalt791);
//        service.add(dewalt701);
        service.add(makitaM20T);
        service.add(milwaukee);

//        Optional<Screwdriver> optionalScrewdriver = service.findById(UUID.fromString("4020065a-b3ed-432e-97e5-1b3d04c07bea"));

//        optionalScrewdriver.ifPresent(System.out::println);

//        service.delete(UUID.fromString("f7364edb-fae8-4c55-8915-e33a3cd89de9"));

//        System.out.println(service.findQuantityByCountry(Country.CHINA));

//        service.findAll().stream().forEach(System.out::println);

//        service.update(UUID.fromString("dd159b79-3968-41c9-b7c0-945204a6cf5f"));

    }
}
