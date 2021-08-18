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

    @PostMapping("/add")
    public void addProduct(@RequestParam("productname") String productname,
                           @RequestParam("price") double price,
                           @RequestParam("warranty") String warranty,
                           @RequestParam("menufacturrerdate") java.sql.Date menufacturrerdate,
                           @RequestParam("description") String description,
                           @RequestParam("size") String size,
                           @RequestParam("brandId") Long brandId) {
        product newproduct = new product();
        newproduct.setProductName(productname);
        newproduct.setPrice(price);
        newproduct.setWarranty(warranty);
        newproduct.setMenufacturrerdate(menufacturrerdate);
        newproduct.setDescription(description);
        newproduct.setSize(size);
        newproduct.setBrandId(brandId);
        productRepository.save(newproduct);
        System.out.println("Add new product ID is " + newproduct.getProductId());
    }

    @PutMapping("/edit/{id}")
    public void editProduct(@PathVariable Long id,
                            @RequestParam("productname") String productname,
                            @RequestParam("price") double price,
                            @RequestParam("warranty") String warranty,
                            @RequestParam("menufacturrerdate") java.sql.Date menufacturrerdate,
                            @RequestParam("description") String description,
                            @RequestParam("size") String size,
                            @RequestParam("brandId") Long brandId) {
        product editproduct = productRepository.findById(id).orElse(null);
        editproduct.setProductName(productname);
        editproduct.setPrice(price);
        editproduct.setWarranty(warranty);
        editproduct.setMenufacturrerdate(menufacturrerdate);
        editproduct.setDescription(description);
        editproduct.setSize(size);
        editproduct.setBrandId(brandId);
        productRepository.save(editproduct);
        System.out.println("Edit product ID is " + editproduct.getProductId());
    }

    @DeleteMapping("/deleteproductid")
    public void delete(@RequestParam("deleteproductid") long id) {
        productRepository.deleteById(id);
        System.out.println("Delete product id: " + id + " success");
    }
}
