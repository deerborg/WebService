package art.dborg.webservice.v1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",columnDefinition = "serial")
    private long id;

    @Column(name = "user_username",unique = true)
    private String username;

    @Column(name = "user_email",unique = true)
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_active")
    private boolean active = false;

    @Column(name = "user_active_token",unique = true)
    private String token;
}
