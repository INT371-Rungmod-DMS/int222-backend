package int222.project.Dora.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

  @Id
  @Getter
  @Setter
  private long productId;
  @Getter
  @Setter
  private String productName;
  @Getter
  @Setter
  private double price;
  @Getter
  @Setter
  private String warranty;
  @Getter
  @Setter
  private java.sql.Date menufacturrerdate;
  @Getter
  @Setter
  private String description;
  @Getter
  @Setter
  private String size;
  @Getter
  @Setter
  private long brandId;

}
