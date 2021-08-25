package int222.project.Dora.Repositories;

import int222.project.Dora.Models.favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<favorite, Long> {
    List<favorite> findAllByUserId(Long userId);
}
