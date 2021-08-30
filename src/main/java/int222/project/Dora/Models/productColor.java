package int222.project.Dora.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class productColor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  @Setter
  private long productColorId;
  @Getter
  @Setter
  private long productId;
  @Getter
  @Setter
  private long colorId;
  @Getter
  @Setter
  private int stock;
  @Getter
  @Setter
  private String imageName;
  @ManyToOne
  @JoinColumn(name = "productId",insertable = false,updatable = false)
  private product Product;
  @ManyToOne
  @JoinColumn(name = "colorId",insertable = false,updatable = false)
  private color Color;
  @OneToMany(mappedBy = "ProductColor")
  Set<favorite> Favorite;
}
