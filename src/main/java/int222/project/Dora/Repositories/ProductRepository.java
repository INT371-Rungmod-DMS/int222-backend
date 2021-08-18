package int222.project.Dora.Repositories;

import int222.project.Dora.Models.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<product, Long> {
}
