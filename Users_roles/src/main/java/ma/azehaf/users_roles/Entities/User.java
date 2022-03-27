package ma.azehaf.users_roles.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "USERS")
@Data @AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(unique = true, length = 20)
    private String userName;
    private String password;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();



}
