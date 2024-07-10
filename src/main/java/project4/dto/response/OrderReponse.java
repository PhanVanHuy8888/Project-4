package project4.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderReponse {
    private Long id;
    private String code;
    private String customerName;
    private String status;

}
