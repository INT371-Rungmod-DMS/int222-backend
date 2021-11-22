package int222.project.Dora.Controllers;

import int222.project.Dora.Models.productColor;
import int222.project.Dora.Repositories.ProductColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://172.19.0.1")
@RestController
public class ProductColorController {
    @Autowired
    ProductColorRepository productColorRepository;

    @GetMapping("/showproductcolor")
    public List<productColor> allProductcolor() {
        List<productColor> productColors = productColorRepository.findAll();
        return productColors;
    }
}
