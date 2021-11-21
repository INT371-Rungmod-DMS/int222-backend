package int222.project.Dora.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.User;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@JsonIgnoreProperties
@Table(name = "user")
@Entity
@Getter
@Setter
public class user implements Serializable {
    public user() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String name;
    private String lastName;
    @JsonIgnore
    private String password;
    private String role;
    @OneToMany(mappedBy = "user")
    Set<favorite> favorite;
}