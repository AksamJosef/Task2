package org.example;

import org.example.streams.function.Mapper;
import org.example.streams.impl.MapperImpl;
import org.example.streams.model.User;
import org.example.streams.model.UserDto;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        User user = User.builder()
                .username("username")
                .name("name")
                .lastName("lastName")
                .build();

        Mapper<User, UserDto> mapper = new Mapper<>() {
            @Override
            public UserDto map(User user) {
                return UserDto.builder()
                        .name(user.getName())
                        .lastName(user.getLastName())
                        .username(user.getUsername())
                        .build();
            }
        };

        user.setName("Nigmat");

        Mapper<User, UserDto> lambdaMapper = u -> UserDto.builder()
                .name(u.getName())
                .lastName(u.getLastName())
                .username(u.getUsername())
                .build();

        UserDto dto = mapper.map(user);

        System.out.println(dto.getClass().equals(UserDto.class));

        System.out.println(dto);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        UserDto lambdaDto = lambdaMapper.map(user);

        System.out.println(lambdaDto.getClass().equals(UserDto.class));

        System.out.println("LAMBDA::: " + lambdaDto);


        Predicate<User> userPredicate = u -> u.getName().equals("Nigmat") && u.getLastName().equals("Nigmatullin");

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Predicate :::: " + userPredicate.test(user));


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        Consumer<User> userConsumer = u -> doSth(u);

        System.out.println("CONSUMER :::::: ");
        userConsumer.accept(user);


        Supplier<User> userSupplier = () -> User.builder()
                .name("N")
                .lastName("L")
                .username("LN")
                .build();

        User newUser = userSupplier.get();

        userConsumer.accept(newUser);



        float a = 0.7F;
        float b = 0.1F;

//        0.7 + 0.1 != 0.8;

//        0.800000000000000000000001

        BigDecimal bigDecimalA = BigDecimal.valueOf(0.7);
        BigDecimal bigDecimalB = BigDecimal.valueOf(0.1);

        System.out.println(a + b == 0.8);
        System.out.println(bigDecimalA.add(bigDecimalB).doubleValue() == 0.8);

//         BigDecimal -> NUMERIC (10, 2)
    }



    private static void doSth(User user) {
        System.out.println("THIS IS MY FAVOURITE USER!!!!");
        System.out.println(user);
    }
}
