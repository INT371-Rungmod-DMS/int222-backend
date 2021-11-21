package int222.project.Dora.Controllers;

import int222.project.Dora.Models.user;
import int222.project.Dora.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class SuperAdminController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/showalluser")
    public List<user> showallUser(){
        List<user> alluser = userRepository.findAll();
        return alluser;
    }
    @PutMapping("/PromoteRole")
    public void changeRole(@RequestParam("idUser") long idUser,
                           @RequestParam("Role") int role){
        user Roleuser = userRepository.findById(idUser).orElse(null);
        switch (role){
            case 1:
                Roleuser.setRole("admin");
                break;
            case 0:
                Roleuser.setRole("customer");
                break;
        }
        userRepository.save(Roleuser);
    }

    @DeleteMapping("/DeleteUser")
    public void deleteUser(@RequestParam("idUser") long idUser){
        user deleteuser = userRepository.findById(idUser).orElse(null);
        System.out.println(deleteuser.getUserId() + " has been deleted");
        userRepository.delete(deleteuser);;
    }
}
