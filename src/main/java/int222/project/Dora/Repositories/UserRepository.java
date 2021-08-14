package int222.project.Dora.Repositories;

import int222.project.Dora.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
