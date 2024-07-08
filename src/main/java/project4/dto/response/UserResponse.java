package project4.dto.response;


import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
public class UserResponse implements Serializable {
    private String id;

    private String userName;

    private String email;

    private String phone;

    private String address;

    private Date birthday;

    private String gender;

}
