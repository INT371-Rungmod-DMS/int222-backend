package int222.project.Dora.Repositories;

import int222.project.Dora.Models.favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<favorite, Long> {
}
