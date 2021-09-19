package int222.project.Dora.Controllers;

import int222.project.Dora.File.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class PictureController {

    final StorageService storageService;

    @Autowired
    public PictureController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public void uploadFile(MultipartFile file) {
        storageService.store(file);
        System.out.print("You ca upload file" + file);
    }

    @GetMapping(value = "/file/{filename}", produces = MediaType.IMAGE_PNG_VALUE)
    public Resource serveFile(String filename) {
        return storageService.loadAsResource(filename);
    }

    @DeleteMapping(value = "/deletefile", produces = MediaType.IMAGE_PNG_VALUE)
    public void deleteFile(String filename) throws IOException {
        storageService.delete(filename);
    }
}
