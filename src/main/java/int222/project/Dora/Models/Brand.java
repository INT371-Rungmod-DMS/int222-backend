package int222.project.Dora.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brand {

  @Id
  @Getter
  @Setter
  private long brandId;
  @Getter
  @Setter
  private String brandName;

}
