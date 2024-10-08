package org.example.streams;

import org.example.streams.model.User;
import org.example.streams.model.UserDto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamz {

    public static void main(String[] args) {
//
//        List<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(1);
//        integers.add(1);
//        integers.add(19);
//        integers.add(44);
//        integers.add(0);
//        integers.add(0);
//        integers.add(90);
//        integers.add(90);
//        integers.add(-1);
//        integers.add(-1);
//        integers.add(-1);
//
//
//        List<Integer> list = integers.stream()
//                .sorted(Comparator.comparing(Integer::intValue).reversed())
//                .skip(2)
//                .limit(7)
////                .filter(element -> element <= 0)
//                .collect(Collectors.toList());
//
//        System.out.println(list);
//
//
        List<User> users = new ArrayList<>();
        users.add(User.builder()
                .username("username1")
                .name("name1")
                .lastName("lastName1")
                .build());

        users.add(User.builder()
                .username("username2")
                .lastName("lastName")
                .build());

        users.add(User.builder()
                .username("username3")
                .name("name3")
                .lastName("lastName3")
                .build());


        users.add(User.builder()
                .username("username4")
                .lastName("lastName4")
                .build());

        users.add(User.builder()
                .username("username5")
                .name("name5")
                .lastName("lastName5")
                .build());

        users.add(User.builder()
                .username("username6")
                .lastName("lastName6")
                .build());
//
//
//        List<User> anotherUsers = new ArrayList<>();
//        users.add(User.builder()
//                .username("username7")
//                .name("name7")
//                .lastName("lastName7")
//                .build());
//
//
//        List<List<User>> userDoubleList = new ArrayList<>();
//        userDoubleList.add(users);
//        userDoubleList.add(anotherUsers);
//
//        long count = userDoubleList.stream()
//                .flatMap(el -> el.stream())
//                .count();
//
//
//        System.out.println(count);
//
//        List<UserDto> userDtos = users.stream()
//                .filter(user -> user.getName() != null)
//                .map(user -> UserDto.builder()
//                        .name(user.getName())
//                        .lastName(user.getLastName())
//                        .username(user.getUsername())
//                        .build())
//                .collect(Collectors.toList());
//
//        System.out.println(userDtos);
//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//
//
//        List<UserDto> dtoUserList = new ArrayList<>();
//
//        for (User user : users) {
//            if (user.getName() != null) {
//                dtoUserList.add(UserDto.builder()
//                        .name(user.getName())
//                        .lastName(user.getLastName())
//                        .username(user.getUsername())
//                        .build());
//            }
//        }
//
//        System.out.println(dtoUserList);
//
//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();


//        Stream<User> userStream = users.stream()
//                .filter(user -> user.getName() != null);
//
//
//        // любой код все что угодно
//
//
//        List<User> userList = userStream.collect(Collectors.toList());
//
//        long count = userStream.count();
//
//        System.out.println(userList);
//
//        System.out.println(count);

        boolean allMatch = users.stream()
                .allMatch(user -> user.getUsername() != null);

        System.out.println(allMatch);
    }
}
