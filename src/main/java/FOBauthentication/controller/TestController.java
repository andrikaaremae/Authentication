package FOBauthentication.controller;

import FOBauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String getHello() {
        return "Authentication Application for FOB Solutions";
    }
}