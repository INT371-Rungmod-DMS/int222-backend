package int222.project.Dora.Controllers;

import int222.project.Dora.Models.product;
import int222.project.Dora.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/show")
    public List<product> allProduct() {
        List<product> allproduct = productRepository.findAll();
        return allproduct;
    }

    @GetMapping("/show/{id}")
    public product showProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

}
