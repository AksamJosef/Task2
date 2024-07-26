package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String helloWorld(Model model) {
//        model.addAttribute("firstAttribute");
//        model.addAttribute("secondAttribute");
//        model.addAttribute("thirdAttribute");
//
//        List<String> numList = List.of("1", "2", "3");

//        model.addAttribute("numList", numList);

        User user = User.builder()
                .firstName("Nigmat")
                .lastName("Nigmat")
                .age("146")
                .build();

        List<User> list = userService.add(user);

        model.addAttribute("users", list);
        return "test";
    }

}
