package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/")
public class UserController {
    private final UserService serv;

    public UserController(UserService serv) {
        this.serv = serv;
    }
    @GetMapping("users")
    public String findAll(Model model) {
        List<User> users = serv.getAll();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/new")
    public String createUserForm(User user) {
        return "user-create";
    }
    @PostMapping("/user-create")
    public String createUser(User user) {
        serv.save(user);
        return "redirect:/users";
    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable(value="id") Long id) {
        serv.removeById(id);
        return "redirect:/users";
    }
    @GetMapping("/edit/{id}")
    public String updateUserForm(@PathVariable("id") Long id,ModelMap model) {
        model.addAttribute("person",serv.findById(id));
        return "user-update";
    }
    @PatchMapping("/user-update/{id}")
    public String updateUser(@ModelAttribute("person")User user,@PathVariable("id")Long id) {
        serv.update(id,user);
        return "redirect:/users";
    }
}
