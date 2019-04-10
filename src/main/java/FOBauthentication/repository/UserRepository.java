package FOBauthentication.repository;

import FOBauthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByUsername(String username);

    User findByUsername(String username);

    List<User> findAll();
}
