package int222.project.Dora.Controllers;

import int222.project.Dora.Models.user;
import int222.project.Dora.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SuperAdminController {
    @Autowired
    UserRepository userRepository;

    public List<user> showallUser(){
        List<user> alluser = userRepository.findAll();
        return alluser;
    }
    @PutMapping("/PromoteRole")
    public void changeRole(@RequestParam("idUser") long idUser,
                           @RequestParam("Role") String role){
        user Roleuser = userRepository.findById(idUser).orElse(null);
        Roleuser.setRole(role);
        userRepository.save(Roleuser);
    }
}
