package FOBauthentication.controller;

import FOBauthentication.model.User;
import FOBauthentication.service.UserService;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import FOBauthentication.security.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserCredentials userCredentials) {
        ObjectNode token = JsonNodeFactory.instance.objectNode();
        token.put("token", userService.login(userCredentials.getUsername(), userCredentials.getPassword()));
        return token.toString();
    }

    @PostMapping("/register")
    public User register(@RequestBody @Valid User user) {
        return userService.save(user);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.findAll();
    }
}
