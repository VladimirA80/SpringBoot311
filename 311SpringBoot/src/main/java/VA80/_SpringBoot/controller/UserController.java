package VA80._SpringBoot.controller;

import VA80._SpringBoot.model.User;
import VA80._SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired  // Внедрение зависимости через конструктор
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsersList(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "newuser";
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/"; // Перенаправление на список пользователей
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        try {
            userService.deleteUser(id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("User not found " + e);
        }
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUser(Model model, @RequestParam("id") Long id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("id") Long id, @ModelAttribute("user") User user) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

}
