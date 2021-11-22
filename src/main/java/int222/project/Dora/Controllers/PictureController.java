package int222.project.Dora.Controllers;

import int222.project.Dora.File.StorageService;
import int222.project.Dora.Models.productColor;
import int222.project.Dora.Repositories.ProductColorRepository;
import int222.project.Dora.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin
@RestController
public class PictureController {

    final StorageService storageService;
    @Autowired
    ProductColorRepository productColorRepository;

    @Autowired
    public PictureController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("upload") MultipartFile file) {
        storageService.store(file);
        System.out.print("You ca upload file" + file);
    }

    @GetMapping(value = "/getfirstpic/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public Resource getproductpic1File(@PathVariable Long id) {
        productColor[] pdc = productColorRepository.findAllByProductId(id);
        String filename = pdc[0].getImageName();
        return storageService.loadAsResource(filename);
    }

    @GetMapping(value = "/file/{filename}", produces = MediaType.IMAGE_PNG_VALUE)
    public Resource serveFile(@PathVariable String filename) {
        return storageService.loadAsResource(filename);
    }

    @GetMapping(value = "/AllFilebyProductID/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public Resource[] serveFilewithArrays(@PathVariable Long id){
        productColor productColors[] = productColorRepository.findAllByProductId(id);
        String[] images = new String[productColors.length];
        for (int i = 0; i < productColors.length; i++) {
            images[i] = productColors[i].getImageName();
        }
        Resource[] pics = new Resource[images.length];
        for (int i = 0; i < images.length; i++) {
            pics[i] = storageService.loadAsResource(images[i]);
        }
        return pics;
    }

    @DeleteMapping(value = "/deletefile", produces = MediaType.IMAGE_PNG_VALUE)
    public void deleteFile(@RequestParam("deleteimages") String filename) throws IOException {
        storageService.delete(filename);
    }
}
