package int222.project.Dora.Controllers;

import int222.project.Dora.Models.brand;
import int222.project.Dora.Repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class BrandController {
    @Autowired
    BrandRepository brandRepository;

    @GetMapping("/showbrand")
    public List<brand> showBrand(@RequestParam(defaultValue = "0") Integer pageNo,
                                 @RequestParam(defaultValue = "50") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<brand> pageResult = brandRepository.findAll(pageable);
        return pageResult.getContent();
    }

    @GetMapping("/showbrand/{id}")
    public brand showById(@PathVariable long id) {
        return brandRepository.findById(id).orElse(null);
    }
}
