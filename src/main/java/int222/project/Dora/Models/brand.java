package int222.project.Dora.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class brand {

  @Id
  @Getter
  @Setter
  private long brandId;
  @Getter
  @Setter
  private String brandName;
  @OneToMany(mappedBy = "brand")
  Set<product> product;

}
