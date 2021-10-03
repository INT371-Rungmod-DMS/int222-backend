package int222.project.Dora.Repositories;

import int222.project.Dora.Models.productColor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductColorRepository extends JpaRepository<productColor, Long> {
    productColor[] deleteAllByProductId (Long id);
    productColor[] findAllByProductId (Long id);
    productColor findByProductId (Long id);
}
