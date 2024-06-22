package project4.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project4.dto.request.CartRequest;
import project4.entity.Cart;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(target = "sum", ignore = true)
    Cart toCart(CartRequest request);
}
