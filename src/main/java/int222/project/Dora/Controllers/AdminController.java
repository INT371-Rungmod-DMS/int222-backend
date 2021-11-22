package int222.project.Dora.Controllers;

import int222.project.Dora.File.StorageService;
import int222.project.Dora.Models.product;
import int222.project.Dora.Models.productColor;
import int222.project.Dora.Repositories.ProductColorRepository;
import int222.project.Dora.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "http://172.19.0.1")
@RestController
public class AdminController {
    @Autowired
    ProductColorRepository productColorRepository;
    @Autowired
    ProductRepository productRepository;
    final StorageService storageService;

    @Autowired
    public AdminController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/add")
    public Long addProduct(@RequestParam("productname") String productname,
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
        return newproduct.getProductId();
    }

    @PostMapping("/addColorImage")
    public void addProductColorImage(@RequestParam("productid") Long productid,
                                @RequestParam("colorid") Long colorid,
                                @RequestParam("stock") int stock,
                                @RequestParam("images") String imageName){
        productColor addcolor = new productColor();
        addcolor.setProductId(productid);
        addcolor.setColorId(colorid);
        addcolor.setStock(stock);
        addcolor.setImageName(imageName);
        productColorRepository.save(addcolor);
        System.out.println("Product ID: " + productid + " add new color is " + colorid + " image name is " + addcolor.getImageName());
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
    public void delete(@RequestParam("deleteproductid") Long id) {
        product pdc = productRepository.findById(id).orElse(null);
        int check = productColorRepository.countAllByProductId(id);
        System.out.println("productcolor: " + check);
        if (check != 0) {
            productColor dpc[] = productColorRepository.findAllByProductId(id);
            for (int i = 0; i < dpc.length; i++) {
                productColorRepository.delete(dpc[i]);
            }
        }
        productRepository.deleteById(id);
        System.out.println("Delete product id: " + id + " success");
    }

    @PutMapping("/editStock")
    public void editStock(@RequestParam("idProductColor") Long id,
                          @RequestParam("stock") int stock){
        productColor editStock = productColorRepository.findById(id).orElse(null);
        editStock.setStock(stock);
        productColorRepository.save(editStock);
        System.out.println("Change stock id: " + id + "to " + stock);
    }
}
