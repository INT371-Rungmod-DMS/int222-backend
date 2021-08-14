package int222.project.Dora.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductColor {

  @Id
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

}
