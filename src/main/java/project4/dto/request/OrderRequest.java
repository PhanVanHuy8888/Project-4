package project4.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderRequest {

    private String code;

    private String phone;
    private String customer;

    private String address;

    private String productName;

    private String status;

    private int quantity;

    private float total;

    private Date createDate;

}
