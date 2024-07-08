package project4.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
public class UserRequest implements Serializable {

    private String userName;

    @Email
    private String email;

    private String phone;

    private String password;

    private String address;

    private LocalDate birthday;

    private String gender;

    private Set<String> roles;

}
