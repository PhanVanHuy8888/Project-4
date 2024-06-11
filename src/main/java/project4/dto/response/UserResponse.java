package project4.dto.response;


import lombok.*;

import java.util.Date;

@Builder
@Getter
public class UserResponse {

    private String userName;

    private String email;

    private String phone;

    private String address;

    private Date birthday;

    private String gender;

}
