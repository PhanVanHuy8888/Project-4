package project4.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class UserRequest {

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
