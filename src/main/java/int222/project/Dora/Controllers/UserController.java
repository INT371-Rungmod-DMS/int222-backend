package int222.project.Dora.Controllers;

import int222.project.Dora.Models.user;
import int222.project.Dora.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
    public boolean editProfile(@PathVariable Long id,
                               @RequestParam("username") String username,
                               @RequestParam("name") String name,
                               @RequestParam("lastname") String lastname) {
        user editProfile = userRepository.findById(id).orElse(null);
        editProfile.setUserName(username);
        editProfile.setName(name);
        editProfile.setLastName(lastname);
        userRepository.save(editProfile);
        System.out.println("Change profile id: " + editProfile.getUserId());
        System.out.println("Username change to " + editProfile.getUserName());
        System.out.println("Firstname change to " + editProfile.getName());
        System.out.println("Lastname change to " + editProfile.getLastName());
        return true;
    }

}
