package int222.project.Dora.Controllers;

import int222.project.Dora.Exception.LoginException;
import int222.project.Dora.Models.user;
import int222.project.Dora.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login/")
    public user logIn(@RequestParam("username") String username,
                      @RequestParam("pwd") String pwd) {
        try {
        user login = userRepository.findByUserNameAndPassword(username, pwd);
        login.setPassword("********");
        return login;
        }catch (Exception e){
            throw new LoginException("Invalid Username or Password");
        }
    }
    @PostMapping("/register/")
    public boolean register(@RequestParam("username") String username,
                         @RequestParam("firstname") String firstname,
                         @RequestParam("lastname") String lastname,
                         @RequestParam("password") String pwd) {
        if (checkUsername(username)) {
            user newUser = new user();
            newUser.setUserName(username);
            newUser.setName(firstname);
            newUser.setLastName(lastname);
            newUser.setPassword(pwd);
            newUser.setRole("customer");
            userRepository.save(newUser);
            System.out.println(newUser.getUserId());
            return true;
        } else{
            System.out.println("already username");
            return false;
        }
    }

    @GetMapping("/checkusername/")
    public boolean checkUsername(@RequestParam("username") String username){
        try {
            String usernames = userRepository.findByUserName(username).getUserName();
            return username == usernames;
        }catch (Exception ex){
            return true;
        }
    }
}
