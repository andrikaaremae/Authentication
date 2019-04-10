package FOBauthentication.service;

import FOBauthentication.model.Role;
import FOBauthentication.model.User;
import FOBauthentication.repository.UserRepository;
import FOBauthentication.exception.CustomException;
import FOBauthentication.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String login(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
        } catch (AuthenticationException e) {
            throw new CustomException("Username or password is wrong.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singletonList(Role.ROLE_CLIENT));
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
