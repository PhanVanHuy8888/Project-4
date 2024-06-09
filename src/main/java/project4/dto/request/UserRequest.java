package project4.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String password;

    private String address;

    private LocalDate birthday;

    private String gender;

}
