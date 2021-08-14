package int222.project.Dora.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Favorite {

  @Id
  @Getter
  @Setter
  private long favoriteId;
  @Getter
  @Setter
  private long userId;
  @Getter
  @Setter
  private long productColorId;

}
