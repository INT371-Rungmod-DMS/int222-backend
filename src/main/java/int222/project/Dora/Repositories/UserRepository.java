package int222.project.Dora.Repositories;

import int222.project.Dora.Models.user;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <user, Long> {
    user findByUserName(String username);
    user findByPassword(String pwd);
    user findByUserNameAndPassword(String username, String password);
    boolean deleteByUserId(long userId);
}
