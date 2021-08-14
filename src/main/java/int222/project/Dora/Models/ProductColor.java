package int222.project.Dora.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductColor {

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
  private long stock;
  @Getter
  @Setter
  private String imageName;
  @ManyToOne
  @JoinColumn(name = "productid")
  private Product product;
  @ManyToOne
  @JoinColumn(name = "colorid")
  private Color color;
  @OneToMany(mappedBy = "ProductColor")
  Set<Favorite> favorite;
}
