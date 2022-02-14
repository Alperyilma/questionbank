package mathbank.questionbank.api.controllers;

import mathbank.questionbank.business.abstracts.UserService;
import mathbank.questionbank.core.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User add(User user){
        return this.userService.add(user);
    }

    @PostMapping("/delete")
    public void delete(User user) {
        this.userService.delete(user);
    }

    @GetMapping("/getall")
    public List<User> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/findByEmail")
    public User findByEmail(String email){
        return this.userService.findByEmail(email);
    }
}
