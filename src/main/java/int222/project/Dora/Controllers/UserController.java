package int222.project.Dora.Controllers;

import int222.project.Dora.Models.user;
import int222.project.Dora.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/showuser")
    public List<user> allProduct(@RequestParam(defaultValue = "0") Integer pageNo,
                                 @RequestParam(defaultValue = "50") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<user> pageResult = userRepository.findAll(pageable);
        return pageResult.getContent();
    }

    @GetMapping("/{id}/showuser")
    public user showUserByid(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}/editProfile")
    public void editProfile(@PathVariable Long id,
                            @RequestParam("username") String username,
                            @RequestParam("name") String name,
                            @RequestParam("lastname") String lastname) {
        user editProfile = userRepository.findById(id).orElse(null);
        editProfile.setName(username);
        editProfile.setLastName(name);
        editProfile.setLastName(lastname);
        userRepository.save(editProfile);
        System.out.println("Change profile id: " + editProfile.getUserId());
        System.out.println("Username change to " + editProfile.getUserName());
        System.out.println("Firstname change to " + editProfile.getName());
        System.out.println("Lastname change to " + editProfile.getLastName());
    }

    @PutMapping("/{id}/profile/ChangePWD")
    public void changPWD(@PathVariable Long id,
                         @RequestParam("password") String pwd) {
        user changePWD = userRepository.findById(id).orElse(null);
        changePWD.setPassword(pwd);
        userRepository.save(changePWD);
        System.out.println("Change password success");
    }
}