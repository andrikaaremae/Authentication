package FOBauthentication;

import FOBauthentication.model.User;
import FOBauthentication.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserRegistrationTests {

    @Autowired
    private UserService userService;

    @Test
    public void shouldReturnAllRegisteredUsers() throws Exception {
        User user1 = new User("NumberOne", "123456");
        User user2 = new User("NumberTwo", "123456");
        userService.save(user1);
        userService.save(user2);
        assertThat(userService.findAll()).hasSize(2);
    }

    @Test
    public void shouldRejectSameUsername() throws Exception {
        User user1 = new User("NumberOne", "123456");
        User user2 = new User("NumberTwo", "123456");
        userService.save(user1);
        try {
            userService.save(user2);
        } catch (Throwable e) {
            assertThat(e).isInstanceOf(DataIntegrityViolationException.class);
        }
    }

    @Test
    public void shouldHaveUsernameLongerThan4Chars() throws Exception {
        User user1 = new User("abc", "123456");
        try {
            userService.save(user1);
        } catch (Throwable e) {
            assertThat(e).isInstanceOf(ConstraintViolationException.class);
        }
    }
}
