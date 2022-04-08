package mathbank.questionbank.api.controllers;

import mathbank.questionbank.business.abstracts.UserService;
import mathbank.questionbank.core.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addRegister")
    public User addRegister(@RequestBody User user){
        return this.userService.addRegister(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getLogin(@ModelAttribute(name = "loginForm") User loginForm, Model model){
        String username = loginForm.getEmail();
        String password = loginForm.getPassword();

        if ("admin".equals(username) && "admin".equals("password")){
            return "home";
        }
        model.addAttribute("invalidCredentials", true);
        return  "login";
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody User user) {
        this.userService.delete(user);
    }

    @GetMapping("/getall")
    public List<User> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/findByEmail")
    public User findByEmail(@RequestParam String email){
        return this.userService.findByEmail(email);
    }

}
