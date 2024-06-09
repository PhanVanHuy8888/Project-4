package project4.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String address;

    private Date birthday;

    private String gender;

}
