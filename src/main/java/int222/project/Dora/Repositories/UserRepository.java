package int222.project.Dora.Repositories;

import int222.project.Dora.Models.user;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <user, Long> {
    List<user> findByUserNameAndAndPassword(String username, String pwd);
}
