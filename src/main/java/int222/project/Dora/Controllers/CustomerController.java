package int222.project.Dora.Controllers;


import int222.project.Dora.Models.favorite;
import int222.project.Dora.Models.product;
import int222.project.Dora.Models.user;
import int222.project.Dora.Repositories.FavoriteRepository;
import int222.project.Dora.Repositories.ProductRepository;
import int222.project.Dora.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://172.19.0.1")
@RestController
public class CustomerController {

    @Autowired
    FavoriteRepository favoriteRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}/MyFav/")
    public List<favorite> showBrand(@PathVariable("id") Long id) {
        List<favorite> pageResult = favoriteRepository.findAllByUserId(id);
        return pageResult;
    }

    @PostMapping("/{id}/AddFav/")
    public void favorite(@RequestParam("productId") Long idProduct,
                         @PathVariable("id") Long id) {
        product favorite = productRepository.findById(idProduct).orElse(null);
        long productId = favorite.getProductId();
        System.out.println(productId);
        user userAdd = userRepository.findById(id).orElse(null);
        long userId = userAdd.getUserId();
        favorite newFav = new favorite();
        newFav.setProductId(productId);
        newFav.setUserId(userId);
        System.out.println(newFav);
        System.out.println(newFav.getUserId());
        System.out.println(newFav.getProductId());
        favoriteRepository.save(newFav);
    }

    @DeleteMapping("/{id}/DeleteFav/")
    public void removeFav(@RequestParam("favoriteId") long favoriteId,
                          @PathVariable("id") long id) {
        user userAdd = userRepository.findById(id).orElse(null);
        long userId = userAdd.getUserId();
        favorite fav = favoriteRepository.findById(favoriteId).orElse(null);
        if (userId == fav.getUserId()) {
            favoriteRepository.delete(fav);
        }
    }
}
