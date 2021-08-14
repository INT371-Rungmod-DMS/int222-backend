package int222.project.Dora.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Favorite {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  @Setter
  private long favoriteId;
  @Getter
  @Setter
  private long userId;
  @Getter
  @Setter
  private long productColorId;
  @ManyToOne
  @JoinColumn(name = "userid")
  private User user;
  @ManyToOne
  @JoinColumn(name = "productColorid")
  private ProductColor productColor;

}
