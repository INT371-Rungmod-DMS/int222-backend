package int222.project.Dora.Controllers;


import int222.project.Dora.Models.favorite;
import int222.project.Dora.Models.productColor;
import int222.project.Dora.Models.user;
import int222.project.Dora.Repositories.FavoriteRepository;
import int222.project.Dora.Repositories.ProductColorRepository;
import int222.project.Dora.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {

    @Autowired
    FavoriteRepository favoriteRepository;
    @Autowired
    ProductColorRepository productColorRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}/MyFav/")
    public List<favorite> showBrand(@PathVariable("id") Long id) {
        List<favorite> pageResult = favoriteRepository.findAllByUserId(id);
        return pageResult;
    }

    @PostMapping("/{id}/AddFav/")
    public void favorite(@RequestParam("idProductColor") Long idProductColor,
                         @PathVariable("id") Long id) {
        productColor favorite = productColorRepository.findById(idProductColor).orElse(null);
        long productColorid = favorite.getProductColorId();
        System.out.println(productColorid);
        user userAdd = userRepository.findById(id).orElse(null);
        long userId = userAdd.getUserId();
        favorite newFav = new favorite();
        newFav.setProductColorId(productColorid);
        newFav.setUserId(userId);
        System.out.println(newFav);
        System.out.println(newFav.getUserId());
        System.out.println(newFav.getProductColorId());
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
