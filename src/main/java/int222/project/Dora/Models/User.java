package int222.project.Dora.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  @Setter
  private long userId;
  @Getter
  @Setter
  private String userName;
  @Getter
  @Setter
  private String name;
  @Getter
  @Setter
  private String lastName;
  @Getter
  @Setter
  private String password;
  @Getter
  @Setter
  private String role;
  @OneToMany(mappedBy = "User")
  Set<int222.project.Dora.Models.Favorite> Favorite;

}
