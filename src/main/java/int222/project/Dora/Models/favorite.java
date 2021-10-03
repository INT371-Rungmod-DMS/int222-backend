package int222.project.Dora.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class favorite {

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
  private long productId;
  @ManyToOne
  @JoinColumn(name = "userId",insertable = false,updatable = false)
  private user user;
  @ManyToOne
  @JoinColumn(name = "productId",insertable = false,updatable = false)
  private product product;

}
