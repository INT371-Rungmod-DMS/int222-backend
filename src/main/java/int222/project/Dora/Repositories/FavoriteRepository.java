package int222.project.Dora.Repositories;

import int222.project.Dora.Models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
