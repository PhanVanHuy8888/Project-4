package project4.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private String name;

//    private MultipartFile image;

    private Float price;

    private String description;

    private int quantity;

    private String categoryName;

    private Boolean isActive;

}
