package int222.project.Dora.Controllers;

import int222.project.Dora.Exception.LoginException;
import int222.project.Dora.Models.user;
import int222.project.Dora.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

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
        String encodepassword = bCryptPasswordEncoder.encode(pwd);
        if (checkUsername(username)) {
            user newUser = new user();
            newUser.setUserName(username);
            newUser.setName(firstname);
            newUser.setLastName(lastname);
            newUser.setPassword(encodepassword);
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

    @PutMapping("/{id}/profile/ChangePWD")
    public boolean changPWD(@PathVariable("id") Long id,
                         @RequestParam("newPassword") String newpwd,
                         @RequestParam("oldPassword") String oldpwd) {
        user changePWD = userRepository.findById(id).orElse(null);
        if (bCryptPasswordEncoder.matches(oldpwd, changePWD.getPassword())) {
            String encodePWD = bCryptPasswordEncoder.encode(newpwd);
            changePWD.setPassword(encodePWD);
            userRepository.save(changePWD);
            System.out.println("Change password success");
            return true;
        }else {
            System.out.println("Please check your password");
            return false;
        }
    }

    @PutMapping(value = "/{id}/profile/CheckPWD")
    public boolean checkPWD(@PathVariable("id") Long id,
                         @RequestParam("newPassword") String newpwd,
                         @RequestParam("oldPassword") String oldpwd) {
        user changePWD = userRepository.findById(id).orElse(null);
        return bCryptPasswordEncoder.matches(oldpwd, changePWD.getPassword());
    }
}
