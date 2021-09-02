package int222.project.Dora.Controllers;

import int222.project.Dora.Models.product;
import int222.project.Dora.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/show")
    public List<product> allProduct(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "50") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<product> pageResult = productRepository.findAll(pageable);
        return pageResult.getContent();
    }

    @GetMapping("/show/{id}")
    public product addProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

}