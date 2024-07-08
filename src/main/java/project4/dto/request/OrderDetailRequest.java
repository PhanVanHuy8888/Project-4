package project4.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderDetailRequest {
    private String productName;
    private int quantity;
    private float price;
}
