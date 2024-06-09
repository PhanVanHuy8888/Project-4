package project4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String userName;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String phone;

    private String address;

    private Date birthday;

    private String gender;


    @ManyToMany
    Set<Role> roles;
}
