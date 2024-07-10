package project4.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project4.dto.request.OrderRequest;
import project4.dto.response.OrderReponse;
import project4.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "status", ignore = true)
    @Mapping(target = "code", ignore = true)
    Order createOrder(OrderRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "code", source = "code")
    @Mapping(target = "customerName", source = "customerName")
    OrderReponse toOrder(Order order);
}
