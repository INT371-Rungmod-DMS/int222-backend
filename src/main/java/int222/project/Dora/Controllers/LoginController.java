package int222.project.Dora.Controllers;

import int222.project.Dora.Models.user;
import int222.project.Dora.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {
    @Autowired
    UserRepository userRepository;

    public user logIn(@RequestParam("username") String username,
                      @RequestParam("pwd") String pwd) {
        user findUser = userRepository.findByUserName(username);
        userRepository.findByPassword(findUser.getPassword());
        user logInUser = (pwd == findUser.getPassword() ? findUser : null);
        return logInUser;
    }

    public void register(@RequestParam("username") String username,
                         @RequestParam("firstname") String firstname,
                         @RequestParam("lastname") String lastname,
                         @RequestParam("password") String pwd) {
        user newUser = new user();
        newUser.setUserName(username);
        newUser.setName(firstname);
        newUser.setLastName(lastname);
        newUser.setPassword(pwd);
        userRepository.save(newUser);
    }
}
