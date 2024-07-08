package project4.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@AllArgsConstructor
public class OrderRequest implements Serializable {

    private String code;
    private String phone;
    private String customerName;
    private String address;
    private String status;
    private float total;
    private List<OrderDetailRequest> orderDetails;

}
