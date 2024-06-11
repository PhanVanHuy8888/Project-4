package project4.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RoleResponse {
    private String name;
    private String description;

}
