package int222.project.Dora.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties
@Entity
public class user {

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
  @JsonIgnore
  private String password;
  @Getter
  @Setter
  private String role;
  @OneToMany(mappedBy = "user")
  Set<favorite> favorite;

}
