package project4.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String name;

    private String image;

    private Float price;

    private String description;

    private int quantity;

    private int categoryId;

    private Boolean isActive;

}
